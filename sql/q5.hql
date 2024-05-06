USE team27_projectdb;

SHOW TABLES;

DROP TABLE q5_results;

SHOW TABLES;

CREATE EXTERNAL TABLE q5_results(
appname string,
game_corr_comment_votes FLOAT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q5';

SET hive.resultset.use.unique.column.names = false;

INSERT INTO q5_results
select appname, avg(comment_count / votes_helpful) as game_corr_comment_votes
from reviews
group by appname;

INSERT OVERWRITE DIRECTORY 'project/output/q5'
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 
SELECT * FROM q5_results;