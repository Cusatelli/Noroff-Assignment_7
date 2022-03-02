/******* MOVIE *******/
INSERT INTO movie (title, genre, release_year, director_name, image_url, trailer_url) VALUES ('Avatar', 'Sci-Fi, Action, Adventure, Fantasy', 2009, 'James Cameron', 'https://upload.wikimedia.org/wikipedia/en/d/d6/Avatar_%282009_film%29_poster.jpg','https://www.imdb.com/video/vi531039513?playlistId=tt0499549?ref_=ext_shr_lnk');
INSERT INTO movie (title, genre, release_year, director_name, image_url, trailer_url) VALUES ('Avengers: Endgame', 'Action, Adventure, Drama', 2019, 'Anthony Russo, Joe Russo', 'https://upload.wikimedia.org/wikipedia/en/0/0d/Avengers_Endgame_poster.jpg','https://www.imdb.com/video/vi2163260441?playlistId=tt4154796?ref_=ext_shr_lnk');
INSERT INTO movie (title, genre, release_year, director_name, image_url, trailer_url) VALUES ('Titanic', 'Romance, Disaster, Drama, Historical', 1997, 'James Cameron', 'https://upload.wikimedia.org/wikipedia/en/1/18/Titanic_%281997_film%29_poster.png','https://www.imdb.com/video/vi907189785?playlistId=tt0120338?ref_=ext_shr_lnk');

/***** CHARACTER *****/
/*       AVATAR      */
INSERT INTO character (name, alias, gender, image_url) VALUES ('Sam Worthington', null, 0, 'https://m.media-amazon.com/images/M/MV5BMTc5NTMyMjIwMV5BMl5BanBnXkFtZTcwNTMyNjYwMw@@._V1_UY317_CR6,0,214,317_AL_.jpg');
INSERT INTO character (name, alias, gender, image_url) VALUES ('Zoe Saldana', null, 1, 'https://m.media-amazon.com/images/M/MV5BMTM2MjIwOTc0Nl5BMl5BanBnXkFtZTcwNzQ5ODM1Mw@@._V1_UX214_CR0,0,214,317_AL_.jpg');
INSERT INTO character (name, alias, gender, image_url) VALUES ('Sigourney Weaver', null, 1, 'https://m.media-amazon.com/images/M/MV5BMTk1MTcyNTE3OV5BMl5BanBnXkFtZTcwMTA0MTMyMw@@._V1_UY317_CR12,0,214,317_AL_.jpg');
/* Avengers: Endgame */
INSERT INTO character (name, alias, gender, image_url) VALUES ('Robert Downey Jr.', 'Junior', 0, 'https://m.media-amazon.com/images/M/MV5BNzg1MTUyNDYxOF5BMl5BanBnXkFtZTgwNTQ4MTE2MjE@._V1_UX214_CR0,0,214,317_AL_.jpg');
INSERT INTO character (name, alias, gender, image_url) VALUES ('Chris Evans', null, 0, 'https://m.media-amazon.com/images/M/MV5BMTU2NTg1OTQzMF5BMl5BanBnXkFtZTcwNjIyMjkyMg@@._V1_UY317_CR6,0,214,317_AL_.jpg');
INSERT INTO character (name, alias, gender, image_url) VALUES ('Mark Ruffalo', 'Ruffalo', 0, 'https://m.media-amazon.com/images/M/MV5BNWIzZTI1ODUtZTUzMC00NTdiLWFlOTYtZTg4MGZkYmU4YzNlXkEyXkFqcGdeQXVyNTExOTk5Nzg@._V1_UX214_CR0,0,214,317_AL_.jpg');
INSERT INTO character (name, alias, gender, image_url) VALUES ('Chris Hemsworth', null, 0, 'https://m.media-amazon.com/images/M/MV5BOTU2MTI0NTIyNV5BMl5BanBnXkFtZTcwMTA4Nzc3OA@@._V1_UX214_CR0,0,214,317_AL_.jpg');
INSERT INTO character (name, alias, gender, image_url) VALUES ('Scarlett Johansson', null, 1, 'https://m.media-amazon.com/images/M/MV5BMTM3OTUwMDYwNl5BMl5BanBnXkFtZTcwNTUyNzc3Nw@@._V1_UY317_CR23,0,214,317_AL_.jpg');
/*      Titanic      */
INSERT INTO character (name, alias, gender, image_url) VALUES ('Leonardo DiCaprio', 'Leo', 0, 'https://m.media-amazon.com/images/M/MV5BMjI0MTg3MzI0M15BMl5BanBnXkFtZTcwMzQyODU2Mw@@._V1_UY317_CR10,0,214,317_AL_.jpg');
INSERT INTO character (name, alias, gender, image_url) VALUES ('Kate Winslet', null, 1, 'https://m.media-amazon.com/images/M/MV5BODgzMzM2NTE0Ml5BMl5BanBnXkFtZTcwMTcyMTkyOQ@@._V1_UX214_CR0,0,214,317_AL_.jpg');
INSERT INTO character (name, alias, gender, image_url) VALUES ('Billy Zane', 'Bill', 0, 'https://m.media-amazon.com/images/M/MV5BMTI5NzA2NTE0NF5BMl5BanBnXkFtZTcwNzAxMTUxMw@@._V1_UY317_CR15,0,214,317_AL_.jpg');

/***** FRANCHISE *****/
/*       AVATAR      */
INSERT INTO franchise (name, description) VALUES ('Avatar', 'The first installment, Avatar, was released on December 18, 2009 and was the highest grossing film of all-time for almost ten years.');
/* Avengers: Endgame */
INSERT INTO franchise (name, description) VALUES ('Marvel Cinematic Universe', 'The Marvel Cinematic Universe is an American media franchise and shared universe centered on a series of superhero films produced by Marvel Studios.');

/***** MOVIE - FRANCHISE *****/
INSERT INTO movie_franchise (franchise_id, movie_id) VALUES (1, 1);
INSERT INTO movie_franchise (franchise_id, movie_id) VALUES (1, 2);
INSERT INTO movie_franchise (franchise_id, movie_id) VALUES (2, 3);

/***** MOVIE - CHARACTER *****/
INSERT INTO movie_character (movie_id, character_id) VALUES (1, 1);
INSERT INTO movie_character (movie_id, character_id) VALUES (1, 2);
INSERT INTO movie_character (movie_id, character_id) VALUES (1, 3);
INSERT INTO movie_character (movie_id, character_id) VALUES (2, 4);
INSERT INTO movie_character (movie_id, character_id) VALUES (2, 5);
INSERT INTO movie_character (movie_id, character_id) VALUES (2, 6);
INSERT INTO movie_character (movie_id, character_id) VALUES (2, 7);
INSERT INTO movie_character (movie_id, character_id) VALUES (2, 8);
INSERT INTO movie_character (movie_id, character_id) VALUES (3, 9);
INSERT INTO movie_character (movie_id, character_id) VALUES (3, 10);
INSERT INTO movie_character (movie_id, character_id) VALUES (3, 11);
/*****************************/