-- Agregar una película a la tabla movies.
insert into movies (title, rating, awards, release_date, length, genre_id) values('Pelicula nueva', 9.2,3,'2024-07-09',130,3);
-- Agregar un género a la tabla genres.
insert into genres (created_at, name, ranking, active) values (now(), 'new genre', 13, 1);
-- Asociar a la película del punto 1. genre el género creado en el punto 2.
update movies set genre_id = 13 where id = 22;
-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
update actors set favorite_movie_id = 22 where id = 27;
-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_two SELECT * FROM movies;
-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_two WHERE awards < 5;
-- Obtener la lista de todos los géneros que tengan al menos una película.
Select g.name FROM movies m
INNER JOIN genres g ON g.id = m.genre_id
GROUP BY g.name;
-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
Select a.*, m.awards from actors a
INNER JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;
-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX title_index
ON movies(title);
-- Chequee que el índice fue creado correctamente.
EXPLAIN SELECT title FROM MOVIES WHERE title LIKE 'Sonic';
EXPLAIN SELECT name FROM genres WHERE name LIKE 'Accion';

