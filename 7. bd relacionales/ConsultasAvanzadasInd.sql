-- Mostrar el título y el nombre del género de todas las series.
SELECT series.title, genres.name
from series join genres
on series.genre_id = genres.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT
    e.title as episode_title,
    a.first_name as actor_first_name,
    a.last_name as actor_last_name
FROM episodes e
JOIN actor_episode ae on e.id = ae.episode_id
JOIN actors a on ae.actor_id = a.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT series.title, COUNT(seasons.id) as temporadas
from series join seasons
on series.id = seasons.serie_id
group by serie_id ;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.select * from genres;

SELECT genres.name, COUNT(movies.genre_id) as total
from genres join movies
on genres.id = movies.genre_id
group by genre_id
having total >= 3;
-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.

SELECT DISTINCT actors.first_name, actors.last_name
FROM actors INNER JOIN actor_movie ON actors.id = actor_movie.actor_id
WHERE actor_movie.movie_id IN (SELECT id FROM movies WHERE movies.title LIKE '%galaxias%');
