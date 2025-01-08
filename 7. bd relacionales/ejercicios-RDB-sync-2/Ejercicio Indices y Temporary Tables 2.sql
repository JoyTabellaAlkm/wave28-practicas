/*
	1: Agregar una película a la tabla movies.
	2: Agregar un género a la tabla genres.
	3: Asociar a la película del punto 1. genre el género creado en el punto 2.
	4: Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
	5: Crear una tabla temporal copia de la tabla movies.
	6: Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
	7: Obtener la lista de todos los géneros que tengan al menos una película.
	8: Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
	9: Crear un índice sobre el nombre en la tabla movies.
	10: Chequee que el índice fue creado correctamente.
	11: En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
	12: ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
*/

select * from movies;
select * from genres;
select * from actors;
-- Punto 1:
INSERT INTO movies (title, rating, awards, release_date, length, genre_id) VALUES ('Sonic 3', 9.8, 0, '2024-01-02', 110, 4);

-- Punto 2:
INSERT INTO genres (name, ranking, active) VALUES ('Podcast', 13, 1);


-- Punto 3:
UPDATE movies SET genre_id = 13 where id = 22;

-- Punto 4: Modificar la tabla actors para que al menos un actor tenga
-- 			como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 22 WHERE id = 27;

-- Punto 5: Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_two SELECT * FROM movies;

-- Punto 6: Eliminar de esa tabla temporal todas las 
-- 			películas que hayan ganado menos de 5 awards.
DELETE FROM movies_two WHERE awards < 5;

-- Punto 7: Obtener la lista de todos los géneros que tengan al menos una película.
Select g.name FROM movies m
INNER JOIN genres g ON g.id = m.genre_id
GROUP BY g.name;

-- Punto 8: Obtener la lista de actores cuya 
-- 			película favorita haya ganado más de 3 awards.
Select a.*, m.awards from actors a
INNER JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

-- Punto 9: Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX title_index
ON movies(title);

-- Punto 10: Chequee que el índice fue creado correctamente.
EXPLAIN SELECT title FROM MOVIES WHERE title LIKE 'Sonic';
EXPLAIN SELECT name FROM genres WHERE name LIKE 'Accion'

-- Punto 11: En la base de datos movies ¿Existiría una mejora notable al crear índices? 
-- 			 Analizar y justificar la respuesta.

-- Mejoraria en momentos de lectura, pero ahora no tanto debido a no haber tantos registros
-- Si hubiese mas registros, la mejora seria mas notable

-- Punto 12: ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta

-- Se podria agregar un indice para 'name' en 'episodes'. Si tenemos en cuenta que pueden haber
-- una gran cantidad de episodios, esto ayudaria bastante en momentos de lectura.







