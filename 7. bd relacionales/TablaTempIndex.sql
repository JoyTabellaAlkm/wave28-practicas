/* Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y 
guardar en la misma los episodios de todas las temporadas de “The Walking Dead”. */

create temporary table TWD
select episodes.* from episodes inner join seasons on episodes.season_id = seasons.id
inner join series on seasons.serie_id = series.id where series.title = 'The Walking Dead';

-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
select * from TWD inner join seasons on TWD.season_id = seasons.id where seasons.number = 1;

-- En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
DROP INDEX season_idx ON seasons;
explain select * from seasons where number = 9;
create index season_idx on seasons(number);
explain select * from seasons where number = 9;
SHOW INDEX FROM seasons;

-- Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
-- como en la consulta anterior filtamos por numero de temp. no seria raro seguir haciendolo y hace mucho mas rapido la busqueda.