USE movies_db;

-- 1. Mostrar el título y el nombre del género de todas las series.
SELECT
    s.title AS serie_title,
    g.name
FROM
    series s
JOIN
    genres g ON s.genre_id = g.id;

-- 2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT
    e.title AS episode_title,
    a.first_name AS actor_name,
    a.last_name AS actor_last_name
FROM
    episodes e
JOIN
    actor_episode ae ON e.id = ae.episode_id
JOIN
    actors a ON ae.actor_id = a.id;

-- 3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT
    s.title AS serie_title,
    COUNT(ss.id) AS seasons_total
FROM
    series s
LEFT JOIN
    seasons ss ON s.id = ss.serie_id
GROUP BY
    s.id;

-- 4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT
    g.name,
    COUNT(m.id) AS movies_count
FROM
    genres g
JOIN
    movies m ON g.id = m.genre_id
GROUP BY
    g.id
HAVING
    COUNT(m.id) >= 3;

-- 5. Encuentra los actores que han participado en todas las películas de "La Guerra de las Galaxias"
SELECT
    a.first_name,
    a.last_name
FROM
    actors a
JOIN
    actor_movie am ON am.actor_id = a.id
JOIN
    movies m ON am.movie_id = m.id
WHERE
    m.title LIKE '%Guerra de las Galaxias%'  -- o el título exacto si es necesario
GROUP BY
    a.id
HAVING
    COUNT(DISTINCT m.id) = (SELECT COUNT(*)
                                      FROM movies
                                      WHERE title LIKE '%Guerra de las Galaxias%');
