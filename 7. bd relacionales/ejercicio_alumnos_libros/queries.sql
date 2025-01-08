-- Listar los datos de los autores.
SELECT * 
FROM autor;
-- Listar nombre y edad de los estudiantes
SELECT nombre, edad 
FROM estudiante;
-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * 
FROM estudiante 
WHERE carrera = "informática"; -- ninguno
-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * 
FROM autor 
WHERE nacionalidad IN ("Francia", "Italia");
-- ¿Qué libros no son del área de internet?
SELECT * 
FROM libro 
WHERE LOWER(area) != "internet";
-- Listar los libros de la editorial Salamandra.
SELECT * 
FROM libro 
WHERE editorial LIKE "%Salamandra";
-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * 
FROM estudiante 
WHERE edad > (
	SELECT AVG(edad) FROM estudiante
);
-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT *
FROM estudiante
WHERE UPPER(apellido) LIKE "G%";
-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
-- Opción 1
SELECT a.*
FROM autor a
JOIN libro_autor la
ON a.id_autor = la.id_autor
JOIN libro l
ON la.id_libro = l.id_libro
WHERE l.titulo = "El Universo: Guía de viaje";
-- Opción 2
SELECT a.*
FROM autor a
JOIN libro_autor la
ON a.id_autor = la.id_autor
JOIN libro l
ON la.id_libro = l.id_libro
WHERE l.titulo = "1984";
-- ¿Qué libros se prestaron al lector “Filippo Galli”?
-- Opción 1
SELECT l.titulo
FROM libro l
JOIN prestamo p
ON l.id_libro = p.id_libro
JOIN estudiante e
ON p.id_estudiante = e.id_estudiante
WHERE e.nombre = "Filippo" AND e.apellido = "Galli";
-- Opción 2
SELECT l.titulo
FROM libro l
JOIN prestamo p
ON l.id_libro = p.id_libro
JOIN estudiante e
ON p.id_estudiante = e.id_estudiante
WHERE e.nombre = "Pepe" AND e.apellido = "Argento";
-- Listar el nombre del estudiante de menor edad.
SELECT nombre, edad
FROM estudiante
WHERE edad = (SELECT MIN(edad) FROM estudiante);
-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
-- Opción 1
SELECT DISTINCT e.nombre, e.apellido
FROM libro l
JOIN prestamo p
ON l.id_libro = p.id_libro
JOIN estudiante e
ON p.id_estudiante = e.id_estudiante
WHERE l.area = "Base de Datos";
-- Opción 2
SELECT DISTINCT e.nombre, e.apellido
FROM libro l
JOIN prestamo p
ON l.id_libro = p.id_libro
JOIN estudiante e
ON p.id_estudiante = e.id_estudiante
WHERE l.area = "Ficción";
-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.*
FROM libro l
JOIN libro_autor la
ON l.id_libro = la.id_libro
JOIN autor a
ON la.id_autor = a.id_autor
WHERE a.nombre = "J.K. Rowling";
-- Listar títulos de los libros que debían devolverse el 16/07/2025.
SELECT l.titulo, p.fec_devolucion, DATEDIFF(CURDATE(),p.fec_devolucion) AS dias_restantes
FROM libro l
JOIN prestamo p ON l.id_libro = p.id_libro
WHERE p.fec_devolucion <= '2025-07-16';
