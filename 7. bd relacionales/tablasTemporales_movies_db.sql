-- 	EJERCICIO 1
-- 1. Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y 
-- guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
DROP TABLE IF EXISTS TWD;
CREATE TEMPORARY TABLE TWD (episode_title VARCHAR(45), season_number INT,  season VARCHAR(45), series VARCHAR(45));
INSERT INTO TWD SELECT e.title, sea.number, sea.title, s.title
FROM series s
INNER JOIN seasons sea ON sea.serie_id = s.id
INNER JOIN episodes e ON e.season_id = sea.id
WHERE s.title = 'The Walking Dead';

SELECT * FROM TWD;
-- 2.Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT * FROM TWD WHERE season_number = 1;


