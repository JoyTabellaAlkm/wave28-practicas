USE movies_db;
DROP TABLE IF EXISTS TWD;

# Ejercicio 1
# Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.

CREATE TEMPORARY TABLE TWD (
    episodio VARCHAR(100),
    temporada VARCHAR(100)
);

INSERT INTO TWD SELECT e.title, sea.title
				FROM series ser
				JOIN seasons sea ON ser.id = sea.serie_id
				JOIN episodes e ON sea.id = e.season_id
				WHERE ser.title = "The Walking Dead";

SELECT * 
FROM TWD;

# Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT episodio
FROM TWD
WHERE temporada = "Primer Temporada";

# Ejercicio 2
# En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
ALTER TABLE movies
ADD INDEX awards_index (awards);

SHOW INDEX FROM movies;

# Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
EXPLAIN SELECT * FROM movies WHERE awards >= 3;
# Es una tabla donde se pueden generar consultas considerables de a cuerdo a los premios obtenidos, en la prueba realizada, se reduce considerablemente la cantidad de filas buscadas.
