password=$(head -n 1 secrets/.psql.pass)
rm output/q4.csv
hdfs dfs -rm -r project/hive/warehouse/q4
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team27 -p $password -f sql/q4.hql
echo "language,avg_recommends" > output/q4.csv 
hdfs dfs -cat project/output/q4/* >> output/q4.csv