-- 1. Agregar una película a la tabla movies
INSERT INTO movies (title, rating, awards, release_date, length, genre_id)
VALUES ('Las Aventuras de la Fantasía', 7.5, 2, '2021-01-15', 120, NULL);

-- 2. Agregar un género a la tabla genres
INSERT INTO genres (created_at, updated_at, name, ranking, active)
VALUES (NOW(), NULL, 'Aventura Fantástica', 13, 1);

-- 3. Asociar la película creada en el punto 1 con el género creado en el punto 2
SET @genre_id = LAST_INSERT_ID();
UPDATE movies
SET genre_id = @genre_id
WHERE title = 'Las Aventuras de la Fantasía';

UPDATE movies
SET genre_id = (SELECT id FROM genres WHERE name = 'Aventura Fantástica')
WHERE title = 'Las Aventuras de la Fantasía';
-- 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1
UPDATE actors
SET favorite_movie_id = (SELECT id FROM movies WHERE title = 'Las Aventuras de la Fantasía')
WHERE id = 1;

-- 5. Crear una tabla temporal copia de la tabla movies
DROP TEMPORARY TABLE IF EXISTS movies_temp;
CREATE TEMPORARY TABLE movies_temp AS
SELECT * FROM movies;
SELECT * FROM movies_temp;

-- 6. Eliminar de la tabla temporal todas las películas que hayan ganado menos de 5 awards
SET SQL_SAFE_UPDATES = 0;
DELETE FROM movies_temp
WHERE awards < 5;
SELECT * FROM movies_temp;

-- 7. Obtener la lista de todos los géneros que tengan al menos una película
SELECT g.*
FROM genres g
INNER JOIN movies m ON g.id = m.genre_id
GROUP BY g.id;

-- 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards
SELECT a.*
FROM actors a
INNER JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

-- 9. Crear un índice sobre el nombre en la tabla movies
CREATE INDEX idx_movie_title ON movies(title);

-- 10. Chequear que el índice fue creado correctamente
SHOW INDEX FROM movies;

