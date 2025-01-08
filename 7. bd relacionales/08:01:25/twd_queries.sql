DROP INDEX idx_title ON series;
CREATE INDEX idx_title ON series(title);
SHOW INDEX FROM series;

DROP TEMPORARY TABLE IF EXISTS TWD;
CREATE TEMPORARY TABLE TWD AS
SELECT 
    e.id AS episode_id,      
    e.title AS episode_title,  
    e.number AS episode_number,
    sea.number AS season_number,  
    ser.title AS series_title    
FROM episodes e
INNER JOIN seasons sea ON sea.id = e.season_id
INNER JOIN series ser ON ser.id = sea.serie_id
WHERE ser.title = 'The Walking Dead';
SELECT * FROM TWD;


SELECT *
FROM TWD
WHERE season_number = 1;
