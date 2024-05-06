START TRANSACTION;

DROP TABLE IF EXISTS reviews;
DROP TABLE IF EXISTS authors;

CREATE TABLE IF NOT EXISTS reviews (
    id integer NOT NULL PRIMARY KEY,
    app_id integer NOT NULL,
    appname VARCHAR ( 100 ) NOT NULL,
    review_id integer NOT NULL,
    language VARCHAR ( 50 ) NOT NULL,
    review VARCHAR,
    time_date_created TIMESTAMP,
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
    playtime_last_two_weeks float,
    playtime_at_review float,
    last_played TIMESTAMP
);

CREATE TABLE IF NOT EXISTS authors (
    steamid bigint NOT NULL PRIMARY KEY,
    num_games bigint NOT NULL,
    num_reviews bigint NOT NULL
);

ALTER TABLE reviews DROP CONSTRAINT IF EXISTS fk_review_author;

ALTER TABLE reviews ADD CONSTRAINT fk_review_author FOREIGN KEY(author_steamid) REFERENCES authors (steamid);

ALTER DATABASE team27_projectdb SET datestyle TO iso, ymd;

COMMIT;
