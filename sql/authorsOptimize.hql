USE team27_projectdb;

SHOW TABLES;

CREATE EXTERNAL TABLE authors_buck(
    steamid bigint,
    num_games bigint, 
    num_reviews bigint
)
    CLUSTERED BY (steamid) into 20 buckets
    STORED AS AVRO LOCATION 'project/hive/warehouse/authors_buck' 
    TBLPROPERTIES ('AVRO.COMPRESS'='SNAPPY');


INSERT INTO authors_buck SELECT steamid, num_games, num_reviews FROM authors;

SELECT * FROM authors_buck limit 1;

DROP TABLE authors;
ALTER TABLE authors_buck RENAME TO authors;
