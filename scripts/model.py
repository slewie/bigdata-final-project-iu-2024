"""
    Recommendation System in PySpark
    Model1: ALS from PySpark library
    Model2: recommendation using SVD factorization
"""
import os
import warnings
import numpy as np
from tqdm import tqdm

from pyspark.ml.recommendation import ALS
from pyspark.ml import Pipeline
from pyspark.ml.feature import StringIndexer
from pyspark.ml.evaluation import RegressionEvaluator
from pyspark.ml.tuning import ParamGridBuilder, CrossValidator

from pyspark.sql import SparkSession
from pyspark.sql.functions import col, expr
import pyspark.sql.functions as F
from pyspark.sql import Window
from pyspark.sql.types import (
    StructField,
    StructType,
    FloatType,
    IntegerType,
)

from pyspark.mllib.evaluation import RankingMetrics
from pyspark.mllib.linalg.distributed import RowMatrix
from pyspark.mllib.linalg import SparseVector

warnings.filterwarnings('ignore')

class Model2:
    """
        Recommendation System model.
        it's uses SVD factorization for the recommending new views.
    """
    def __init__(
        self,
        user_col,
        item_col,
        rating_col,
        num_rank=10,
    ):
        self.user_col = user_col
        self.item_col = item_col
        self.num_items = None
        self.rating_col = rating_col
        self.num_rank = num_rank
        self.mat = None
        self.user_vectors = None
        self.item_v = None
        self.singular_values = None
        self.dataframe = None
        self.item2id = None
        self.user2id = None

    def fit(self, dataframe):
        """ Fit the Model with the given dataset.
        args:
            dataframe: PySpark DataFrame consisting of `user_id`, `item_id`, `rating`

        return:
            self (Model2)
        """

        # assign for each item and user it ids
        dataframe = dataframe.withColumn(
            "model_user_id", F.dense_rank().over(Window.orderBy(self.user_col))-1)
        dataframe = dataframe.withColumn(
            "model_item_id", F.dense_rank().over(Window.orderBy(self.item_col))-1)

        # get number of items
        self.num_items = dataframe.select(self.item_col).distinct().count()

        # Convert the DataFrame into user-item matrix
        user_item_rdd = dataframe.rdd.map(lambda row: (
            row['model_user_id'], (row['model_item_id'], row[self.rating_col])
        ))
        grouped_user_item_rdd = user_item_rdd.groupByKey().mapValues(list)
        grouped_user_item_rdd = grouped_user_item_rdd.map(
            self._get_sparse_vector
        )

        # Compute SVD
        self.mat = RowMatrix(grouped_user_item_rdd)
        svd = self.mat.computeSVD(k=self.num_rank, computeU=True)

        # save U, s, V martrices
        self.user_vectors = np.array([vec.toArray() for vec in svd.U.rows.collect()])
        self.item_v = svd.V.toArray()
        self.singular_values = svd.s.toArray()
        self.dataframe = dataframe  # save this dataframe

        # save item2id, user2id dict
        self.item2id = {row[0]: row[1] for row in self.dataframe.select(
            [self.item_col, 'model_item_id']
        ).collect()}

        self.user2id = {row[0]: row[1] for row in self.dataframe.select(
            [self.user_col, 'model_user_id']
        ).collect()}

        return self

    def _get_sparse_vector(self, row):
        _, item_ratings = row
        sparse = {}
        for item_id, rating in item_ratings:
            if rating > 0:
                sparse[item_id] = rating

        return SparseVector(self.num_items, sparse)

    def transform(self, testing_df):
        """ Make prediction for given `user_id` and `item_id`
        args:
            testing_df: PySpark DataFrame consisting of user_id, item_id, rating
        return:
            dataframe: return prediction with user_id, item_id, rating.
        """

        # for each user item pair predict the rating
        user_item = [(row[0], row[1], row[2]) for row in testing_df.select([
            self.user_col, self.item_col, self.rating_col
        ]).collect()]
        dataframe = []
        for user, item, rating in user_item:
            if user not in self.user2id:
                continue
            dataframe.append([
                user,
                item,
                rating,
                float(self.recommend_for_user(user, self.num_items)[int(item)][0])
            ])

        schema = StructType([
            StructField("user_id", FloatType(), True),
            StructField("item_id", FloatType(), True),
            StructField("recommended", IntegerType(), True),
            StructField("prediction", FloatType(), True),
        ])
        return self.dataframe.sql_ctx.createDataFrame(dataframe, schema=schema)

    def recommend_for_user(self, user_id, num_recommendations=10):
        """ Recommend a certain number of items for a given user
        args:
            user_id: id of a user to give recommedations
            num_recommendations: number of recommendations to give for user_id
        return:
            list(prediction, item_id): predicted rating and item_id
        """
        # check for user id
        model_user_id = self.user2id.get(user_id, None)
        if model_user_id is None:
            raise ValueError(f"given user_id ({user_id}) does not exists")

        predictions = np.dot(
            self.user_vectors[model_user_id],
            np.dot(np.diag(self.singular_values), self.item_v.T)
        )
        predictions = sorted(
            zip(predictions, self.item2id.keys()),
            reverse=True
        )
        return predictions[:num_recommendations]

    def recommendForAllUsers(self, num_recommendations=10, return_scores=False):
        """ Recommend items for all users
        args:
            num_recommendations: number of recommendations to give for each user
        return:
            dataframe: PySpark DataFrame of top num_recommendations item for each user.
        """
        predictions = np.dot(
            self.user_vectors,
            np.dot(np.diag(self.singular_values), self.item_v.T)
        )
        predictions = [sorted(
            zip(p, self.item2id.keys()), reverse=True
        )[:num_recommendations] for p in predictions]

        if return_scores:
            return predictions

        predictions = [[item for sc, item in p] for p in predictions]
        return self.dataframe.sql_ctx.createDataFrame(
            zip(self.user2id.keys(), predictions), ['user_id', 'recommendations']
        )

    def __str__(self):
        return f"SVD: k={self.num_rank}"

    def save_weights(self, path):
        """ Method to save weights of the model
        args:
            path: where to save the weights
        """
        try:
            # save matrices produced after computeSVD
            self.mat.rows.toDF().write().overwrite().save(path)
        except FileNotFoundError:
            print("Incorrect path file.")

def calc_metrics(
    model,
    predictions,
    testing_df,
    flat_recommendations=True,
    print_recommendations=True
):
    """
    Method calculates metrics
    """
    # calculate RMSE
    evaluator = RegressionEvaluator(
        metricName="rmse", labelCol="recommended", predictionCol="prediction"
    )

    # calculate Mean Average Precision and NDCG
    app_recommendations = model.recommendForAllUsers(10)

    # Create ground truth DataFrame containing actual interactions
    ground_truth = testing_df.filter(col('recommended') == 1).groupBy("user_id") \
        .agg(expr("collect_set(item_id) as actual_apps"))

    # Join recommendations with ground truth
    recommendations_with_truth = app_recommendations.join(
        ground_truth,
        ground_truth.user_id == app_recommendations.user_id,
        "inner"
    )
    recommendations_with_truth = recommendations_with_truth.select(
        [app_recommendations.user_id, 'recommendations', 'actual_apps']
    )

    if flat_recommendations:
        # Convert recommendations and actual_apps to lists
        recommendations_with_truth = recommendations_with_truth.rdd.map(
            lambda row: (
                row.user_id,
                [r.item_id for r in row.recommendations],
                row.actual_apps
            )
        ).toDF(["user_id", "recommendations", "actual_apps"])

    if print_recommendations:
        recommendations_with_truth.show(10, truncate=False)

    # Compute RankingMetrics
    metrics = RankingMetrics(recommendations_with_truth.rdd.map(
        lambda row: (row.recommendations, row.actual_apps))
    )

    # calculate all metrics
    rmse = evaluator.evaluate(predictions)
    map_metric = metrics.meanAveragePrecision
    ndcg = metrics.ndcgAt(10)

    print("RMSE on test data:", rmse)
    print("Mean Average Precision (MAP):", map_metric)
    print("NDCG at 5:", ndcg)

    return rmse, map_metric, ndcg

def run(command):
    """
    read data from the command
    """
    return os.popen(command).read()

def get_data():
    """
    Read data from the Hive tables
    """
    authors = spark.read.format("avro").table('team27_projectdb.authors')
    reviews = spark.read.format("avro").table('team27_projectdb.reviews')
    data = reviews.join(authors, on=reviews.author_steamid == authors.steamid, how='left')

    # replace nan in dataset
    data = data.fillna({
        'review': '',
        'playtime_at_review': 0,
        'playtime_forever': 0,
        'playtime_last_two_weeks': 0,
    })
    return data

def main():
    """
    Main method
    """
    data = get_data()
    target = 'recommended' # rating
    data = data.withColumn(target, data[target].cast('integer'))

    # creating the pipeline
    user_indexer = StringIndexer(inputCol='steamid', outputCol="user_id", handleInvalid="keep")
    item_indexer = StringIndexer(inputCol='app_id', outputCol="item_id", handleInvalid="keep")

    pipeline = Pipeline(stages=[user_indexer, item_indexer])
    pipeline_model = pipeline.fit(data)
    transformed_df = pipeline_model.transform(data).select(['user_id', 'item_id', 'recommended'])

    # Split the dataset
    print("[log]: split the dataset into train and test")
    (training_df, testing_df) = transformed_df.randomSplit([0.8, 0.2], seed=42)

    training_df.select("user_id", "item_id", "recommended")\
        .coalesce(1)\
        .write\
        .mode("overwrite")\
        .format("json")\
        .save("project/data/train")
    # Run it from root directory of the repository
    run("hdfs dfs -cat project/data/train/*.json > data/train.json")

    testing_df.select("user_id", "item_id", "recommended")\
        .coalesce(1)\
        .write\
        .mode("overwrite")\
        .format("json")\
        .save("project/data/test")
    # Run it from root directory of the repository
    run("hdfs dfs -cat project/data/test/*.json > data/test.json")

    # MODEL 1
    als = ALS(
        maxIter=5,
        rank=10,
        regParam=0.01,
        userCol="user_id",
        itemCol="item_id",
        ratingCol=target,
        coldStartStrategy="drop",
        seed=42,
    )
    model = als.fit(training_df)
    predictions = model.transform(testing_df)
    print("Model 1 evaluation:")
    calc_metrics(model, predictions, testing_df, print_recommendations=False)

    # Hyperparameter optimization
    evaluator = RegressionEvaluator(
        metricName="rmse", labelCol="recommended", predictionCol="prediction"
    )

    param_grid = ParamGridBuilder() \
        .addGrid(als.maxIter, [5]) \
        .addGrid(als.rank, np.arange(5, 20+1, 5)) \
        .addGrid(als.regParam, np.linspace(0.01, 1, num=5)) \
        .addGrid(als.implicitPrefs, [False, True]) \
        .build()

    cv_val = CrossValidator(
        estimator=als,
        estimatorParamMaps=param_grid,
        evaluator=evaluator,
        parallelism=5,
        numFolds=3,
        seed=42,
    )
    cv_model = cv_val.fit(training_df)
    best_model1 = cv_model.bestModel

    best_predictions1 = best_model1.transform(testing_df)

    # save the predictions
    best_predictions1.select("recommended", "prediction")\
        .coalesce(1)\
        .write\
        .mode("overwrite")\
        .format("csv")\
        .option("sep", ",")\
        .option("header","true")\
        .save("project/output/model1_predictions.csv")
    # Run it from root directory of the repository
    run("hdfs dfs -cat project/output/model1_predictions.csv/*.csv > output/model1_predictions.csv")

    print("Best Model 1 evaluation:")
    rmse1, map1, ndcg1 = calc_metrics(
        best_model1,
        best_predictions1,
        testing_df,
        print_recommendations=False
    )

    # save best model
    best_model1.write().overwrite().save("project/models/model1")
    # Run it from root directory of the repository
    run("hdfs dfs -get project/models/model1 models/model1")

    # MODEL 2
    # train second model
    print("[log]: training the second model...")
    model2 = Model2(
        user_col='user_id',
        item_col='item_id',
        rating_col='recommended',
        num_rank=10,
    )
    model2.fit(training_df)

    # predict on test set
    print("[log]: predicting the testing dataframe...")
    model2_predictions = model2.transform(testing_df)

    print("[log]: MODEL 2 evaluation:")
    calc_metrics(
        model2,
        model2_predictions,
        testing_df,
        flat_recommendations=False,
        print_recommendations=False
    )

    # MODEL 2 Hyperparameter optimization
    # parameters to optimizer
    param_k = [5, 10, 15, 20, 30]

    models = []
    for k in tqdm(param_k, total=len(param_k)):
        model2_init = Model2(
            user_col='user_id',
            item_col='item_id',
            rating_col='recommended',
            num_rank=k
        )
        model2_init.fit(training_df)
        predictions = model2_init.transform(testing_df)

        rmse, map_metric, ndcg_metric = calc_metrics(
            model2_init,
            predictions,
            testing_df,
            print_recommendations=False,
            flat_recommendations=False
        )
        models.append({
            'rmse': rmse,
            'MAP': map_metric,
            'NDCG': ndcg_metric,
            'k': k,
            'model': model2_init,
        })


    # get best model
    best_model2 = min(models, key=lambda x: x['rmse'])
    rmse2 = best_model2['rmse']
    map2 = best_model2['MAP']
    ndcg2 = best_model2['NDCG']
    k = best_model2['k']
    best_model2 = best_model2['model']
    print(f"metrics for k={k}, rmse2={rmse2}, map2={map2}, ndcg2={ndcg2}")

    # predict on test set
    model2_predictions = best_model2.transform(testing_df)

    model2_predictions.select("recommended", "prediction")\
        .coalesce(1)\
        .write\
        .mode("overwrite")\
        .format("csv")\
        .option("sep", ",")\
        .option("header","true")\
        .save("project/output/model2_predictions.csv")

    # Run it from root directory of the repository
    run("hdfs dfs -cat project/output/model2_predictions.csv/*.csv > output/model2_predictions.csv")

    # save the weight of the model
    best_model2.save_weights('project/models/model2')
    # Run it from root directory of the repository
    run("hdfs dfs -get project/models/model2 models/model2")

    # Compare best models
    # Create data frame to report performance of the models
    models = [
        [str(best_model1).replace(",", "|"), rmse1, map1, ndcg1],
        [str(best_model2), rmse2, map2, ndcg2]
    ]

    evaluation_results = spark.createDataFrame(models, ["model", "RMSE", "MAP", "NDCG"])
    evaluation_results.show(truncate=False)

    # Save it to HDFS
    evaluation_results.coalesce(1)\
        .write\
        .mode("overwrite")\
        .format("csv")\
        .option("sep", ",")\
        .option("header","true")\
        .save("project/output/evaluation.csv")

    # Run it from root directory of the repository
    run("hdfs dfs -cat project/output/evaluation.csv/*.csv > output/evaluation.csv")

if __name__ == "__main__":
    # Connect to Hive
    TEAM = 'team27'
    WAREHOUSE = "project/hive/warehouse"
    spark = SparkSession.builder\
            .appName(f"{TEAM} - spark ML")\
            .master("yarn")\
            .config("hive.metastore.uris", "thrift://hadoop-02.uni.innopolis.ru:9883")\
            .config("spark.sql.warehouse.dir", WAREHOUSE)\
            .config("spark.sql.avro.compression.codec", "snappy")\
            .enableHiveSupport()\
            .getOrCreate()

    main()
