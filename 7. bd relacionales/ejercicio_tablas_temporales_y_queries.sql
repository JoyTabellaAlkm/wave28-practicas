/* Tomando la base de datos movies_db.sql, se solicita:

Agregar una película a la tabla movies.
Agregar un género a la tabla genres.
Asociar a la película del punto 1. genre el género creado en el punto 2.
Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
Crear una tabla temporal copia de la tabla movies.
Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
Obtener la lista de todos los géneros que tengan al menos una película.
Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
Crear un índice sobre el nombre en la tabla movies.
Chequee que el índice fue creado correctamente.
En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta */

INSERT INTO `movies_db`.`movies` (`title`, `rating`, `awards`, `release_date`, `length`) VALUES 
('Avengers', '9.3', '7', '2017-05-03', '115'); -- id 22

INSERT INTO `movies_db`.`genres` (`name`, `ranking`) VALUES ('Suspenso', '13'); -- id 13

UPDATE `movies_db`.`movies` SET `genre_id` = '13' WHERE (`id` = '22');

UPDATE `movies_db`.`actors` SET `favorite_movie_id` = '22' WHERE (`id` = '47');

CREATE TEMPORARY TABLE temp_movies (SELECT * FROM movies);

DELETE FROM temp_movies WHERE awards < 5;

SELECT * FROM genres WHERE id IN (SELECT distinct genre_id FROM movies);

SELECT a.* FROM actors a
JOIN movies m ON m.id = a.favorite_movie_id 
WHERE m.awards > 3;

-- La creación y verificación del indice la hicimos en el ejercicio anterior

/* En este caso la mejora no es notable porque hay solo 22 registros en la tabla movies. Sin embargo, a medida que esta tabla crezca cada vez
se va a hacer más notable la optimización que produce el índice. */

/* Siguiendo la lógica de agregar un índice por title en la tabla de movies, podríamos hacer lo mismo para la tabla de series con el mismo objetivo:
optimizar las búsquedas filtrando por nombre para mejorar la experiencia de los usuarios. */

explain select * from movies where title = 'Avengers';



