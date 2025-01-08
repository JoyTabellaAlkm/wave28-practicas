-- Listar los datos de los autores.
SELECT nombre, nacionalidad
FROM autor;
-- Listar nombre y edad de los estudiantes
SELECT nombre, apellido, edad
FROM estudiante;
-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT nombre, apellido, carrera 
FROM estudiante 
WHERE carrera = 'informática';
-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT nombre, nacionalidad
FROM autor
WHERE nacionalidad = 'francés' or nacionalidad = 'italiano';
-- ¿Qué libros no son del área de internet?
SELECT titulo, area
FROM libro
where area <> 'internet';
-- Listar los libros de la editorial Salamandra.
SELECT titulo, editorial
FROM libro
WHERE editorial = 'salamandra';
-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT *
FROM estudiante
WHERE edad > (SELECT AVG(edad) FROM estudiante);
-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre, apellido
FROM estudiante
WHERE apellido LIKE 'g%';
-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre
FROM libro l
INNER JOIN libroautor la on la.idlibro = l.idlibro
INNER JOIN autor a on a.idautor = la.idautor
where l.titulo = 'El Universo: Guía de viaje';
-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT *
FROM libro l
INNER JOIN prestamo p on p.idlibro = l.idlibro
INNER JOIN estudiante e on e.idlector = p.idlector
where e.nombre = 'gonzalo' and e.apellido = 'lópez';
-- Listar el nombre del estudiante de menor edad.
SELECT nombre, apellido
FROM estudiante
WHERE edad = (Select min(edad) from estudiante);
-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre, e.apellido
FROM libro l
INNER JOIN prestamo p on p.idlibro = l.idlibro
INNER JOIN estudiante e on e.idlector = p.idlector
where l.area = 'Literatura';
-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.titulo
FROM libro l
INNER JOIN libroautor la on la.idlibro = l.idlibro
INNER JOIN autor a on a.idautor = la.idautor
where a.nombre = 'J.K. Rowling';
-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo
FROM libro l
INNER JOIN prestamo p on p.idlibro = l.idlibro
where p.fechadevolucion = '2023-07-21';
