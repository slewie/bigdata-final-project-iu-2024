password=$(head -n 1 secrets/.psql.pass)
rm output/q1.csv
hdfs dfs -rm -r project/hive/warehouse/q1
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team27 -p $password -f sql/q1.hql
echo "appname,total_recommended" > output/q1.csv 
hdfs dfs -cat project/output/q1/* >> output/q1.csv