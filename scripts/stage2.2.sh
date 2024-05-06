password=$(head -n 1 secrets/.psql.pass)
rm output/q2.csv
hdfs dfs -rm -r project/hive/warehouse/q2
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team27 -p $password -f sql/q2.hql
echo "mean_game_time,votes_helpful" > output/q2.csv 
hdfs dfs -cat project/output/q2/* >> output/q2.csv