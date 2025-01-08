

INSERT INTO libro  VALUES
(1, 'Cien Años de Soledad', 'Sudamericana', 'Literatura'),
(2, 'El Principito', 'Reynal & Hitchcock', 'Fábula'),
(3, '1984', 'Secker & Warburg', 'Ficción'),
(4, 'La Odisea', 'Penguin Classics', 'Épico'),
(5, 'Don Quijote de la Mancha', 'Francisco de Robles', 'Novela');

INSERT INTO autor VALUES
(1, 'Gabriel García Márquez', 'Colombiana'),
(2, 'Antoine de Saint-Exupéry', 'Francesa'),
(3, 'George Orwell', 'Británica'),
(4, 'Homero', 'Griega'),
(5, 'Miguel de Cervantes', 'Española');


INSERT INTO libroautor VALUES
(1, 1),  -- García Márquez - Cien Años de Soledad
(2, 2),  -- Saint-Exupéry - El Principito
(3, 3),  -- Orwell - 1984
(4, 4),  -- Homero - La Odisea
(5, 5);  -- Cervantes - Don Quijote de la Mancha

INSERT INTO estudiante  VALUES
(1, 'Lucía', 'Pérez', 'Av. Siempre Viva 123', 'Ingeniería', 22),
(2, 'Martín', 'Gómez', 'Calle Falsa 456', 'Derecho', 24),
(3, 'Carla', 'López', 'Ruta 9 Km 50', 'Arquitectura', 21),
(4, 'Julián', 'Sosa', 'Av. Córdoba 789', 'Medicina', 23),
(5, 'Ana', 'Díaz', 'Calle Real 101', 'Psicología', 25);
(6, 'Pili', 'Inocenti', 'Calle Real 101', 'Psicología', 25);

INSERT INTO prestamo VALUES
(1, 1, '2025-01-01', '2025-01-15', 1), -- Lucía - Cien Años de Soledad
(2, 2, '2025-01-05', '2025-01-20', 0), -- Martín - El Principito
(3, 3, '2025-01-10', '2025-01-25', 1), -- Carla - 1984
(4, 4, '2025-01-12', '2025-01-30', 0), -- Julián - La Odisea
(5, 5, '2025-01-15', '2025-01-28', 1); -- Ana - Don Quijote de la Mancha


SELECT * FROM Autor;

SELECT nombre, edad FROM Estudiante;

SELECT * FROM Estudiante WHERE carrera = "informática";

SELECT * FROM Autor WHERE nacionalidad = "francesa" OR nacionalidad = "italiana";

SELECT * FROM Libro WHERE area != "internet";

SELECT * FROM Libro WHERE editorial = "salamandra";

SELECT * FROM Estudiante WHERE edad > (SELECT avg(edad) FROM Estudiante);

SELECT nombre FROM Estudiante WHERE apellido LIKE "G%";

SELECT a.* FROM LibroAutor la 
JOIN Autor a ON la.idAutor = a.idAutor
JOIN Libro l ON la.idLibro = l.idLibro
WHERE l.titulo = "El Universo: Guía de viaje";

SELECT l.* FROM Prestamo p
JOIN Estudiante e ON e.idLector = p.idLector
JOIN Libro l ON l.idLibro = p.idLibro
WHERE e.nombre = "Filippo" AND e.apellido = "Galli";

SELECT nombre FROM Estudiante WHERE edad = (SELECT MIN(edad) FROM Estudiante);

SELECT Estudiante.nombre, Estudiante.apellido FROM Prestamo p
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

