# Selecciono la base de datos
use movies_db;

# INNER JOIN entre actors y movies
SELECT actors.id AS 'ID', actors.first_name as 'Nombre', actors.last_name as 'Apellido', actors.rating as 'Rating',
       movies.title AS 'Nombre de pelicula' , movies.rating AS 'Rating'
FROM actors
INNER JOIN movies ON actors.favorite_movie_id = movies.id;

# GROUP BY
# Primer query
SELECT COUNT(*), mo.title, mo.rating, mo.awards
FROM movies mo INNER JOIN actors ac 
ON mo.id = ac.favorite_movie_id 
GROUP BY title;

# FIXED --> Agrego todas las columnas faltantes
# la configuración sql_mode=only_full_group_by en MySQL requiere que todas las columnas 
# en la cláusula SELECT que no estén dentro de una función de agregación
# también estén presentes en la cláusula GROUP BY.
SELECT COUNT(*), mo.title, mo.rating, mo.awards
FROM movies mo 
INNER JOIN actors ac ON mo.id = ac.favorite_movie_id 
GROUP BY mo.title, mo.rating, mo.awards;


# Having 
# Es una cláusula que se utiliza en SQL junto con la cláusula GROUP BY
# para filtrar los resultados de un conjunto de filas agrupadas por algún criterio.
SELECT COUNT(*) AS tot_act, mo.title, mo.rating, mo.awards
FROM movies mo INNER JOIN actors ac 
ON mo.id = ac.favorite_movie_id 
GROUP BY title HAVING tot_act > 2;

# En esta consulta, HAVING tot_act > 2 filtra los resultados agrupados para mostrar solo aquellas películas que tienen más de 2 actores.
SELECT COUNT(*) AS tot_act, mo.title, mo.rating, mo.awards
FROM movies mo 
INNER JOIN actors ac ON mo.id = ac.favorite_movie_id 
GROUP BY mo.title, mo.rating, mo.awards 
HAVING tot_act > 2;

# EJEMPLO - Query para contar el número de películas en las que han actuado los actores
SELECT first_name, COUNT(*) AS total_movies
FROM actors
GROUP BY first_name
HAVING total_movies < 3;

# Subconsultas
# Devuelve todas las relaciones entre actores y películas donde las películas tienen un rating de 9.0
SELECT *
FROM actor_movie am
WHERE movie_id IN (SELECT id FROM movies WHERE rating=9.0);


# EJEMPLO - Esta consulta traerá el título y la calificación de las películas que tienen la fecha de lanzamiento más reciente.
SELECT title as 'Título', rating as 'Rating', release_date as 'Fecha' 
FROM movies 
WHERE release_date = (SELECT MAX(release_date) FROM movies);

# EJEMPLO - Esta consulta traerá el título y la calificación de las películas que tienen la fecha de lanzamiento más vieja.
SELECT title as 'Título', rating as 'Rating', release_date as 'Fecha' 
FROM movies 
WHERE release_date = (SELECT MIN(release_date) FROM movies);


# EJEMPLO - BONUS - Esta consulta traerá todas las películas que no tienen asignado el género "Comedia".
SELECT *
FROM movies
WHERE id NOT IN (
    SELECT id
    FROM genres
    WHERE id = (
        SELECT id
        FROM genres
        WHERE name = 'Terror'
    )
);
