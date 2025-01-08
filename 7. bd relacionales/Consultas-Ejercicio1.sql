-- SELECT * FROM movies;

-- SELECT first_name, last_name, rating FROM actors;

-- SELECT title as titulo FROM series;

-- SELECT first_name, last_name FROM actors WHERE rating > 7.5

-- SELECT title, rating awards FROM movies WHERE rating > 7.5 AND awards > 2

-- SELECT title, rating FROM movies ORDER BY rating;

-- SELECT title FROM movies LIMIT 3;

-- SELECT title, rating FROM movies ORDER BY rating DESC LIMIT 5;

-- SELECT first_name, last_name FROM actors LIMIT 10;

-- SELECT title, rating FROM movies WHERE title LIKE 'Toy Story%';

-- SELECT first_name, last_name FROM actors WHERE first_name LIKE '%Sam'

-- SELECT title FROM movies WHERE YEAR(release_date) BETWEEN 2004 AND 2008;

-- SELECT title FROM movies WHERE rating > 3 AND awards > 1 AND YEAR(release_date) BETWEEN 1988 AND 2009 ORDER BY rating;
