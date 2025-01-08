use movies_db;

CREATE TEMPORARY TABLE TWD(
title varchar(255),
season varchar(255)
);

INSERT INTO TWD
SELECT e.title, seasons.title as season FROM episodes AS e
INNER JOIN seasons ON e.season_id = seasons.id
INNER JOIN series ON seasons.serie_id = series.id
WHERE series.title = 'The Walking Dead';

SELECT * FROM TWD WHERE season = 'Primer Temporada';

CREATE INDEX rating_index ON movies(rating);