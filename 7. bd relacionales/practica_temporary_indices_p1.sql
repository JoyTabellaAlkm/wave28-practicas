/*
	EJERCICIO 1
1.Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y 
guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
2. Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
*/

-- 1. 
DROP TABLE IF EXISTS TWD;

CREATE TEMPORARY TABLE TWD 
(SELECT episodes.*, seasons.title AS season_title FROM episodes INNER JOIN seasons ON episodes.season_id = seasons.id 
INNER JOIN series ON series.id = seasons.serie_id  
WHERE series.title = "The Walking Dead" );


-- 2.
SELECT * FROM TWD;
SELECT * FROM TWD WHERE season_title = "primer temporada";

/*
	EJERCICIO 2
1. En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
2. Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
*/

-- 1.
CREATE INDEX title_idx ON movies (title);
SHOW INDEX FROM movies;
-- 2. Se selecciona debido a que se puede requerir buscar información especifica de la pelicula que se buscará
-- normalmente por nombre