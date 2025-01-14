-- Primero
SELECT * FROM autor;
-- Segundo
SELECT nombre, edad FROM estudiante;
-- Tercero
SELECT * FROM estudiante WHERE carrera = "Informatica";
-- Cuarto
SELECT * FROM autor WHERE nacionalidad IN ("Francesa", "Italiana");
-- Quinta
SELECT * FROM libro WHERE area != "Internet";
-- Sexta
SELECT * FROM libro WHERE editorial = "Salamandra";
-- Septima
SELECT * FROM estudiante WHERE edad > (SELECT AVG(edad) FROM estudiante);
-- Octava
SELECT * FROM estudiante WHERE apellido LIKE "G%";
-- Novena
SELECT autor.nombre FROM libro INNER JOIN libroautor ON libroautor.idLibro = libro.idLibro
                               INNER JOIN autor ON libroautor.idAutor = autor.idAutor WHERE libro.titulo = "El Universo: Guía de viaje";
-- Decimo
SELECT titulo FROM libro INNER JOIN prestamo ON libro.idLibro = prestamo.idLibro
                         INNER JOIN estudiante ON prestamo.idLector = estudiante.idLector WHERE estudiante.nombre = "Filippo" AND
    estudiante.apellido = "Galli";
-- Once
SELECT nombre FROM estudiante WHERE edad = (SELECT MIN(edad) FROM estudiante)

-- Doce
SELECT estudiante.nombre FROM libro INNER JOIN prestamo ON libro.idLibro = prestamo.idLibro INNER JOIN estudiante ON prestamo.idLector = estudiante.idLector;

-- Trece
SELECT libro.nombre FROM libro INNER JOIN libroautor ON libroautor.idLibro = libro.idLibro
                               INNER JOIN autor ON libroautor.idAutor = autor.idAutor WHERE autor.nombre = "J.K. Rowling";
-- Catorce
SELECT estudiante.nombre FROM libro INNER JOIN prestamo ON libro.idLibro = prestamo.idLibro WHERE prestamo.FechaDevolucion = '16-07-2021'