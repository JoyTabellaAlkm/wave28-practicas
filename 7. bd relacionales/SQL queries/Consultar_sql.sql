-- Ejercicio 1
SELECT * FROM movies;

-- Ejercicio 2
SELECT first_name, last_name, rating FROM actors;

-- Ejercicio 3
SELECT title as Titutlo FROM series as Series;

-- Ejercicio 4
SELECT first_name, last_name FROM actors WHERE rating > 7.5;

-- Ejercicio 5
SELECT title, rating, awards FROM movies WHERE (rating > 7.5 and awards > 2);

-- Ejercicio 6
SELECT title, rating FROM movies ORDER BY rating ASC;

-- Ejercicio 7
SELECT title FROM movies LIMIT 3;

-- Ejercicio 8
Select * From movies Order by rating Desc Limit 5;

-- Ejercicio 9
Select * From actors Limit 10;

-- Ejercicio 10
Select title, rating From movies Where title like "Toy Story%";

-- Ejercicio 11
Select * From actors Where title like "Sam%";

-- Ejercicio 12
Select title From movies Where YEAR(release_date) Between 2004 and 2008;

-- Ejercicio 13
Select title From movies
Where rating > 3
and awards > 1
and YEAR(release_date) Between 1988 and 2009
Order By rating;



