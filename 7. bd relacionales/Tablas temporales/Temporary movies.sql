-- Agregar una película a la tabla movies.
insert into movies values (22, null, null, 'Maze Runner: Correr o Morir', 9.7, 2, '2014-09-18', 120, null);

-- Agregar un género a la tabla genres.
insert into genres values (13, '2025-01-08', null, 'Posapocalíptico', 13, 1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
update movies set genre_id = 13 where id = 22;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
update actors set favorite_movie_id = 22 where id = 4;

-- Crear una tabla temporal copia de la tabla movies.
create temporary table movies_copy as select * from movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
delete from movies_copy where awards < 5;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT DISTINCT genres.name FROM genres 
JOIN movies ON movies.genre_id = genres.id;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
select concat(a.first_name, ' ', a.last_name) from actors a
join movies m on m.id = a.favorite_movie_id
where m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
create index movies_name_idx on movies(name);

-- Chequee que el índice fue creado correctamente.
show index from movies;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
# Debido a que la BD no tiene muchos registros, no es una mejora notable hacer un indice, a demás la consulta de sus datos no es complejo.

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
# En la tabla GENRES, crearía un index en la columna rating, ya que se comporta como la PK.