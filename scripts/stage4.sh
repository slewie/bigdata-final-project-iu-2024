hdfs dfs -rm -r project/hive/warehouse/evaluation
hdfs dfs -rm -r project/hive/warehouse/model1_predictions
hdfs dfs -rm -r project/hive/warehouse/model2_predictions

hdfs dfs -mkdir project/hive/warehouse/evaluation
hdfs dfs -mkdir project/hive/warehouse/model1_predictions
hdfs dfs -mkdir project/hive/warehouse/model2_predictions

hdfs dfs -put output/evaluation.csv project/hive/warehouse/evaluation
hdfs dfs -put output/model1_predictions.csv project/hive/warehouse/model1_predictions
hdfs dfs -put output/model2_predictions.csv project/hive/warehouse/model2_predictions

password=$(head -n 1 secrets/.psql.pass)
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team27 -p $password -f sql/evaluation.hql > /dev/null 2> /dev/null
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team27 -p $password -f sql/model1_predictions.hql > /dev/null 2> /dev/null
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team27 -p $password -f sql/model2_predictions.hql > /dev/null 2> /dev/null
