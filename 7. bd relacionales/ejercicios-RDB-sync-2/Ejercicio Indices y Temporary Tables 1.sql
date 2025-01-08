CREATE TEMPORARY TABLE TWD (title VARCHAR(50), episode_number int, release_date DATETIME, rating DECIMAL(3,1), season_number int);

INSERT INTO TWD select e.title, e.number, e.release_date, e.rating, s.number from episodes e join seasons s on s.id = e.season_id
join series se on se.id = s.serie_id where se.title like 'The Walking Dead';

Select * from TWD where season_number = 1;