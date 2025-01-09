-- Agregar una película a la tabla movies.
INSERT INTO movies (created_at, updated_at, title, rating, awards, release_date, length, genre_id)
VALUES (NOW(), NULL, 'Moana', 9.2, 4, '2024-11-28', 107, 7);
select * from movies where title = 'Moana';
-- Agregar un género a la tabla genres.
INSERT INTO genres (created_at, updated_at, name, ranking, active)
VALUES (NOW(), NULL, 'Western', 13, 1);
SELECT * FROM genres;
-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies 
SET genre_id = 13
WHERE id = 22;
-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id = 22
WHERE id = 3;
SELECT * FROM actors where id = 3;
-- Crear una tabla temporal copia de la tabla movies.
DROP TABLE IF EXISTS movies_copy;
CREATE TEMPORARY TABLE movies_copy (id INT , created_at DATETIME, updated_at DATETIME, title VARCHAR(500), rating DOUBLE(3,1), awards INT, release_date DATETIME, length INT, genre_id INT);
INSERT INTO movies_copy
SELECT id, created_at, updated_at, title, rating, awards, release_date, length, genre_id FROM movies;
SELECT * FROM movies_copy;
-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_copy
WHERE awards < 5;
-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.name
FROM genres g
INNER JOIN movies m on m.genre_id = g.id
GROUP BY g.id
HAVING count(1) >= 1 ;
-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.first_name, a.last_name, m.title, m.awards
FROM actors a
INNER JOIN movies m on a.favorite_movie_id = m.id
WHERE m.awards > 3;
-- Crear un índice sobre el nombre en la tabla movies.
ALTER TABLE `movies_db`.`movies` 
ADD INDEX `movies_name_index` (`title` ASC) VISIBLE;
;
-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;
-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
/*Le agregaría indices a las columnas de rating en movies o actores, o por ejemplo a el numero de temporada en seasons, 
principalmente porque son columnas que se pueden utilizar para filtrar a la hora de hacer busquedas, y entonces podriamos optimizar
esas busquedas mediante indices en esas columnas
*/
