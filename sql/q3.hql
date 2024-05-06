USE team27_projectdb;

SHOW TABLES;

DROP TABLE q3_results;

SHOW TABLES;

CREATE EXTERNAL TABLE q3_results(
votes_helpful BIGINT,
num_games BIGINT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q3';

SET hive.resultset.use.unique.column.names = false;

INSERT INTO q3_results
SELECT AVG(votes_helpful) as avg_votes_up,
num_games
FROM reviews as r
join authors as a
    on r.author_steamid = a.steamid
GROUP BY num_games
ORDER BY avg_votes_up DESC;

INSERT OVERWRITE DIRECTORY 'project/output/q3'
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 
SELECT * FROM q3_results;