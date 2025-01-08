-- Mostrar el título y el nombre del género de todas las series.
select s.title, g.name from series s join genres g on g.id = s.genre_id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
select e.title, a.first_name, a.last_name from episodes e 
join actor_episode ae on e.id = ae.episode_id
join actors a on a.id = ae.actor_id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
select s.title , count(se.id) as cantidad_temporadas from series s join seasons se on s.id = se.serie_id
group by s.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, 
-- siempre que sea mayor o igual a 3.
select g.name, count(m.id) cantidad_peliculas from genres g join movies m on m.genre_id = g.id
group by g.name
having cantidad_peliculas >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas 
-- de la guerra de las galaxias y que estos no se repitan.

select distinct first_name, last_name from actors a 
join actor_movie am on am.actor_id = a.id join movies m on m.id = am.movie_id
where lower(m.title) like ('%guerra de las galaxias%')



