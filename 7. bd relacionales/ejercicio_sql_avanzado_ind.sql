use movies_db;

select * from genres;

-- Mostrar el título y el nombre del género de todas las series.
select series.title, genres.name from series
left join genres
on series.genre_id = genres.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
select episodes.title, actors.first_name, actors.last_name
from actor_episode
left join episodes on actor_episode.episode_id = episodes.id
left join actors on actor_episode.actor_id = actors.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
select series.title, count(seasons.id) as total_seasons
from series
left join seasons on seasons.serie_id = series.id
group by series.id, series.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
select * from genres;
select genres.name, count(movies.id) as total_movies
from genres
left join movies on movies.genre_id = genres.id
group by genres.id, genres.name
having count(movies.id) >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT a.first_name, a.last_name
FROM actors a
JOIN actor_movie am ON a.id = am.actor_id
JOIN movies m ON am.movie_id = m.id
WHERE m.title LIKE 'La guerra de las %'
GROUP BY a.id
HAVING COUNT(DISTINCT m.id) = (
    SELECT COUNT(*) 
    FROM movies 
    WHERE title LIKE 'La guerra de las %'
);




