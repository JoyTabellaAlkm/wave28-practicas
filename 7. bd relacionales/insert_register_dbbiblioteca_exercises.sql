-- Insertar registros en la tabla autor
INSERT INTO autor (nombre, nacionalidad) VALUES
('Gabriel García Márquez', 'Colombiana'),
('Julio Cortázar', 'Argentina'),
('Mario Vargas Llosa', 'Peruana'),
('Isabel Allende', 'Chilena'),
('Jorge Luis Borges', 'Argentina');

-- Insertar registros en la tabla libro
INSERT INTO libro (titulo, editorial, area) VALUES
('Cien años de soledad', 'Editorial Sudamericana', 'Literatura'),
('Rayuela', 'Editorial Alfredo Bryce', 'Literatura'),
('La ciudad y los perros', 'Editorial Seix Barral', 'Literatura'),
('La casa de los espíritus', 'Editorial Plaza & Janés', 'Literatura'),
('Ficciones', 'Editorial Sur', 'Literatura');

-- Insertar registros en la tabla libroautor
INSERT INTO libroautor (idautor, idlibro) VALUES
(1, 1),  -- "Cien años de soledad" - Gabriel García Márquez
(2, 2),  -- "Rayuela" - Julio Cortázar
(3, 3),  -- "La ciudad y los perros" - Mario Vargas Llosa
(4, 4),  -- "La casa de los espíritus" - Isabel Allende
(5, 5),  -- "Ficciones" - Jorge Luis Borges
(1, 5),  -- "Ficciones" - Gabriel García Márquez
(2, 1);  -- "Cien años de soledad" - Julio Cortázar

-- Insertar registros en la tabla estudiante
INSERT INTO estudiante (nombre, apellido, direccion, carrera, edad) VALUES
('Juan', 'Pérez', 'Calle 123', 'Literatura', 20),
('Ana', 'Gómez', 'Avenida 456', 'Historia', 22),
('Luis', 'Martínez', 'Calle 789', 'Filosofía', 19),
('Marta', 'López', 'Calle 321', 'Ciencias Sociales', 21),
('Carlos', 'Torres', 'Avenida 654', 'Sociología', 23);

-- Insertar registros en la tabla prestamo
INSERT INTO prestamo (idlector, idlibro, fechaprestamo, fechadevolucion, devuelto) VALUES
(1, 1, '2023-10-01', '2023-10-15', TRUE),
(1, 2, '2023-10-02', NULL, FALSE),
(2, 3, '2023-10-03', '2023-10-17', TRUE),
(3, 4, '2023-10-04', NULL, FALSE),
(4, 5, '2023-10-05', '2023-10-20', TRUE);









