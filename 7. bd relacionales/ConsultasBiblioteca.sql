-- Listar los datos de los autores.
select * from autor;

-- Listar nombre y edad de los estudiantes
select nombre, edad from estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
select * from estudiante where carrera = 'Informática';

-- ¿Qué autores son de nacionalidad francesa o italiana?
select * from autor where nacionalidad = 'Francesa' or nacionalidad = 'Italiana';

-- ¿Qué libros no son del área de internet?
select * from libro where area != 'Internet';

-- Listar los libros de la editorial Salamandra.
select * from libro where editorial = 'Editorial Salamandra';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
select * from estudiante where edad > (select avg(edad) from estudiante);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select * from estudiante where apellido like 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select autor.* from autor inner join libroautor on autor.idAutor = libroautor.idAutor
inner join libro on libro.idLibro = libroautor.idLibro
where libro.titulo = 'El Universo: Guía de viaje';

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
select libro.* from libro inner join prestamo on libro.idLibro = prestamo.idLibro
inner join estudiante on estudiante.idLector = prestamo.idLector where estudiante.nombre = 'Filippo' and apellido = 'Galli';

-- Listar el nombre del estudiante de menor edad.
select * from estudiante where edad = (select min(edad) from estudiante);

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
select distinct estudiante.nombre, estudiante.apellido from prestamo inner join estudiante on estudiante.idLector = prestamo.idLector;

-- Listar los libros que pertenecen a la autora J.K. Rowling.
select * from libro inner join libroautor on libro.idLibro = libroautor.idLibro
inner join autor on autor.idAutor = libroautor.idAutor where autor.nombre = 'J.K. Rowling';

-- Listar títulos de los libros que debían devolverse el 16/07/2023.
select * from libro inner join prestamo on libro.idLibro = prestamo.idLibro
where fechaDevolucion = '2023-07-16'
