USE team27_projectdb;

SHOW TABLES;

CREATE EXTERNAL TABLE reviews_part_buck(
    id int,
    app_id int,
    appname string,
    review_id int,
    language string,
    review string,
    time_date_created date,
    time_date_updated date,
    votes_helpful bigint,
    votes_funny bigint,
    weighted_vote_score double,
    comment_count bigint,
    steam_purchase boolean,
    received_for_free boolean,
    written_during_early_access boolean,
    author_steamid bigint,
    playtime_forever double,
    playtime_last_two_weeks double,
    playtime_at_review double,
    last_played date
)
    PARTITIONED BY (recommended boolean)
    CLUSTERED BY (appname) into 20 buckets
    STORED AS AVRO LOCATION 'project/hive/warehouse/reviews_part' 
    TBLPROPERTIES ('AVRO.COMPRESS'='SNAPPY');


INSERT INTO reviews_part_buck
SELECT id, app_id, appname, review_id, language, review, 
        from_unixtime(CAST(time_date_created/1000 AS BIGINT), 'yyyy-MM-dd HH:mm:ss.SSS') AS time_date_created,
        from_unixtime(CAST(time_date_updated/1000 AS BIGINT), 'yyyy-MM-dd HH:mm:ss.SSS') AS time_date_updated,
        votes_helpful, votes_funny, weighted_vote_score, comment_count, steam_purchase, received_for_free,
        written_during_early_access, author_steamid, playtime_forever, playtime_last_two_weeks, playtime_at_review,
        from_unixtime(CAST(last_played/1000 AS BIGINT), 'yyyy-MM-dd HH:mm:ss.SSS') AS last_played,
        recommended
FROM reviews;

SELECT * FROM reviews_part_buck limit 1;

DROP TABLE reviews;
ALTER TABLE reviews_part_buck RENAME TO reviews;