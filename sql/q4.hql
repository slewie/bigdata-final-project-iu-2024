USE team27_projectdb;

SHOW TABLES;

DROP TABLE q4_results;

SHOW TABLES;

CREATE EXTERNAL TABLE q4_results(
language string,
avg_recommends FLOAT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q4';

SET hive.resultset.use.unique.column.names = false;

INSERT INTO q4_results
select language, avg(total_recommends / game_recommends) as avg_recommends
from (select appname, language, sum(cast(recommended as bigint)) as total_recommends
    from reviews
    group by appname, language
    ) as t 
    join (select appname, sum(cast(recommended as bigint)) as game_recommends
        from reviews
        group by appname
        ) as g
        on t.appname = g.appname
group by language
sort by avg_recommends desc;

INSERT OVERWRITE DIRECTORY 'project/output/q4'
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 
SELECT * FROM q4_results;