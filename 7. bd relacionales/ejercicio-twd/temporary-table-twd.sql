-- Ejercicio 1
-- 1.
use movies_db;

CREATE TEMPORARY TABLE TWD (
	id int primary key,
    title varchar(255),
    season_title varchar(255)
);

INSERT INTO TWD
SELECT e.id, e.title, se.title
FROM series s INNER JOIN seasons se
ON s.id = se.serie_id
INNER JOIN episodes e
ON e.season_id = se.id
WHERE s.title = "The Walking Dead";

-- 2.
-- Ver todas las temporadas
SELECT * FROM TWD;
-- Ver la primer temporada
SELECT * FROM TWD
WHERE season_title = "Primer temporada";

-- Ejercicio 2
CREATE INDEX rating_index
ON movies (rating);

SHOW INDEX FROM movies;
