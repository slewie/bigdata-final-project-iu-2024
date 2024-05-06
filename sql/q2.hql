USE team27_projectdb;

SHOW TABLES;

DROP TABLE q2_results;

SHOW TABLES;

CREATE EXTERNAL TABLE q2_results(
votes_helpful BIGINT,
mean_game_time FLOAT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q2';

SET hive.resultset.use.unique.column.names = false;

INSERT INTO q2_results
SELECT AVG(playtime_forever) as mean_game_time,
votes_helpful
FROM reviews
GROUP BY votes_helpful
ORDER BY votes_helpful DESC;

INSERT OVERWRITE DIRECTORY 'project/output/q2'
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 
SELECT * FROM q2_results;