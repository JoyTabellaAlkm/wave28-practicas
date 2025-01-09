create temporary table TWD (episode_name VARCHAR(30), season VARCHAR(30));

insert into TWD select e.title, s.title from episodes e
join seasons s on e.season_id = s.id
join series sr on s.serie_id = sr.id
where sr.title = 'The Walking Dead';

select * from TWD where season = 'Primer Temporada';