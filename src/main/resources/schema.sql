DROP TABLE IF EXISTS character, movie, franchise, movie_character, movie_franchise CASCADE;
CREATE TABLE character (
    id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    name VARCHAR DEFAULT (''),
    alias VARCHAR DEFAULT NULL,
    gender INT DEFAULT 0,
    image_url VARCHAR DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE movie (
    id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    title VARCHAR DEFAULT (''),
    genre VARCHAR DEFAULT (''),
    release_year INT DEFAULT (-1),
    director_name VARCHAR DEFAULT (''),
    image_url VARCHAR DEFAULT NULL,
    trailer_url VARCHAR DEFAULT NULL
);

CREATE TABLE franchise (
   id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
   name VARCHAR DEFAULT (''),
   description VARCHAR DEFAULT NULL
);

CREATE TABLE movie_character (
    movie_id BIGINT NOT NULL,
    character_id VARCHAR
);

CREATE TABLE movie_franchise (
     franchise_id BIGINT NOT NULL,
     movie_id VARCHAR
);
