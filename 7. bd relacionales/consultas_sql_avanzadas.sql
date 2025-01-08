-- 1. Mostrar el título y el nombre del género de todas las series.
select s.title, g.name as genre from series as s inner join genres as g on s.genre_id = g.id;

-- 2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
select e.title, a.first_name, a.last_name
from actor_episode as act_ep
inner join episodes as e on act_ep.episode_id = e.id
inner join actors as a on act_ep.actor_id = a.id;

-- 3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
select series.title, count(*) as numero_temporadas
from series inner join seasons on series.id = seasons.serie_id
group by series.title;

-- 4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
select g.name, count(*) as cant_peliculas
from genres as g inner join movies as m on g.id = m.genre_id
group by g.name
having cant_peliculas >= 3;

-- 5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
select distinct a.first_name, a.last_name
from actor_movie
	inner join actors as a on a.id = actor_movie.actor_id
    inner join movies as m on m.id = actor_movie.movie_id
where m.title like 'La Guerra de las galaxias%';







