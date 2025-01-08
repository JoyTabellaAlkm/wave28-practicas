DROP TABLE IF EXISTS TWD;
CREATE TEMPORARY TABLE TWD(
title varchar(500),
rating decimal(3,1),
season varchar(500)
);
INSERT INTO TWD
SELECT ep.title, ep.rating, sea.title as Temporada FROM episodes ep
JOIN seasons sea ON ep.season_id = sea.id
JOIN series ser ON ser.id = sea.serie_id
WHERE ser.title LIKE '%The Walking Dead%';

SELECT * FROM TWD
where season = 'Primer Temporada';
