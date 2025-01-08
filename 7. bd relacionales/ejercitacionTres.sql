# Agregar una película a la tabla movies.
INSERT INTO movies VALUES (NULL,NULL,NULL,'La La Land. Una historia de amor',8.0,6,"2017-03-02 03:00:00",128,3);
# Agregar un género a la tabla genres.
INSERT INTO `genres` VALUES (13,NOW(),NULL,'Romántica',13,1);
# Asociar a la película del punto 1. genre el género creado en el punto 2.
SET SQL_SAFE_UPDATES = 0;
UPDATE movies 
SET 
    genre_id = 13
WHERE
    title = 'La La Land. Una historia de amor';
SET SQL_SAFE_UPDATES = 1;
SELECT 
    *
FROM
    movies
WHERE
    title = 'La La Land. Una historia de amor';

# Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
SET SQL_SAFE_UPDATES = 0;
UPDATE actors 
SET 
    favorite_movie_id = (SELECT 
            id
        FROM
            movies
        WHERE
            title = 'La La Land. Una historia de amor')
WHERE
    favorite_movie_id IS NULL;
SET SQL_SAFE_UPDATES = 1;

# Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE `movies_te` (
  `id` int,
  `created_at` timestamp,
  `updated_at` timestamp ,
  `title` varchar(500),
  `rating` decimal(3,1) ,
  `awards` int,
  `release_date` datetime,
  `length` int,
  `genre_id` int
);

INSERT INTO movies_te SELECT * FROM movies;
SELECT 
    *
FROM
    movies_te;

# Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
SET SQL_SAFE_UPDATES = 0;
DELETE FROM movies_te 
WHERE
    awards < 5;
SET SQL_SAFE_UPDATES = 1;

# Obtener la lista de todos los géneros que tengan al menos una película.
SELECT 
    g.id, g.nombre
FROM
    genres g
        INNER JOIN
    movies m ON g.id = m.genre_id
GROUP BY g.id , g.nombre;
# Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.

# Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX moviesName ON movies(title);
# Chequee que el índice fue creado correctamente.
# En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
# ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
SELECT 
    *
FROM
    genres
WHERE
    id IN (SELECT 
            genre_id
        FROM
            movies);

SELECT 
    *
FROM
    actors
WHERE
    favorite_movie_id IN (SELECT 
            id
        FROM
            movies
        WHERE
            awards > 2);
