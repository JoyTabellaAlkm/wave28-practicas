USE movies_db;

-- 1.
INSERT INTO movies (title, rating, awards, release_date, length, genre_id)
VALUES ('Nemo', 8.5, 3, '2023-10-25 00:00:00', 120, NULL);

-- 2. 
INSERT INTO genres (name, ranking, active)
VALUES ('familiar', 14, 1);


SET @new_movie_id = (SELECT id FROM movies WHERE title = 'Nemo');
SET @new_genre_id = (SELECT id FROM genres WHERE name = 'familiar');
UPDATE movies
SET genre_id = @new_genre_id
WHERE id = @new_movie_id;

-- 4. 
UPDATE actors
SET favorite_movie_id = @new_movie_id
WHERE id = 1; 

-- 5. 
CREATE TEMPORARY TABLE movies_temp AS
SELECT * FROM movies;
DELETE FROM movies_temp
WHERE awards < 5;

-- 6. 
SELECT DISTINCT g.name
FROM genres g
JOIN movies m ON g.id = m.genre_id;

-- 7. 
SELECT a.first_name, a.last_name
FROM actors a
JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

-- 8. 
CREATE INDEX idx_movie_title ON movies(title);

-- 9. 
SHOW INDEX FROM movies WHERE Key_name = 'idx_movie_title';

-- 10. 
CREATE INDEX idx_actor_name ON actors(first_name, last_name);