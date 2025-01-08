USE movies_db;
DROP TABLE IF EXISTS TWD;
CREATE TEMPORARY TABLE TWD AS
SELECT e.*, ss.number AS season_number FROM episodes e
		INNER JOIN seasons ss ON ss.id = e.season_id
		INNER JOIN series s ON s.id = ss.serie_id
			WHERE s.title = 'The Walking Dead';


SELECT * FROM TWD WHERE season_number = 1;

CREATE INDEX last_name_index ON actors(last_name);
SHOW INDEX FROM actors;
-- Elegimos crearle un index al apellido porque puede ser parte de varias queries con filtros, e INNER JOINS

-- 1. Agregar una película a la tabla movies.
INSERT INTO movies(title, rating, awards, release_date, length) VALUES(
	"The Sustance", 9.0, 2, '2024-11-01', 120);

-- 2. Agregar un género a la tabla genres.
INSERT INTO genres(name, ranking, active) VALUES(
	"Gore", 13, 1);

-- 3. Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies
SET genre_id = 13
WHERE title = 'The Sustance';

-- 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id = (SELECT id FROM movies WHERE title = 'The Sustance')
WHERE id = 1; -- Supongamos que el actor con id 1 es quien actualizaremos

-- 5. Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE temp_movies AS
SELECT * FROM movies;

-- 6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM temp_movies
WHERE awards < 5;

-- 7. Obtener la lista de todos los géneros que tengan al menos una película.
SELECT DISTINCT g.name
FROM genres g
JOIN movies m ON g.id = m.genre_id;

-- 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.first_name, a.last_name
FROM actors a
JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

-- 9. Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX title_index ON movies(title);

-- 10. Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- 11. En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- Si porque es una de las columnas más consultada para filtrar películas

-- 12. ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- En varias más, por ejemplo en las tablas episodes, movies, en las columnas como titulo, rating, y en actors, las columnas first_name y last_name ya que son los datos más conocidos para el usuario.
