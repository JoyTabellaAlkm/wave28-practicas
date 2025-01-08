#Mostrar el título y el nombre del género de todas las series.
select series.title, genres.name genero
from genres inner join series on genres.id = series.genre_id;

#Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
select episodes.title, actors.first_name, actors.last_name
from episodes inner join actor_episode on episodes.id=actor_episode.episode_id
inner join actors on actors.id=actor_episode.actor_id;

#Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
select s.title, count(se.number)
from seasons se inner join series s on se.serie_id = s.id
group by s.id;

#Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
select g.name, count(m.id) total
from genres g inner join movies m on g.id=m.genre_id
group by g.id
having count(m.id) >= 3;

#Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias 
#y que estos no se repitan.
select a.first_name, a.last_name
from actors a inner join actor_movie am on a.id=am.actor_id 
inner join movies m on m.id=am.movie_id
where m.id in (select m.id from movies m where title like 'La Guerra de las galaxias%')
group by a.id;



