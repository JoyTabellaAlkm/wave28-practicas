-- Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name as genre
FROM series s
LEFT JOIN genres g on s.genre_id = g.id;
-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title, a.first_name, a.last_name
FROM episodes e
LEFT JOIN actor_episode ae on ae.episode_id = e.id
LEFT JOIN actors a on a.id = ae.actor_id;
-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT  ser.title, MAX(sea.number) as total_temporadas
FROM series ser
INNER JOIN seasons sea on ser.id = sea.serie_id
group by ser.title;
-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name, count(1) as total
FROM genres g
INNER JOIN movies m on m.genre_id = g.id
GROUP BY m.genre_id
HAVING total >= 3;
-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT  a.first_name, a.last_name
FROM actors a 
INNER JOIN actor_movie am on am.actor_id = a.id
INNER JOIN movies m on m.id = am.movie_id
WHERE m.title LIKE 'La Guerra de las galaxias%'
GROUP BY am.actor_id;