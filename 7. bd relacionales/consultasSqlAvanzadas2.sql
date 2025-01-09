SELECT * FROM movies;

INSERT INTO movies VALUES(22, null, null, 'Mohana 2', 7.0, 4, '2024-12-10',100, 13);

INSERT INTO genres VALUES(13, '1990-07-22', null, 'Disney', 13, 1);

UPDATE actors SET favorite_movie_id = 13 WHERE id = 21;

CREATE TEMPORARY TABLE COPY_MOVIES(SELECT * FROM movies);

SELECT * FROM copy_movies;

DELETE FROM copy_movies WHERE awards > 5;

SELECT 
    g.name AS genre_name, COUNT(m.id) AS total_movies
FROM
    movies m
        INNER JOIN
    genres g ON m.genre_id = g.id
GROUP BY g.name;


SELECT actors.first_name, actors.last_name, movies.awards FROM actors
INNER JOIN movies ON actors.favorite_movie_id = movies.id
WHERE movies.awards > 3;

CREATE INDEX title_indice ON movies (title);

SHOW INDEX FROM movies;
