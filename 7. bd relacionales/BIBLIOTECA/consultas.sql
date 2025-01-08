-- 1 Listar los datos de los autores.
select * from autor;

-- 2 Listar nombre y edad de los estudiantes
select nombre, edad from estudiante;

-- 3 ¿Qué estudiantes pertenecen a la carrera informática?
select * from estudiante where carrera like 'Informatica';

-- 4 ¿Qué autores son de nacionalidad francesa o italiana?
select * from autor where nacionalidad like 'Italiana' OR nacionalidad like 'Francesa';

-- 5 ¿Qué libros no son del área de internet?
select * from libro where area not like 'Internet';

-- 6 Listar los libros de la editorial Salamandra.
select * from libro where editorial like 'Salamandra';}

-- 7 Listar los datos de los estudiantes cuya edad es mayor al promedio.
select * from estudiante where edad > (select avg(edad) from estudiante);

-- 8 Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select nombre, apellido from estudiante where apellido like 'G%';

-- 9 Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select a.nombre from autor a
join libroautor la on a.idAutor = la.idAutor  
join libro li on la.idLibro = li.idLibro where li.titulo like 'El Universo: Guía de viaje';

-- 10 ¿Qué libros se prestaron al lector “Filippo Galli”?
select * from prestamo p 
inner join estudiante e on p.idLector = e.idLector where nombre like 'Filippo' and apellido like 'Galli';

-- 11 Listar el nombre del estudiante de menor edad.
select * from estudiante where edad = (select min(edad) from estudiante); 

-- 12 Listar los libros que pertenecen a la autora J.K. Rowling.
select li.* , a.nombre from libro li
join libroautor la on li.idLibro = la.idLibro 
join autor a on la.idAutor = a.idAutor where a.nombre like 'J.K. Rowling';

-- 13 Listar títulos de los libros que debían devolverse el 16/07/2021.
select li.titulo, li.idLibro from libro li 
inner join prestamo p on li.idLibro = p.idLibro where p.fechaDevolucion = '2021-07-16';
