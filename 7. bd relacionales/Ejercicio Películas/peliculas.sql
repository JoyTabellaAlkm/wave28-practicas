select *
from movies;

select first_name, last_name, rating 
from actors;

select title as titulo
from series;

select first_name, last_name, rating
from actors
where rating > 7.5;

select title, rating, awards 
from movies 
where rating > 7.5 and awards > 2;

select title, rating
from movies
order by rating;

select title
from movies
limit 3;

select title, rating
from movies
order by rating desc
limit 5;

select first_name, last_name
from actors
limit 10;

select title, rating
from movies
where title = "Toy Story";

select first_name, last_name
from actors
where first_name like "Sam%";

select title
from movies
where release_date >= "2004-01-01" and release_date <= "2008-12-31";

select title
from movies
where rating > 3 
and awards > 1
and release_date >= "1988-01-01"
and release_date <= "2009-12-31"
order by rating;
