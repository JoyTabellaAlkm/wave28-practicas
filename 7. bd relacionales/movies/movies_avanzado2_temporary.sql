-- 1. Agregar una película a la tabla *movies*.

    SET SQL_SAFE_UPDATES = 0;
    delete from movies where id=22;
    INSERT INTO movies(id,title,rating,awards,release_date) values(22,'Los simpsons',8,0,'2010-10-04');

-- 2. Agregar un género a la tabla *genres*.

    delete from genres where id=13;
    INSERT INTO genres(id,name,ranking,active) values(13,'Animación',13,1);

-- 3. Asociar a la película del punto 1. genre el género creado en el punto 2.

    UPDATE movies set genre_id=13 where id=22;

-- 4. Crear una ***tabla temporal*** copia de la tabla *movies*.

    drop table if exists movies_awards;
    CREATE TEMPORARY TABLE movies_awards as
    select * from movies;

-- 5. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.

    delete from movies_awards where awards<=5;
    select * from movies_awards;

-- 6. Obtener la lista de todos los géneros que tengan al menos una película.

    select * from genres
    where id in (select genre_id from movies)

-- 7. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.

    select * from actors
    where favorite_movie_id in
    (select id from movies where awards>3)

-- 8. Crear un índice sobre el nombre en la tabla movies.

    create index title_index
    on movies(title);

-- 9. Chequee que el índice fue creado correctamente.
	show index from movies
