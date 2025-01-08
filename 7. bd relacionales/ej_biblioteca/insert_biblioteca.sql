-- Usar la base de datos
USE biblioteca;

-- Insertar datos en la tabla autores
INSERT INTO autor (nombre, nacionalidad) VALUES
('J.K. Rowling', 'Británica'),
('Gabriel García Márquez', 'Colombiana'),
('Julio Cortázar', 'Argentino'),
('Victor Hugo', 'Francés'),
('Italo Calvino', 'Italiano'),
('George Orwell', 'Británico'),
('Milan Kundera', 'Checo');

-- Insertar datos en la tabla libros
INSERT INTO libro (titulo, editorial, area) VALUES
('Harry Potter y la piedra filosofal', 'Salamandra', 'Fantasía'),
('Cien años de soledad', 'Editorial Sudamericana', 'Literatura'),
('Rayuela', 'Random House', 'Literatura'),
('Los miserables', 'Le Livre de Poche', 'Literatura'),
('El barón rampante', 'Einaudi', 'Ficción'),
('1984', 'Secker and Warburg', 'Distopía'),
('El proceso', 'Losada', 'Ficción'),
('El amor en los tiempos del cólera', 'Random House', 'Literatura'),
('La invención de Morel', 'Emecé Editores', 'Ciencia ficción'),
('El Universo: Guía de viaje', 'Planeta', 'Astronomía');

-- Insertar datos en la tabla libroautor
INSERT INTO libroautor (idautor, idlibro) VALUES
(1, 1), -- J.K. Rowling - Harry Potter
(2, 2), -- Gabriel García Márquez - Cien años de soledad
(3, 3), -- Julio Cortázar - Rayuela
(4, 4), -- Victor Hugo - Los miserables
(5, 5), -- Italo Calvino - El barón rampante
(6, 6), -- George Orwell - 1984
(2, 8), -- Gabriel García Márquez - El amor en los tiempos del cólera
(3, 9), -- Julio Cortázar - Crónica de una muerte anunciada
(3, 10), -- Julio Cortázar - La invención de Morel
(7, 10); -- Milan Kundera - El Universo: Guía de viaje

-- Insertar datos en la tabla estudiantes
INSERT INTO estudiante (nombre, apellido, direccion, carrera, edad) VALUES
('Carlos', 'García', 'Calle Falsa 123', 'Informática', 20),
('Sofía', 'Martínez', 'Avenida Siempre Viva 742', 'Derecho', 22),
('Juan', 'Pérez', 'Calle Real 456', 'Informática', 19),
('Ana', 'González', 'Boulevard de los Sueños 789', 'Biología', 21),
('Pedro', 'Rodríguez', 'Calle Mayor 101', 'Informática', 25),
('Laura', 'Méndez', 'Calle de los Olmos 212', 'Psicología', 23),
('Gonzalo', 'López', 'Calle de la Libertad 303', 'Informática', 20),
('Marta', 'Torres', 'Avenida del Sol 404', 'Diseño', 24),
('María', 'Gutiérrez', 'Calle de la Esperanza 505', 'Informática', 20),
('Germán', 'Pascual', 'Calle de la Paz 606', 'Historia', 22),
('Filippo', 'Galli', 'Via Roma 123', 'Literatura', 21);

-- Insertar datos en la tabla préstamos
INSERT INTO prestamo (idlector, idlibro, fechaprestamo, fechadevolucion, devuelto) VALUES
(1, 1, '2023-06-01', '2023-06-15', TRUE),
(2, 2, '2023-06-05', '2023-06-20', TRUE),
(3, 3, '2023-06-10', '2023-06-25', TRUE),
(4, 4, '2023-06-15', NULL, FALSE),
(5, 5, '2023-06-20', NULL, FALSE),
(6, 6, '2023-07-01', '2023-07-15', TRUE),
(1, 8, '2023-07-10', '2023-07-20', TRUE),
(2, 9, '2023-07-15', NULL, FALSE),
(3, 10, '2023-07-18', '2023-07-21', TRUE),
(7, 10, '2023-07-20', NULL, FALSE);