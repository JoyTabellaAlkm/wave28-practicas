-- Creación de Tablas Temporales e Índices

-- Ejercicio 1

-- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma 
-- los episodios de todas las temporadas de “The Walking Dead”.

DROP TABLE IF EXISTS TWD;

CREATE TEMPORARY TABLE TWD(
	id INT NOT NULL,
    created_at TIMESTAMP DEFAULT NULL,
    updated_at TIMESTAMP DEFAULT NULL,
    title VARCHAR(500) NOT NULL,
    episode_number INT NOT NULL,
    release_date DATETIME NOT NULL,
    rating DECIMAL(3,1) NOT NULL,
    season_id INT UNSIGNED NOT NULL,
    PRIMARY KEY (id)
);

SELECT e.* 
FROM episodes e
INNER JOIN seasons ss
	ON e.season_id = ss.id
INNER JOIN series se
	ON ss.serie_id = se.id
WHERE se.title = "The Walking Dead";

INSERT INTO TWD(id, created_at, updated_at, title, episode_number, release_date, rating, season_id)
SELECT e.* 
FROM episodes e
INNER JOIN seasons ss
	ON e.season_id = ss.id
INNER JOIN series se
	ON ss.serie_id = se.id
WHERE se.title = "The Walking Dead";

-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT * FROM TWD;

-- -----------------------------

-- En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
-- Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.

EXPLAIN SELECT id, title, season_id FROM TWD WHERE season_id = 22;

CREATE INDEX season_id_index
ON TWD(season_id);

SHOW INDEX FROM TWD;

ALTER TABLE TWD
DROP INDEX season_id_index;

-- -----------------------------

-- Agregar una película a la tabla movies.
SELECT * FROM movies;

INSERT INTO movies(title, rating, awards, release_date, length, genre_id)
VALUES("Totoro", 10, 1000, "2010-05-20", 150, 5);

-- Agregar un género a la tabla genres.
SELECT * FROM genres;

INSERT INTO genres(name, ranking, active)
VALUES("anime", 20, 1); -- id: 14

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
SELECT * FROM movies WHERE title = "Totoro";

UPDATE movies
SET genre_id = 14
WHERE title = "Totoro" AND id = 22;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
SELECT * FROM actors;

UPDATE actors
SET favorite_movie_id = 22
WHERE id = 1;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TABLE movies_temp
SELECT * FROM movies;

SELECT * FROM movies_temp;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
SET SQL_SAFE_UPDATES = 0;

DELETE 
FROM movies_temp
WHERE awards < 5;

SET SQL_SAFE_UPDATES = 1;


-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.name
FROM genres g
JOIN movies m
	ON m.genre_id = g.id
GROUP BY g.name
HAVING COUNT(m.id) >= 1;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.first_name, a.last_name
FROM actors a
INNER JOIN movies m
	ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX movie_name_index
ON movies(title);

-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
/*
RTA: en este ejemplo no habria diferencia notable ya que son pocos registros.
Pero en general, cuando hay muchos datos, dependiendo a que campo se lo asignes, puede haber cierta mejora.
Por ejemplo, si es un campo que es consultado constantemente por una sentencia WHERE title = 'x', entonces
esa busqueda la obtendria barriendo solamente una row, mientras que si no existiera indice, estaria preguntando
en cada fila hasta encontrarla.
*/

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
/*
RTA: en las tablas que sean consultadas y especificamente en cuyos campos se hagan muchas consultas pero pocas
actualizaciones. Por ejemplo, los numeros de temporada me parece un buen caso ya que suelen consultarse
al querer ver una serie en alguna plataforma. Pueden agregarse y actualizarse, peor teniendo en cuenta que una serie
sale cada año o en intervalos de tiempo mayor, no podria considerarse como que se actualiza muy frecuentemente.
*/
