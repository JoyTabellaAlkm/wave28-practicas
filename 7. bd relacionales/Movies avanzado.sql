select series.title, genres.name from series inner join genres on series.genre_id = genres.id;

select episodes.title, actors.first_name, actors.last_name from actor_episode
inner join actors on actor_episode.actor_id = actors.id
inner join episodes on actor_episode.episode_id = episodes.id;

select series.title, count(*) from series
inner join seasons on series.id = seasons.serie_id
group by series.title;

select genres.name, count(*) from genres
inner join movies on genres.id = movies.genre_id
group by genres.name having count(*) >= 3;

select actors.first_name, actors.last_name from actors
inner join actor_movie on actors.id = actor_movie.actor_id
inner join movies on movies.id = actor_movie.movie_id
where movies.title like "La Guerra de las galaxias%"
group by actors.first_name, actors.last_name;
