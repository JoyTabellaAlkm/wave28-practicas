/*
1. Mostrar el título y el nombre del género de todas las series.
2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
*/

-- 1.
SELECT series.title, genres.name FROM series INNER JOIN genres ON series.genre_id = genres.id;

-- 2.
SELECT ep.title, ac.first_name, ac.last_name FROM episodes AS ep INNER JOIN actor_episode AS ae INNER JOIN actors AS ac ON ep.id = ae.episode_id AND ac.id = ae.actor_id;

-- 3. 
SELECT series.title, count(seasons.id) AS sea FROM seasons  INNER JOIN series ON seasons.serie_id = series.id GROUP BY seasons.serie_id;

-- 4.
SELECT genres.name, count(movies.title) FROM genres INNER JOIN movies ON genres.id=movies.genre_id GROUP BY movies.genre_id HAVING count(movies.title)>3; 

-- 5.
SELECT DISTINCT actors.first_name, actors.last_name FROM actors INNER JOIN actor_movie INNER JOIN movies 
ON actors.id = actor_movie.actor_id AND actor_movie.movie_id = movies.id
WHERE movies.title LIKE "La Guerra de las galaxias%";
