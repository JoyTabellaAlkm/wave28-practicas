use movies_db;

INSERT INTO movies
(title, rating, awards, release_date, length, genre_id)
VALUES 
( "Avatar 2", 7, 2, '2023-10-10', 90, 5);

INSERT INTO genres
(name, ranking, active)
VALUES
('Animme', 13, 1);

UPDATE movies
SET genre_id = 13
WHERE id = 22;

UPDATE actors
SET favorite_movie_id = 22
where id = 3;

CREATE TEMPORARY TABLE IF NOT EXISTS temporary_movies
(
id int NOT NULL AUTO_INCREMENT PRIMARY KEY, 
created_at DATE, 
updated_at DATE, 
title varchar(255), 
rating int, 
awards int, 
release_date DATE, 
length INT, 
genre_id int
);

INSERT INTO temporary_movies
SELECT * FROM movies;

SELECT * FROM temporary_movies;

DELETE FROM temporary_movies WHERE awards < 5;

SELECT actors.first_name, actors.last_name, movies.title, movies.awards FROM actors INNER JOIN movies ON actors.favorite_movie_id = movies.id
WHERE movies.awards >3;

CREATE INDEX title_index ON movies(title);

SHOW INDEX FROM movies;