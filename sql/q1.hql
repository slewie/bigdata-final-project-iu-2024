USE team27_projectdb;

SHOW TABLES;

DROP TABLE q1_results;

SHOW TABLES;

CREATE EXTERNAL TABLE q1_results(
appname STRING,
Total_Recommended BIGINT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q1'; 

SET hive.resultset.use.unique.column.names = false;

INSERT INTO q1_results
SELECT appname,
SUM(CAST(recommended as BIGINT)) AS total_rec
FROM reviews
GROUP BY appname
ORDER BY total_rec DESC;

INSERT OVERWRITE DIRECTORY 'project/output/q1' 
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 
SELECT * FROM q1_results;
