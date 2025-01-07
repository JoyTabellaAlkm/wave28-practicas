SELECT * FROM movies;

SELECT first_name, last_name, rating FROM actors;

SELECT title as Titulo FROM series as Serie;

SELECT first_name, last_name FROM actors WHERE rating > 7.5;

SELECT title, rating, awards FROM movies WHERE rating > 7.5 AND awards > 2;

SELECT title, rating FROM movies ORDER BY rating;

SELECT title FROM movies LIMIT 3;

SELECT title FROM movies ORDER BY RATING DESC LIMIT 5;

SELECT * FROM actors LIMIT 10;

SELECT title, rating FROM movies WHERE title LIKE "Toy Story%";

SELECT * FROM actors WHERE first_name LIKE "Sam%";

SELECT * FROM movies WHERE release_date BETWEEN "2004-01-01 00:00:00" AND "2008-12-31 23:59:59";

SELECT title FROM movies 
WHERE rating > 3 AND 
awards > 1 AND 
release_date BETWEEN "1988-01-01 00:00:00" AND "2009-12-31 23:59:59" ORDER BY rating;