-- 1. Listar los datos de los autores.
SELECT * FROM Autor;

-- 2. Listar nombre y edad de los estudiantes.
SELECT nombre, edad FROM Estudiante;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM Estudiante WHERE carrera = 'Informática';

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM Autor WHERE nacionalidad IN ('Francesa', 'Italiana');

-- 5. ¿Qué libros no son del área de internet?
SELECT * FROM Libro WHERE area != 'Internet';

-- 6. Listar los libros de la editorial Salamandra.
SELECT * FROM Libro WHERE editorial = 'Salamandra';

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM Estudiante WHERE edad > (SELECT AVG(edad) FROM Estudiante);

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre FROM Estudiante WHERE apellido LIKE 'G%';

-- 9. Listar los autores del libro “El Universo: Guía de viaje” (solo nombres).
SELECT a.nombre
FROM Autor a
JOIN libroAutor la ON a.idautor = la.idautor
JOIN Libro l ON la.idlibro = l.idlibro
WHERE l.titulo = 'El Universo: Guía de viaje';

-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.*
FROM Libro l
JOIN Prestamo p ON l.idlibro = p.idlibro
JOIN Estudiante e ON p.Idlector = e.idlector
WHERE e.nombre = 'Filippo' AND e.apellido = 'Galli';

-- 11. Listar el nombre del estudiante de menor edad.
SELECT nombre
FROM Estudiante
WHERE edad = (SELECT MIN(edad) FROM Estudiante);

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre
FROM Estudiante e
JOIN Prestamo p ON e.idlector = p.Idlector
JOIN Libro l ON p.idlibro = l.idlibro
WHERE l.titulo LIKE '%Bases de Datos%';

-- 13. Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.*
FROM Libro l
JOIN libroAutor la ON l.idlibro = la.idlibro
JOIN Autor a ON la.idautor = a.idautor
WHERE a.nombre = 'J.K. Rowling';

-- 14. Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo
FROM Libro l
JOIN Prestamo p ON l.idlibro = p.idlibro
WHERE p.fechaDevolucion = '2021-07-16';