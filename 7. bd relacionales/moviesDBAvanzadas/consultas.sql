-- 1.
SELECT title AS titulo, name AS nombre_serie
FROM series AS s INNER JOIN genres AS g
                            ON g.id = s.genre_id;

-- 2.
SELECT title AS titulo_episodio, first_name AS nombre, last_name AS apellido
FROM actors AS a INNER JOIN actor_episode AS acse INNER JOIN episodes AS e
                                                             ON a.id = acse.actor_id AND e.id = acse.episode_id;

-- 3.
SELECT ser.title AS titulo_serie, COUNT(1) AS total_temporadas
FROM series AS ser INNER JOIN seasons AS sea
                              ON  ser.id = sea.serie_id
GROUP BY ser.id
ORDER BY total_temporadas DESC;

-- 4.
SELECT g.name AS nombre_genero, COUNT(1) AS cantidad_peliculas
FROM genres AS g INNER JOIN movies AS m
                            ON g.id = m.genre_id
GROUP BY g.id
HAVING cantidad_peliculas > 3;

-- 5.
SELECT DISTINCT a.first_name AS nombre, a.last_name AS apellido
FROM actors AS a INNER JOIN actor_movie AS am
                            ON a.id = am.actor_id
WHERE am.movie_id IN (SELECT id FROM movies as m WHERE m.title LIKE 'La Guerra de%');