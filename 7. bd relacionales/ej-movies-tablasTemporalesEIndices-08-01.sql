/*Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” 
y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.*/

with TWD as (
	select e.title episode_title, 
		e.number episode_number, 
		e.release_date, 
		s.title season_title, 
		s.number season_number ,
        se.title serie_title
	from episodes e 
	join seasons s on s.id = e.season_id
	join series se on se.id = s.serie_id 
	where se.title like 'The Walking Dead'
)
select * from TWD where season_number = 1;

/*En la base de datos “movies”, seleccionar una tabla donde crear un índice 
y luego chequear la creación del mismo.*/

create index title_index
on series(title);

show index from series;