-- Mostrar el título y el nombre del género de todas las series.
SELECT m.title, g.name
FROM movies AS m
INNER JOIN genres AS g ON m.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title, a.first_name, a.last_name
FROM episodes AS e
INNER JOIN actor_episode AS ae ON e.id = ae.episode_id
INNER JOIN actors AS a ON ae.actor_id = a.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT title, COUNT(*)

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.

