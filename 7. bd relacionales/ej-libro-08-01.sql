SELECT * FROM autor;

SELECT nombre,apellido, edad FROM estudiante;

SELECT nombre, carrera FROM estudiante WHERE carrera = "Informatica";

SELECT nombre, nacionalidad FROM autor WHERE nacionalidad = "Francesa" OR nacionalidad = "Italiana";

SELECT * FROM libro WHERE area != "Internet";

SELECT * FROM libro WHERE editorial = "Salamandra";

SELECT * FROM estudiante WHERE edad > (SELECT AVG(edad) FROM estudiante);

SELECT nombre, apellido FROM estudiante where apellido LIKE "G%";

SELECT a.nombre FROM autor a 
	JOIN LibroAutor la
    ON a.idAutor = la.idAutor
    JOIN Libro l 
    ON l.idLibro = la.idLibro
	WHERE l.titulo = "El Universo: Guía de viaje";
 
SELECT l.titulo FROM Libro l
	 JOIN Prestamo p
	 ON p.idLibro = l.idLibro
	 JOIN Estudiante e
	 ON e.idLector = p.idLector
	 WHERE e.Nombre = "Filippo" AND e.apellido = "Galli";
 
	
SELECT nombre FROM estudiante WHERE	edad = (SELECT min(edad) FROM estudiante);

SELECT e.nombre FROM Libro l
	 JOIN Prestamo p
	 ON p.idLibro = l.idLibro
	 JOIN Estudiante e
	 ON e.idLector = p.idLector
	 WHERE l.Area = "Base de datos";
	
 
SELECT l.titulo FROM libro l 
	JOIN LibroAutor la
    ON la.idLibro = l.idLibro
	JOIN autor a
    ON a.idAutor = la.idAutor
	WHERE a.Nombre = 'J.K. Rowling';
    
SELECT l.titulo FROM libro l
	JOIN prestamo p
    ON l.idLibro = p.idLibro
	WHERE p.fechaDevolucion = '2021-07-16';