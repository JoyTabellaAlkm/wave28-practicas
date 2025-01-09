-- Listar los datos de los autores.
SELECT * FROM autor;

-- Listar nombre y edad de los estudiantes
SELECT nombre, edad FROM estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT nombre FROM estudiante WHERE carrera = 'Informática';

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT nombre, nacionalidad FROM autor WHERE nacionalidad = 'Francesa' OR nacionalidad = 'Italiana';

-- ¿Qué libros no son del área de internet?
SELECT titulo FROM libro WHERE area != 'Internet';

-- Listar los libros de la editorial Salamandra.
SELECT titulo FROM libro WHERE editorial = 'Editorial Salamandra';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT nombre, edad FROM estudiante WHERE edad > (SELECT AVG(edad) FROM estudiante);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre, apellido FROM estudiante WHERE apellido LIKE 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT libro.titulo, autor.nombre FROM Autor
INNER JOIN libroautor ON autor.idAutor = libroautor.idAutor
INNER JOIN libro ON libroautor.idLibro = libro.idLibro
WHERE libro.titulo = 'El Universo: Guía de viaje';

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT libro.titulo, estudiante.nombre FROM Libro
INNER JOIN prestamo ON libro.idLibro = prestamo.idLibro
INNER JOIN estudiante ON prestamo.idLector = estudiante.idLector
WHERE estudiante.nombre = 'Filippo' AND estudiante.apellido = 'Galli';

-- Listar el nombre del estudiante de menor edad.
SELECT nombre, edad FROM estudiante WHERE (SELECT MIN(edad) FROM estudiante) LIMIT 1;