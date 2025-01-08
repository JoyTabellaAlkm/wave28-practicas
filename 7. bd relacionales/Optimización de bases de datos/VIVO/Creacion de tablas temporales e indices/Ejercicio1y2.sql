-- Con la base de datos "movies", se propone crear una tabla temporal llamada "TWD" y
-- guardar en la misma los episodios de todas las temporadas de "The Walking Dead".
CREATE TEMPORARY TABLE TWD AS (
	SELECT epi.*
    FROM episodes as epi
    JOIN seasons ON seasons.id = epi.season_id
    JOIN series ON series.id = seasons.serie_id
    WHERE series.title = "The Walking Dead"
);

-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT *
FROM TWD
         JOIN seasons ON seasons.id = TWD.season_id
WHERE seasons.number = 1;

-- En la base de datos "movies", seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
CREATE INDEX nombre_peliculas_index ON movies (title);
SHOW INDEX from movies;

-- Se crea el indice sobre la tabla movies utilizando la columna de titulos ya que suele consultarse/buscarse las peliculas en funcion del nombre.