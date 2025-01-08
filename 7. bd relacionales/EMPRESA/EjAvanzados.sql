-- Practica avanzada de BD

-- Ej 1 Mostrar el título y el nombre del género de todas las series.
SELECT a.title, b.name 
FROM series a INNER JOIN genres b on a.genre_id= b.id;

-- Ej 2 Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT a.title, c.first_name, c.last_name 
FROM episodes a INNER JOIN actor_episode b on b.episode_id= a.id
INNER JOIN actors c ON b.actor_id = c.id;

-- Ej 3 Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT a.title, COUNT(b.id) AS total_temporadas
FROM series a
INNER JOIN seasons b ON b.serie_id = a.id
GROUP BY a.title;

-- Ej 4 Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, 
-- siempre que sea mayor o igual a 3.
SELECT a.name , count(b.id) as cant_pelilulas
FROM genres a 
INNER JOIN movies b on b.genre_id= a.id
GROUP BY a.name
HAVING cant_pelilulas>=3;

-- Ej 5 Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de 
-- la guerra de las galaxias y que estos no se repitan.
SELECT  DISTINCT a.first_name, a.last_name 
FROM actors a INNER JOIN  actor_movie b ON b.actor_id = a.id
INNER JOIN movies c ON c.id = b.movie_id
WHERE c.title LIKE "%La Guerra de las galaxias%"
