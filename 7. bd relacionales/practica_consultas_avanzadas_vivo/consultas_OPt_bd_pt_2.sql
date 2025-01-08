/*
1. Agregar una película a la tabla movies.
2. Agregar un género a la tabla genres.
3. Asociar a la película del punto 1. genre el género creado en el punto 2.
4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
5. Crear una tabla temporal copia de la tabla movies.
6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
7. Obtener la lista de todos los géneros que tengan al menos una película.
8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
9. Crear un índice sobre el nombre en la tabla movies.
10. Chequee que el índice fue creado correctamente.
11. En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
12. ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
*/

-- 1.
INSERT INTO movies  (title, rating, awards, release_date, length)
VALUES ('Castillo Vagabundo',8.1,17,'2004-09-01 00:00:00',119);

SELECT * FROM movies;
-- 2.
INSERT INTO genres (name,ranking,active)
VALUES ('Anime',13,1);
-- 3.
UPDATE movies SET genre_id = 14 WHERE id = 22;

SELECT * FROM genres;

-- 4.
UPDATE actors SET favorite_movie_id = 22 WHERE id = 3;
INSERT INTO actor_movie (actor_id, movie_id) VALUES (3,22);
SELECT * FROM actors;

-- 5. 
CREATE TEMPORARY TABLE movies_copy 
(SELECT * FROM movies);

select * from movies_copy;

-- 6.
SET SQL_SAFE_UPDATES = 0;
DELETE FROM movies_copy WHERE awards < 5;
select * from movies_copy;


-- 7.
SELECT genres.name FROM genres LEFT JOIN movies ON genres.id= movies.genre_id;

-- 8.
SELECT actors.id, actors.first_name, movies.title, movies.awards FROM actors INNER JOIN actor_movie ON actors.favorite_movie_id = actor_movie.movie_id 
INNER JOIN movies ON actor_movie.movie_id = movies.id
WHERE awards > 3;

-- 9. 
CREATE INDEX title_idx ON movies (title);

-- 10.
SHOW INDEX FROM movies;

-- 11. Si, se puede corroborar al ejecutar EXPLAIN al hacer una
-- busqueda de registros para verificar que no se revidsa toda la tabla

-- 12. El el title de Series para que buscar datos por el nombre de la serie sea más rapido









