ALTER TABLE `movies_db`.`seasons` 
ADD INDEX `season_number_index` (`number` ASC) VISIBLE;
;

explain SELECT *
FROM series s 
inner join seasons sea on s.id = sea.serie_id
where sea.number = 1;
