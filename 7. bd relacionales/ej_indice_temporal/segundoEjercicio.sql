-- Agregar una película a la tabla movies.
INSERT INTO movies VALUES(null, null, null, 'Interestellar', 5.1, 6, '2012-05-04 00:00:00', 180, null);
SELECT * FROM movies;

-- Agregar un género a la tabla genres.
INSERT INTO genres VALUES(null, '2025-01-08 00:00:00', null, 'Basado en hechos reales', 13, 1);
SELECT * FROM genres;

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies set genre_id = 13 where id = 22;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors set favorite_movie_id = 22 where id = 3;
SELECT * FROM actors;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE COPY(
	SELECT * FROM movies
);

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM COPY where awards < 5;
SELECT * FROM COPY;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT distinct g.* FROM movies m 
INNER JOIN genres g ON g.id = m.genre_id;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.* FROM actors a
JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX nombre_peliculas_index ON movies (title);

-- Chequee que el índice fue creado correctamente.
SHOW INDEX from movies;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.

-- RESPUESTA: Veríamos una mejora notable porque el nombre de las peliculas no debería cambiar, sin embargo, si suele ser consultado recurrentemente

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta

-- RESPUESTA: En la tabla de actores para el campo de nombre y en la tabla de series para el campo de nombre 