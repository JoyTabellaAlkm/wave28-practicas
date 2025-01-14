USE movies_db;

# Agregar una película a la tabla movies.
INSERT INTO movies VALUES(
	null, null, null, "Gladiador", 9.6, 12, "2000-05-01", 165, 4
);

# Agregar un género a la tabla genres
INSERT INTO genres VALUES(
	null, NOW(), null, "Accion/Aventura", 13, 1
);

# Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies
SET genre_id = (
	SELECT id
    FROM genres
    WHERE name = "Accion/Aventura"
)
WHERE title = "Gladiador";

# Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id = (
	SELECT id
    FROM genres
    WHERE name = "Accion/Aventura"
)
WHERE id = 3;

# Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_copy AS
SELECT * FROM movies;

# Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_copy
WHERE awards < 5;

# Obtener la lista de todos los géneros que tengan al menos una película.
SELECT DISTINCT g.*
FROM genres g
JOIN movies m ON g.id = m.genre_id;

# Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.*
FROM actors a
JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

# Crear un índice sobre el nombre en la tabla movies.
ALTER TABLE movies
ADD INDEX title_index (title);

# Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

# En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
# Ya que la base de datos es relativamente pequeña no se nota mucho la diferencia, pero a medida que esta crezca se obtendrá una mejora notable en las consultas.

# ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
# En la tabla de actores, en la columna de rating, ya que esta podría ser una columna que se utilizaría bastante al momento de filtrar en esta tabla.