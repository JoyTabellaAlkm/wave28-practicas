-- Pruebas 
SELECT m.title, m.rating, m.awards, am.amount FROM movies m 
INNER JOIN
(SELECT m.id, COUNT(*) as amount FROM movies m
INNER JOIN actors c
ON m.id = c.favorite_movie_id
GROUP BY m.id) am
ON m.id = am.id;

SELECT movies.*, actors.first_name, actors.last_name
FROM movies INNER JOIN actors
ON movies.id = actors.favorite_movie_id;

SELECT * FROM movies mo LEFT JOIN actors ac ON mo.id = ac.favorite_movie_id;

-- ===== EJERCICIOS
-- 1. Mostrar el título y el nombre del género de todas las series.
SELECT m.title as "Nombre Película", g.name as "Género" FROM movies m
INNER JOIN genres g
ON m.genre_id = g.id;
-- Mostrar el título de los episodios, el nombre y 
-- apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title, CONCAT(a.first_name, " ", a.last_name) as actor FROM episodes e 
INNER JOIN actor_episode ae
ON e.id = ae.episode_id
INNER JOIN actors a
ON ae.actor_id = a.id;
-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT s.title, COUNT(*) as total_temporadas FROM series s
INNER JOIN seasons se
ON s.id = se.serie_id
GROUP BY 1;
-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno,
--  siempre que sea mayor o igual a 3.
SELECT g.name as genero, COUNT(*) FROM genres g
INNER JOIN movies m
ON m.genre_id = g.id
GROUP BY 1
HAVING COUNT(*) >= 3;
-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas
--  de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT a.first_name, a.last_name FROM actors a
INNER JOIN actor_movie am
ON a.id = am.actor_id
WHERE movie_id
IN (SELECT id FROM movies WHERE title LIKE "La guerra de las galaxias%");