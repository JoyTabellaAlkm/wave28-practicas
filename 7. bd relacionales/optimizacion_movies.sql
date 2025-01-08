-- Agregar una película a la tabla movies.
INSERT INTO movies(created_at, title, rating, awards, release_date, length, genre_id)
VALUES (NOW(), "Gladiador", 8.5, 23, '2005-05-05', 141, 1);

-- Agregar un género a la tabla genres.
INSERT INTO genres(created_at, name, ranking, active)
VALUES (NOW(), "Romance", 13, 1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies 
SET genre_id = 13
WHERE id = 22;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id = 22
WHERE id = 47;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE temporal_movies(id INT, created_at TIMESTAMP, updated_at TIMESTAMP, 
title VARCHAR(500),rating DECIMAL(3,1), awards INT, release_date DATETIME, length INT, genre_id INT);

INSERT INTO temporal_movies 
SELECT * FROM movies;

SELECT * FROM temporal_movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
SET SQL_SAFE_UPDATES = 0;

DELETE FROM temporal_movies
WHERE awards < 5;

SET SQL_SAFE_UPDATES = 1;

SELECT * FROM temporal_movies;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT ge.name, COUNT(mov.id) AS Cantidad
FROM genres ge
JOIN movies mov
ON mov.genre_id = ge.id
GROUP BY ge.name;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT ac.first_name, ac.last_name
FROM actors ac
JOIN movies mov
ON ac.favorite_movie_id = mov.id
WHERE mov.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX movie_title_idx ON movies(title);

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
/*
Tiene sentido crear indices si existen muchos mas registros de los actuales, en ese caso se notaria una mejora al hacer consultas sobre
la tabla movies. En el estado actual no tiene mucho sentido crear indices ya que existen muy pocos registros.
*/
-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
/*
Creariamos un indice sobre la columna title de la tabla series, debido a que es otra tabla que consultamos con frecuencia, 
principalmente utilizado el titulo de la serie.
*/
-- CREATE INDEX serie_title_idx ON series(title);