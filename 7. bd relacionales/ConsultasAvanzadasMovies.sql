-- Mostrar el título y el nombre del género de todas las series.
select series.title, genres.name from series inner join genres on series.genre_id = genres.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT episodes.title AS episode_title, actors.first_name AS actor_first_name, actors.last_name AS actor_last_name
FROM episodes
INNER JOIN actor_episode ON episodes.id = actor_episode.episode_id
INNER JOIN actors ON actor_episode.actor_id = actors.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT series.title,( SELECT COUNT(*) FROM seasons WHERE seasons.serie_id = series.id) AS total_seasons FROM series;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.select * from genres;
SELECT genres.name,( SELECT COUNT(*) FROM movies WHERE movies.genre_id = genres.id) AS total_movies FROM genres HAVING total_movies >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT actors.first_name, actors.last_name
FROM actors INNER JOIN actor_movie ON actors.id = actor_movie.actor_id
WHERE actor_movie.movie_id IN (SELECT id FROM movies WHERE movies.title LIKE '%galaxias%')
