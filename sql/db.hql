SHOW DATABASES;

DROP DATABASE IF EXISTS team27_projectdb CASCADE;
CREATE DATABASE team27_projectdb LOCATION "project/hive/warehouse";
USE team27_projectdb;

SHOW TABLES;

CREATE EXTERNAL TABLE authors STORED AS AVRO LOCATION 'project/warehouse/authors' TBLPROPERTIES ('avro.schema.url'='project/warehouse/avsc/authors.avsc');
CREATE EXTERNAL TABLE reviews STORED AS AVRO LOCATION 'project/warehouse/reviews' TBLPROPERTIES ('avro.schema.url'='project/warehouse/avsc/reviews.avsc');

-- Check column types
DESCRIBE authors;
DESCRIBE reviews;

-- For checking the content of tables
SELECT * FROM authors limit 5;
SELECT * FROM reviews limit 5;


