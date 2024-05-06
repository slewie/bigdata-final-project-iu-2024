DROP TABLE IF EXISTS tmp;

CREATE TABLE IF NOT EXISTS tmp (
    id integer NOT NULL PRIMARY KEY,
    app_id integer NOT NULL,
    appname VARCHAR ( 50 ) NOT NULL,
    review_id integer NOT NULL,
    language VARCHAR ( 50 ) NOT NULL,
    review VARCHAR,
    timestamp_created BIGINT NOT NULL,
    timestamp_updated BIGINT NOT NULL,
    recommended BOOLEAN NOT NULL,
    votes_helpful BIGINT NOT NULL,
    votes_funny BIGINT NOT NULL,
    weighted_vote_score float NOT NULL,
    comment_count BIGINT NOT NULL,
    steam_purchase BOOLEAN NOT NULL,
    received_for_free BOOLEAN NOT NULL,
    written_during_early_access BOOLEAN NOT NULL,
    "author.steamid" bigint NOT NULL,
    "author.num_games" bigint NOT NULL,
    "author.num_reviews" bigint NOT NULL,
    "author.playtime_forever" float,
    "author.playtime_last_two_weeks" float,
    "author.playtime_at_review" float,
    "author.last_played" float
);

COPY tmp FROM stdin WITH (FORMAT csv, HEADER true, DELIMITER ',', QUOTE '"');

CREATE TABLE IF NOT EXISTS reviews (
    id integer NOT NULL PRIMARY KEY,
    app_id integer NOT NULL,
    appname VARCHAR ( 50 ) NOT NULL,
    review_id integer NOT NULL,
    language VARCHAR ( 50 ) NOT NULL,
    review VARCHAR,
    timestamp_created BIGINT NOT NULL,
    time_date_created TIMESTAMP,
    timestamp_updated BIGINT NOT NULL,
    time_date_updated TIMESTAMP,
    recommended BOOLEAN NOT NULL,
    votes_helpful BIGINT NOT NULL,
    votes_funny BIGINT NOT NULL,
    weighted_vote_score float NOT NULL,
    comment_count BIGINT NOT NULL,
    steam_purchase BOOLEAN NOT NULL,
    received_for_free BOOLEAN NOT NULL,
    written_during_early_access BOOLEAN NOT NULL,
    author_steamid bigint NOT NULL,
    playtime_forever float,
    playtime_last_two_weeks float ,
    playtime_at_review float,
    last_played float,
    time_date_last_played TIMESTAMP
);

CREATE TABLE IF NOT EXISTS authors (
    steamid bigint NOT NULL PRIMARY KEY,
    num_games BIGINT NOT NULL,
    num_reviews BIGINT NOT NULL
);

INSERT INTO authors(steamid, num_games, num_reviews)
SELECT DISTINCT ON("author.steamid") 
    "author.steamid" AS steamid,
    "author.num_games" AS num_games,
    "author.num_reviews" AS num_reviews
FROM tmp;

INSERT INTO reviews(id,
    app_id,
    appname,
    review_id,
    language,
    review,
    time_date_created,
    time_date_updated,
    recommended,
    votes_helpful,
    votes_funny,
    weighted_vote_score,
    comment_count,
    steam_purchase,
    received_for_free,
    written_during_early_access,
    author_steamid,
    playtime_forever,
    playtime_last_two_weeks,
    playtime_at_review,
    last_played)
SELECT
    id,
    app_id,
    appname,
    review_id,
    language,
    review,
    TO_TIMESTAMP(timestamp_created) AS time_date_created,
    TO_TIMESTAMP(timestamp_updated) AS time_date_updated,
    recommended,
    votes_helpful,
    votes_funny,
    weighted_vote_score,
    comment_count,
    steam_purchase,
    received_for_free,
    written_during_early_access,
    "author.steamid" AS author_steamid,
    "author.playtime_forever" AS playtime_forever,
    "author.playtime_last_two_weeks" AS playtime_last_two_weeks,
    "author.playtime_at_review" AS playtime_at_review,
    TO_TIMESTAMP("author.last_played") AS time_date_last_played
FROM tmp;

DROP TABLE IF EXISTS tmp;
