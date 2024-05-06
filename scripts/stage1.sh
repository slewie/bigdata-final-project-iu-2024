url="https://disk.yandex.ru/d/rlheUI9s6sFHFg"
mkdir -p data
wget "$(yadisk-direct $url)" -O data/data.csv

python3 scripts/build_projectdb.py 

hdfs dfs -rm -r -skipTrash /user/team27/project
hdfs dfs -mkdir -p /user/team27/project
hdfs dfs -mkdir -p /user/team27/project/warehouse
password=$(head -n 1 secrets/.psql.pass)
sqoop list-databases --connect jdbc:postgresql://hadoop-04.uni.innopolis.ru/team27_projectdb --username team27 --password $password
sqoop list-tables --connect jdbc:postgresql://hadoop-04.uni.innopolis.ru/team27_projectdb --username team27 --password $password
sqoop import-all-tables --connect jdbc:postgresql://hadoop-04.uni.innopolis.ru/team27_projectdb --username team27 --password $password --compression-codec=snappy --compress --as-avrodatafile --warehouse-dir=project/warehouse --m 1
mkdir -p output
mv *.java ./output
mv *.avsc ./output