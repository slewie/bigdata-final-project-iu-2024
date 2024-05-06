password=$(head -n 1 secrets/.psql.pass)
rm output/q5.csv
hdfs dfs -rm -r project/hive/warehouse/q5
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team27 -p $password -f sql/q5.hql
echo "appname,game_corr_comment_votes" > output/q5.csv 
hdfs dfs -cat project/output/q5/* >> output/q5.csv