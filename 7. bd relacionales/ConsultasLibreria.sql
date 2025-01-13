SELECT * FROM AUTOR;

SELECT s.nombre, s.edad FROM ESTUDIANTE s;

SELECT s.nombre FROM ESTUDIANTE s WHERE s.Carrera = 'informática';

SELECT a.nombre FROM AUTOR a WHERE a.Nacionalidad = 'italia' OR 'francia';

SELECT l.Titulo FROM LIBRO l WHERE l.Area != 'internet';

SELECT l.Titulo FROM LIBRO l WHERE l.Editorial = 'Salamandra';

SELECT * FROM ESTUDIANTE e where e.Edad >= (SELECT AVG(e.Edad) FROM ESTUDIANTE e);

SELECT e.nombre FROM ESTUDIANTE e WHERE e.Apellido LIKE 'G%';

SELECT a.nombre FROM AUTOR a 
JOIN LIBROAUTOR la ON la.idAutor = a.idAutor 
JOIN LIBRO l ON l.idLibro = la.idLibro 
WHERE l.Titulo = 'El Universo: Guía de viaje';

SELECT l.Titulo FROM LIBRO l 
JOIN PRESTAMO pr ON pr.idLibro = l.idLibro
JOIN ESTUDIANTE es ON es.idLector = pr.idLector
WHERE es.Nombre = 'Filippo' AND es.Apellido = 'Galli';

SELECT es.Nombre FROM ESTUDIANTE es ORDER BY es.edad LIMIT 1;

SELECT es.Nombre FROM ESTUDIANTE es
JOIN PRESTAMO pr ON pr.idLector = es.idLector
JOIN LIBRO l ON l.idLibro = pr.idLibro
WHERE l.Area = 'Bases de Datos';

SELECT l.Titulo FROM LIBRO l
JOIN LIBROAUTOR la ON la.idLibro = l.idLibro 
JOIN AUTOR a ON a.idAutor = la.idAutor
WHERE a.Nombre = 'J.K. Rowling';

SELECT l.Titulo FROM LIBRO l 
JOIN PRESTAMO pr ON pr.idLibro = l.idLibro
WHERE pr.FechaDevolucion = '2021-07-16';