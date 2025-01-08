use movies_db;
/** Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar 
en la misma los episodios de todas las temporadas de “The Walking Dead”. **/

DROP TEMPORARY TABLE IF EXISTS TWD;
CREATE TEMPORARY TABLE TWD AS
SELECT e.*, s.number AS season
FROM episodes AS e
JOIN seasons AS s
ON e.season_id = s.id
JOIN series AS se
ON s.serie_id = se.id
WHERE se.title = "The Walking Dead";
 
SELECT * FROM TWD;

/** Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada. **/
SELECT * 
FROM TWD 
WHERE season = 1;

/** En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.**/
CREATE INDEX title_index ON movies (title);
EXPLAIN SELECT title FROM movies WHERE title = "Avatar";

/** Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos. **/
-- Porque los titulos de las peliculas es una forma comun de identificarlas