khdfs dfs -mkdir -p project/warehouse/avsc
hdfs dfs -put output/*.avsc project/warehouse/avsc

password=$(head -n 1 secrets/.psql.pass)
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team27 -p $password -f sql/db.hql > output/hive_results.txt 2> /dev/null
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team27 -p $password -f sql/authorsOptimize.hql > output/author_buc_hive_results.txt 2> /dev/null
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team27 -p $password -f sql/reviewsOptimize.hql > output/review_part_hive_results.txt 2> /dev/null
sh stage2.1.sh
sh stage2.2.sh
sh stage2.3.sh
sh stage2.4.sh
sh stage2.5.sh

