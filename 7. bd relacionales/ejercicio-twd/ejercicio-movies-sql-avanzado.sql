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

-- 7.
SELECT DISTINCT g.name FROM
genres as g INNER JOIN movies as m
ON m.genre_id = g.id;

-- 8.
SELECT a.*
FROM actors a
INNER JOIN movies m
ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

-- 9.
CREATE INDEX title_index
ON movies (title);

-- 10.
SHOW INDEX FROM movies;

-- 11. Si va haber diferencia en la búsqueda pero teniendo en cuenta la cantidad de registros de la tabla
-- quizas la mejora en performance no sea tan perceptible.

-- 12. Creariamos en la tabla 'series' el indice para la columna title, debido a que mejoraría la performance de búsqueda
-- en caso de querer buscar series, un caso similar a la tabla 'movies'
