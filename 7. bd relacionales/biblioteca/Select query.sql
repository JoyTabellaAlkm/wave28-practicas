SELECT * FROM autor;

SELECT nombre, edad FROM estudiante;

SELECT * FROM estudiante WHERE carrera = 'Informática';

SELECT * FROM autor WHERE nacionalidad = 'Francesa' or nacionalidad = 'Italiana';

SELECT * FROM libro WHERE area <> 'Internet';

SELECT * FROM libro WHERE editorial = 'Salamandra';

SELECT * FROM estudiante WHERE edad > (select AVG(edad) from estudiante);
SELECT nombre, apellido FROM estudiante WHERE apellido LIKE 'G%';

SELECT nombre FROM autor a
JOIN libroautor la ON la.idAutor = a.idAutor
JOIN libro l ON l.idLibro = la.idLibro
WHERE l.titulo = 'El Universo: Guía de viaje';

SELECT l.titulo FROM libro l
JOIN prestamo p ON p.idLibro = l.idLibro
JOIN estudiante e ON e.idLector = p.idLector
WHERE e.nombre = 'Filippo' and e.apellido = 'Galli';

SELECT concat(nombre, ' ', apellido) FROM estudiante
ORDER BY edad ASC limit 1;

SELECT concat(e.nombre, ' ', e.apellido) FROM estudiante e
JOIN prestamo p ON p.idLector = e.idLector
JOIN libro l ON l.idLibro = p.idLibro
WHERE l.area = 'Base de Datos';

SELECT l.* FROM libro l
JOIN libroautor la on l.idLibro = la.idLibro
JOIN autor a on a.idAutor = la.idAutor
WHERE a.nombre = 'J.K. Rowling';

SELECT l.titulo FROM libro l
JOIN prestamo p ON p.idLibro = l.idLibro
WHERE p.FechaDevolucion = '2021-07-16';
