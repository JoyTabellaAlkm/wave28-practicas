-- Exercise 1
SELECT s.title, g.name FROM series s
LEFT JOIN genres g on g.id = s.genre_id;

-- Exercise 2
SELECT e.title, a.first_name, a.last_name FROM episodes e
INNER JOIN actor_episode axe ON axe.episode_id = e.id
INNER JOIN actors a ON axe.actor_id = a.id;

-- Exercise 3
SELECT ser.title, COUNT(ser.title) seasons FROM seasons sea
LEFT JOIN series ser ON ser.id = sea.serie_id
GROUP BY ser.title;

-- Exercise 4
SELECT g.name, count(g.name) movies FROM movies m
LEFT JOIN genres g ON m.genre_id = g.id
GROUP BY g.name
HAVING movies > 3;

-- Exercise 5
SELECT a.first_name, a.last_name FROM movies m
INNER JOIN actor_movie axm ON axm.movie_id = m.id
INNER JOIN actors a ON axm.actor_id = a.id
WHERE title LIKE 'La Guerra de las galaxias:%'
GROUP BY a.first_name, a.last_name
HAVING COUNT(*) > 1;


