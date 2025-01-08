use movies_db;
-- Agregar una película a la tabla movies.
INSERT INTO movies VALUES(null, current_time(), null, "Los siete pecados capitales", 8.6, 4, "1996-02-15", 120, null);
SELECT * FROM movies WHERE title = "Los siete pecados capitales";
-- Agregar un género a la tabla genres.
INSERT INTO genres VALUES(null, current_time(), null, "Acción con Brad Pitt", 13, 1);
SELECT * FROM genres;
-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies 
SET genre_id = (SELECT id FROM genres WHERE name = "Acción con Brad Pitt")
WHERE title = "Los siete pecados capitales";
-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors 
SET favorite_movie_id = (SELECT id FROM movies WHERE title = "Los siete pecados capitales")
WHERE first_name = "Leonardo" AND last_name = "Di Caprio";
SELECT * FROM actors;
-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_tmp AS SELECT * FROM movies;
-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_tmp
WHERE awards < 5;
SELECT * FROM movies_tmp;
-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT DISTINCT g.* 
FROM genres g
JOIN movies m
ON g.id = m.genre_id;
-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.*, m.title as favorite_movie_title, m.awards 
FROM actors a
JOIN movies m
ON a.favorite_movie_id = m.id
WHERE m.awards > 3;
-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX title_index ON movies(title); 
-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;
-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
/*
Si, ya que muchas de las operaciones que se realizan son a partir del nombre de un actor, pelicula o serie
y no contar siempre con el ID de los mismos/as, utilizando indices en las columnas title o name 
nos ahorramos sub-consultas.
*/
-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
/*
En el campo name de la tabla genres. Por lo mismo del punto anterior.
*/