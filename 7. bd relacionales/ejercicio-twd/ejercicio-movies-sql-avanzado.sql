-- Ejercicio 2
use movies_db;

-- 1.
INSERT INTO movies
(title, rating, awards, release_date, length, genre_id)
VALUES 
("Avatar 2", 7.0, 10, "2023-11-04 00:00:00", 140, 5);

SELECT * FROM movies;

-- 2.
INSERT INTO genres
(created_at, name, ranking, active)
VALUES 
("2024-01-02 00:00:00", "Comedia musical", 13, 1);

SELECT * FROM genres;

-- 3.
UPDATE movies
SET genre_id = 13
WHERE id = 22;

-- 4.
UPDATE actors
SET favorite_movie_id = 22
WHERE id = 1;

SELECT * FROM actors;

-- 5.
CREATE TEMPORARY TABLE temporary_movies(
	id INT PRIMARY KEY,
    created_at DATETIME DEFAULT NULL,
    updated_at DATETIME DEFAULT NULL,
    title VARCHAR(255),
    rating DECIMAL(3, 1),
    awards INT,
    release_date DATETIME,
    length INT,
    genre_id INT
);

INSERT INTO temporary_movies SELECT * FROM movies;

SELECT * FROM temporary_movies;

-- 6.
SELECT * FROM temporary_movies
WHERE awards < 5;

DELETE FROM temporary_movies
WHERE awards < 5;

