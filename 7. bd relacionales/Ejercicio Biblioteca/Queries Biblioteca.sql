SELECT * FROM Autor;

SELECT nombre, edad FROM Estudiante;

SELECT * FROM Estudiante WHERE carrera = "informática";

SELECT * FROM Autor WHERE nacionalidad = "francesa" OR nacionalidad = "italiana";

SELECT * FROM Libro WHERE area != "internet";

SELECT * FROM Libro WHERE editorial = "salamandra";

SELECT * FROM Estudiante WHERE edad > (SELECT avg(edad) FROM Estudiante);

SELECT nombre, apellido FROM Estudiante WHERE apellido LIKE "G%";

SELECT a.* FROM LibroAutor la
JOIN Autor a ON la.idAutor = a.idAutor
JOIN Libro l ON la.idLibro = l.idLibro
WHERE l.titulo = "El Universo: Guía de viaje";

SELECT l.* FROM Prestamo p
JOIN Estudiante e ON e.idLector = p.idLector
JOIN Libro l ON l.idLibro = p.idLibro
WHERE e.nombre = "Filippo" AND e.apellido = "Galli";

SELECT nombre, apellido FROM Estudiante WHERE edad = (SELECT MIN(edad) FROM Estudiante);

SELECT e.nombre, e.apellido FROM Prestamo p
JOIN Estudiante e ON e.idLector = p.idLector
JOIN Libro l ON l.idLibro = p.idLibro
WHERE l.area = "Base de Datos";

SELECT l.* FROM LibroAutor la
JOIN Autor a ON la.idAutor = a.idAutor
JOIN Libro l ON la.idLibro = l.idLibro
WHERE a.nombre = "J.K. Rowling";

SELECT l.* FROM Libro l
JOIN Prestamo p ON l.idLibro = p.idLibro
WHERE p.fechaDevolucion = "2021-07-16";
