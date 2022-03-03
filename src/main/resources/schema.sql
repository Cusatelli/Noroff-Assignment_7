DROP TABLE IF EXISTS character, movie, franchise, movie_character, movie_franchise CASCADE;
CREATE TABLE character (
    id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(50) DEFAULT (''),
    alias VARCHAR(50) DEFAULT NULL,
    gender INT DEFAULT 0,
    image_url VARCHAR DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE movie (
    id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    title VARCHAR(50) DEFAULT (''),
    genre VARCHAR(50) DEFAULT (''),
    release_year INT DEFAULT (-1),
    director_name VARCHAR(50) DEFAULT (''),
    image_url VARCHAR DEFAULT NULL,
    trailer_url VARCHAR DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE franchise (
   id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
   name VARCHAR(50) DEFAULT (''),
   description VARCHAR(50) DEFAULT NULL,
   PRIMARY KEY (id)
);

CREATE TABLE movie_character (
    movie_id BIGINT NOT NULL,
    character_id BIGINT
);

CREATE TABLE movie_franchise (
    franchise_id BIGINT NOT NULL,
    movie_id BIGINT
);
