select count(*) as tot_act , 
	movies.title,
	movies.rating,
	movies.awards 
from movies
inner join actors 
on movies.id = actors.favorite_movie_id 
group by movies.title, movies.rating, movies.awards
having tot_act > 2;


/*Subconsultas*/
select * from actor_movie where movie_id in (select id from movies where rating = 9.0);

/* 
1. Mostrar el título y el nombre del género de todas las series.
2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias 
y que estos no se repitan.
*/

/*1*/
select s.title, g.name from series s inner join genres g where s.genre_id = g.id;
/*2*/


/*3*/
SELECT series.title, COUNT(seasons.id) AS cantidad_temporadas 
FROM series JOIN seasons
ON series.id = seasons.serie_id
GROUP BY series.title;

/*4*/
SELECT g.name, COUNT(m.id) AS cantidad_peliculas
FROM genres g JOIN movies m
ON m.genre_id = g.id
GROUP BY g.name
HAVING cantidad_peliculas >= 3;

/*5*/
SELECT a.first_name, a.last_name
FROM actors a JOIN actor_movie am
ON a.id = am.actor_id
WHERE am.movie_id IN (SELECT id FROM movies WHERE title LIKE "La guerra de las galaxias%")
GROUP BY a.first_name, a.last_name;

