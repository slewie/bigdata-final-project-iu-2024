password=$(head -n 1 secrets/.psql.pass)
rm output/q3.csv
hdfs dfs -rm -r project/hive/warehouse/q3
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team27 -p $password -f sql/q3.hql
echo "avg_votes_up,num_games" > output/q3.csv 
hdfs dfs -cat project/output/q3/* >> output/q3.csv