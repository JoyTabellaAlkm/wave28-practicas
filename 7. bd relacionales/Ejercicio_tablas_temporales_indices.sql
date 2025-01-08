CREATE TEMPORARY TABLE TWD
SELECT e.title as episodio,sea.title as temporada
FROM series ser
JOIN seasons sea ON ser.id = sea.serie_id
JOIN episodes e ON sea.id = e.season_id
WHERE ser.title = "The Walking Dead";
SELECT * FROM TWD WHERE temporada = "Primer Temporada"
CREATE INDEX rating ON movies (title)
show index from movies
select * from actors
-- Agregar una película a la tabla movies.
INSERT INTO `movies` VALUES (22,NULL,NULL,'Avatar',7.9,3,'2010-10-04 00:00:00',120,5)
-- Agregar un género a la tabla genres.
INSERT INTO genres VALUES (13,'2010-10-04 00:00:00',null,"Triller",13,1)
--  Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies
SET genre_id = 13
WHERE id = 22;
UPDATE movies
SET title = 'Jumanji'
WHERE id = 22
-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id = 22
WHERE id = 4
-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE copy_movies
SELECT * from movies;
-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
delete from copy_movies where count(copy_movies.awards) > 5
-- Obtener la lista de todos los géneros que tengan al menos una película
select * from genres
Inner join movies on movies.genre_id = genres.id;
-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
select a.first_name,a.last_name from actors a
join movies m
on a.favorite_movie_id = m.id
where awards > 3