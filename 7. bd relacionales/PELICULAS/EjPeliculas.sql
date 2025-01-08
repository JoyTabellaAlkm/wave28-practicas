-- EJ 1 Mostrar todos los registros de la tabla de movies.

SELECT * FROM movies;

-- Ej 2 Mostrar el nombre, apellido y rating de todos los actores
select first_name, last_name, rating from actors;

-- Ej 3 Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
select title as Titulo from series;

-- Ej 4 Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
select first_name, last_name from actors where rating > 7.5;

-- Ej 5 Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 
-- y con más de dos premios.
select title, rating, awards from movies where rating> 7.5 and awards>2;

-- Ej 6 Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
select title , rating from movies order by rating asc;

-- Ej 7 Mostrar los títulos de las primeras tres películas en la base de datos
select title from movies limit 3;

-- Ej 8 Mostrar el top 5 de las películas con mayor rating.
select title, rating from movies order by rating desc limit 5;

-- Ej 9 Listar los primeros 10 actores.
select first_name, last_name from actors limit 10;

-- Ej 10 Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
select title, rating from movies where title like "%Toy Story %";

-- Ej 11 Mostrar a todos los actores cuyos nombres empiezan con Sam
select first_name, last_name from actors where first_name like "Sam%";

-- Ej 12 Mostrar el título de las películas que salieron entre el 2004 y 2008
select title from movies where Year(release_date) between 2004 and  2008; 

/* Ej 13 Traer el título de las películas con el rating mayor a 3, con más de 1 premio y 
con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.*/
select title from movies where rating>3 and awards>1 and Year(release_date) between 1988 and  2009 order by rating; 


 


