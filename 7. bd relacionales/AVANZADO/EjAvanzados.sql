-- Practica avanzada de BD

-- Ej 1 Mostrar el título y el nombre del género de todas las series.
select a.title, b.name 
from series a inner join genres b on a.genre_id= b.id;

-- Ej 2 Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
select a.title, c.first_name, c.last_name 
from episodes a inner join actor_episode b on b.episode_id= a.id
inner join actors c on b.actor_id = c.id;

-- Ej 3 Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT a.title, COUNT(b.id) AS total_temporadas
FROM series a
INNER JOIN seasons b ON b.serie_id = a.id
GROUP BY a.title;

-- Ej 4 Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, 
-- siempre que sea mayor o igual a 3.
select a.name , count(b.id) as cant_pelilulas
from genres a 
Inner join movies b on b.genre_id= a.id
group by a.name
having cant_pelilulas>=3;


-- Ej 5 Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de 
-- la guerra de las galaxias y que estos no se repitan.
select  distinct a.first_name, a.last_name 
from actors a inner join actor_movie b on b.actor_id = a.id
inner join movies c on c.id = b.movie_id
where c.title like "%La Guerra de las galaxias%"
