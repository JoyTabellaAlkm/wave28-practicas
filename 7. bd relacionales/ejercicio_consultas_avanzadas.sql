USE movies_db;
-- 1
select s.title as titulo, g.name as genero
from series s 
join genres g on g.id = s.genre_id;

-- 2
select e.title, a.first_name as nombre, a.last_name
from actor_episode as ae
join actors as a on a.id = ae.actor_id
join episodes as e on e.id = ae.episode_id;

-- 3
select series.title, count(seasons.id)
from series
join seasons on seasons.serie_id = series.id
group by series.title;

-- 4
select g.name, count(m.genre_id) as cant
from genres as g
join movies as m on m.genre_id = g.id
group by g.name
having cant >= 3;

-- auxiliar: cant de peliculas de la guerra por actor
select am.actor_id, COUNT(m.id)
from actor_movie as am
join movies as m on am.movie_id = m.id
where m.title LIKE "La Guerra de las galaxias%"
group by am.actor_id;

-- auxiliar: cant de peliculas de la guerra de las galaxias
select count(*) from movies where movies.title LIKE "La Guerra de las galaxias%";


-- 5
select DISTINCT act.first_name, act.last_name
from actors act
join (select am.actor_id, COUNT(m.id) as guerra_count
		from actor_movie as am
		join movies as m on am.movie_id = m.id
		where m.title LIKE "La Guerra de las galaxias%"
		group by am.actor_id
        having guerra_count = (
			select count(*) 
			from movies 
            where movies.title LIKE "La Guerra de las galaxias%"
		)
) as cantidades 
on cantidades.actor_id = act.id;

