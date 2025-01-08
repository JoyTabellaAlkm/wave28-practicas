SELECT * FROM movies;
SELECT first_name, last_name, rating from actors;
SELECT title as titulo from series;
SELECT first_name, last_name from actors where rating > 7.5;
select title, rating, awards from movies where rating > 7.5 and awards > 2;
select title, rating from movies order by rating;
select title from movies limit 3;
select * from movies order by rating desc limit 5;
select * from actors limit 10;
select title, rating from movies where title like "Toy Story%";
select * from actors where first_name like "Sam%";
select title, release_date from movies where YEAR(release_date) between 2004 AND 2008;
select title from movies where rating > 3 and awards > 1 and year(release_date) between 1988 and 2009 order by rating;

select count(*), movies.title, movies.rating, movies.awards 
from movies inner join actors 
on movies.id = actors.favorite_movie_id 
group by title;
