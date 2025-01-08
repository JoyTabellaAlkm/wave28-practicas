CREATE TEMPORARY TABLE TWD (
    nombre_episodio VARCHAR(50),
    id_episodio INT,
    numero_temporada INT
);

INSERT INTO
    TWD
SELECT
    ep.title,
    ep.id,
    sea.number
FROM
    episodes ep
    JOIN seasons sea ON sea.id = ep.season_id
    JOIN series ser ON ser.id = sea.serie_id
WHERE
    ser.title = 'The Walking Dead';

SELECT
    *
FROM
    TWD
WHERE
    numero_temporada = 1;

CREATE INDEX movie_title_idx ON movies (title);

CREATE INDEX serie_title_idx ON series (title);