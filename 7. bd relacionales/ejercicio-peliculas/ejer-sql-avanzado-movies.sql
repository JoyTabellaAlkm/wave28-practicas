-- Ejercicios Segunda parte SQL avanzado

-- 1: Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name
FROM series as s 
LEFT JOIN genres as g
ON s.genre_id = g.id;

-- 2: Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title, a.first_name, a.last_name
FROM episodes as e 
LEFT JOIN actor_episode ac 
ON ac.episode_id = e.id
LEFT JOIN actors as a
ON ac.actor_id = a.id;

-- 3: Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT s.title, COUNT(serie_id) as season_count
FROM series as s
LEFT JOIN seasons as se
ON s.id = se.serie_id
GROUP BY title;

-- 4: Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name, COUNT(name) as movie_count
FROM movies as m
LEFT JOIN genres as g
ON m.genre_id = g.id
GROUP BY name
HAVING COUNT(name) >= 3;


-- 5: Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias 
-- y que estos no se repitan.
SELECT DISTINCT a.first_name, a.last_name
FROM movies as m 
LEFT JOIN actor_movie as am
ON am.movie_id = m.id
LEFT JOIN actors as a
ON am.actor_id = a.id
WHERE m.title LIKE("La guerra de las galaxias%");