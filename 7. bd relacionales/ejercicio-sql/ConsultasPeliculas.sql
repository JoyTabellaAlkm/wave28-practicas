SELECT first_name, last_name, rating FROM actors;

SELECT title AS 'titulo' FROM series as tabla_series;

SELECT * FROM movies;

SELECT first_name, last_name FROM movies_db.actors WHERE rating > 7.5;

SELECT title, rating, awards 
FROM movies_db.movies 
WHERE rating > 7.5 AND awards > 2;

SELECT * FROM actors WHERE nombre LIKE 'Sam%';

SELECT * FROM actors LIMIT 10;

SELECT title, rating FROM movies_db.movies ORDER BY rating ASC;

SELECT * FROM movies_db.movies ORDER BY rating DESC LIMIT 5;

SELECT title, rating
FROM movies
WHERE title LIKE "Toy Story%";
SELECT title
FROM movies
WHERE release_date BETWEEN "2004-01-01" AND "2007-12-31";

SELECT * FROM movies
WHERE rating > 3
AND awards > 1
AND release_date BETWEEN "1988-01-01" AND "2008-12-31"
ORDER BY rating DESC;
