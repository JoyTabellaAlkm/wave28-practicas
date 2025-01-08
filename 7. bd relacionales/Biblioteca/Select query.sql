-- Listar los datos de los autores.
select * from autor;

-- Listar nombre y edad de los estudiantes
select nombre, edad from estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
select * from estudiante where carrera = 'Informática';

-- ¿Qué autores son de nacionalidad francesa o italiana?
select * from autor where nacionalidad = 'Francesa' or nacionalidad = 'Italiana';

-- ¿Qué libros no son del área de internet?
select * from libro where area <> 'Internet';

-- Listar los libros de la editorial Salamandra.
select * from libro where editorial = 'Salamandra';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
select * from estudiante where edad > (select AVG(edad) from estudiante);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select nombre, apellido from estudiante where apellido like 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select nombre from autor a
join libroautor la on la.idAutor = a.idAutor
join libro l on l.idLibro = la.idLibro
where l.titulo = 'El Universo: Guía de viaje';

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
select l.titulo from libro l
join prestamo p on p.idLibro = l.idLibro
join estudiante e on e.idLector = p.idLector
where e.nombre = 'Filippo' and e.apellido = 'Galli';

-- Listar el nombre del estudiante de menor edad.
select concat(nombre, ' ', apellido) from estudiante
order by edad asc limit 1;

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
select concat(e.nombre, ' ', e.apellido) from estudiante e
join prestamo p on p.idLector = e.idLector
join libro l on l.idLibro = p.idLibro
where l.area = 'Base de Datos';

-- Listar los libros que pertenecen a la autora J.K. Rowling.
select l.* from libro l
join libroautor la on l.idLibro = la.idLibro
join autor a on a.idAutor = la.idAutor
where a.nombre = 'J.K. Rowling';

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
select l.titulo from libro l
join prestamo p on p.idLibro = l.idLibro
where p.FechaDevolucion = '2021-07-16';