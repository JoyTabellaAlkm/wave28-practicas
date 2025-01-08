#Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
drop temporary table TWD;
create temporary table TWD as select e.title, s.number season from episodes e 
				inner join seasons s on e.season_id = s.id 
				inner join series se on se.id = s.serie_id
                where se.title = "The Walking Dead";
                
select * 
from TWD;

#Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
select * 
from TWD
where season = 1;

#En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
create index title_index on movies (title);
show index from movies

#Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
#Porque nos parece que la forma mas normal de identificar una pelicula es atravez de su titulo.

