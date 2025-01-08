-- Ejercicio 2

/** Primera Parte **/

/** 
1. ¿A qué se denomina JOIN en una base de datos y para qué se utiliza?
Es una forma de combinar 

2. Explicar dos tipos de JOIN.
Inner join es el join por defecto que obtiene la interseccion entre dos tablas
Left join obtiene los datos de la tabla izquierda junto con la interseccion entre las dos tablas

3. ¿Para qué se utiliza el GROUP BY?
Para agrupar resultados segun una columna indicada

4. ¿Para qué se utiliza el HAVING?
Se utiliza como WHERE (condiciones) pero para conjuntos agrupados

5. Escribir una consulta genérica para cada uno de los siguientes diagramas

SELECT * FROM <table_1> JOIN <table_2> ON <condition>;

SELECT * FROM <table_1> LEFT JOIN <table_2> ON <condition>;

**/

/** Segunda Parte **/

/** Mostrar el título y el nombre del género de todas las series. **/
SELECT title, name 
FROM series AS s 
JOIN genres AS g ON g.id = s.genre_id;

/** Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos. **/
SELECT title, first_name, last_name
FROM (
	SELECT e.title, e.id AS episode_id, ae.actor_id
	FROM actor_episode AS ae 
    JOIN episodes AS e ON ae.episode_id = e.id) AS temp 
JOIN actors AS a ON temp.actor_id = a.id;

/**Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas. **/
SELECT series.title, COUNT(seasons.title) AS num_seasons
FROM seasons 
JOIN series ON seasons.serie_id = series.id
GROUP BY series.title;

/** Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3. **/
SELECT name, COUNT(name) as movies_count
FROM movies AS m 
JOIN genres AS g ON m.genre_id = g.id
GROUP BY name
HAVING COUNT(name) > 2;

/**Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que 
estos no se repitan. **/

SELECT DISTINCT first_name, last_name
FROM movies as m
JOIN (
	SELECT am.movie_id, first_name, last_name
	FROM actor_movie AS am
	JOIN actors AS a ON a.id = am.actor_id) AS temp ON temp.movie_id = m.id
WHERE m.title LIKE "La Guerra de las galaxias%";
