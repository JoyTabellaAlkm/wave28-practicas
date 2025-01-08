
-- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma 
-- los episodios de todas las temporadas de “The Walking Dead”.
-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.

CREATE TEMPORARY TABLE TWD 
(SELECT epi.* FROM series ser
JOIN seasons sea ON ser.id = sea.serie_id
JOIN episodes epi ON sea.id = epi.season_id
WHERE ser.title = 'The Walking Dead');

SELECT * FROM TWD twd
JOIN seasons sea ON twd.season_id = sea.id
WHERE sea.number = 1;


/* En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos. */

CREATE INDEX movie_name ON movies (title); 

/* 
Decidimos colocar un índice sobre el campo 'title' ya que suele ser un filtro de búsqueda de los usuarios, de manera tal de optimizar el tiempo de 
dichas búsquedas.
*/



