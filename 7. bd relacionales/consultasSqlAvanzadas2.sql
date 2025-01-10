-- Parte 1

#Con la base de datos "movies", se propone crear una tabla temporal llamada "TWD" y guardar en la misma los episodios de todas las temporadas de "The Walking Dead".
#Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.

CREATE TEMPORARY TABLE TWD (SELECT 
    e.title AS episodio, sea.title AS temporada
FROM
    series ser
        JOIN
    seasons sea ON ser.id = sea.serie_id
        JOIN
    episodes e ON sea.id = e.season_id
WHERE
    ser.title = 'The Walking Dead');
            
            
SELECT * FROM TWD;

#En la base de datos "movies", seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
#Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.

EXPLAIN SELECT * FROM movies WHERE rating > 5;
#Salen todos los registros afectados

CREATE index idx_movie ON movies(rating);

EXPLAIN SELECT * FROM movies WHERE rating > 5;
#Se nota la diferencia y la cantidad de columnas se ha reducido

/*
    Ranking de películas: Mostrar las películas con mejor o peor calificación.
    Recomendaciones: sugerir películas populares basadas en su puntaje.
*/

-- Parte 2

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
