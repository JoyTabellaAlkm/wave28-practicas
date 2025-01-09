
#Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
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

#En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
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
