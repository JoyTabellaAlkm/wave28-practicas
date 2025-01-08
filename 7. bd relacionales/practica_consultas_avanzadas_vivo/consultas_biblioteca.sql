/*
1. Listar los datos de los autores.
2. Listar nombre y edad de los estudiantes
3. ¿Qué estudiantes pertenecen a la carrera informática?
4. ¿Qué autores son de nacionalidad francesa o italiana?
5. ¿Qué libros no son del área de internet?
6. Listar los libros de la editorial Salamandra.
7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
10. ¿Qué libros se prestaron al lector “Filippo Galli”?
11. Listar el nombre del estudiante de menor edad.
12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
13. Listar los libros que pertenecen a la autora J.K. Rowling.
14. Listar títulos de los libros que debían devolverse el 16/07/2021.
*/

-- 1.
SELECT * FROM autor;

-- 2.
SELECT nombre, edad FROM estudiante;

-- 3. 
SELECT * FROM estudiante WHERE carrera ="informática";

-- 4. 
SELECT * FROM autor WHERE nacionalidad IN ("francesa","italiana");

-- 5. 
SELECT * FROM libro WHERE area != "internet";

-- 6. 
SELECT * FROM libro WHERE editorial = "Salamandra";

-- 7.
SELECT * FROM estudiante WHERE edad > (SELECT AVG(edad) FROM estudiante);

-- 8.
SELECT nombre FROM estudiante WHERE apellido LIKE "G%"; 

-- 9.
SELECT autor.nombre FROM autor INNER JOIN libroautor ON autor.idAutor = libroautor.idAutor 
WHERE libroautor.idLibro IN (SELECT idLibro FROM libro WHERE titulo="El Universo: Guía de viaje"); 

-- 10.
SELECT libro.titulo FROM libro INNER JOIN prestamo ON libro.idLibro = prestamo.idLibro 
WHERE prestamo.idLector IN (SELECT idLector FROM estudiante WHERE nombre="Filippo" AND apellido="Galli"); 

-- 11.
SELECT estudiante.nombre FROM estudiante WHERE estudiante.edad =
(SELECT MIN(edad) FROM estudiante);

-- 12. 
SELECT estudiante.nombre FROM estudiante INNER JOIN prestamo ON estudiante.idLector = prestamo.idLector
WHERE prestamo.idLibro IN (SELECT idLibro FROM libro WHERE titulo LIKE "%Base de Datos%");

-- 13. 
SELECT libro.titulo, libro.editorial, libro.area FROM libro INNER JOIN libroautor ON libro.idLibro = libroautor.idLibro
WHERE libroautor.idAutor IN (SELECT idAutor FROM autor WHERE nombre="J.K. Rowling");

-- 14.
 SELECT libro.titulo FROM libro INNER JOIN prestamo ON libro.idLibro = prestamo.idLibro
 WHERE prestamo.fechaDevolucion = "2021-07-16";