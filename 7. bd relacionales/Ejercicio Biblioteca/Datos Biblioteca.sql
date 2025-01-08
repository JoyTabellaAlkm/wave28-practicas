-- Insertar registros en Autor
INSERT INTO Autor (nombre, nacionalidad) VALUES
('J.K. Rowling', 'Británica'),
('Dan Brown', 'Estadounidense'),
('Gabriel García Márquez', 'Colombiana'),
('Jules Verne', 'Francesa'),
('Umberto Eco', 'Italiana');

-- Insertar registros en Libro
INSERT INTO Libro (titulo, editorial, area) VALUES
('Harry Potter', 'Salamandra', 'Fantasía'),
('El Código Da Vinci', 'Planeta', 'Misterio'),
('Cien Años de Soledad', 'Sudamericana', 'Realismo Mágico'),
('Viaje al Centro de la Tierra', 'Penguin', 'Ciencia'),
('El Universo: Guía de viaje', 'Salamandra', 'Astronomía');

-- Insertar registros en LibroAutor
INSERT INTO LibroAutor (idAutor, idLibro) VALUES
(1, 1), -- J.K. Rowling - Harry Potter
(2, 2), -- Dan Brown - El Código Da Vinci
(3, 3), -- Gabriel García Márquez - Cien Años de Soledad
(4, 4), -- Jules Verne - Viaje al Centro de la Tierra
(5, 5); -- Umberto Eco - El Universo: Guía de viaje

-- Insertar registros en Estudiante
INSERT INTO Estudiante (nombre, apellido, direccion, carrera, edad) VALUES
('Ana', 'González', 'Calle Falsa 123', 'Informática', 21),
('Carlos', 'Pérez', 'Avenida Siempre Viva 456', 'Ingeniería', 23),
('Lucía', 'Martínez', 'Calle Luna 789', 'Informática', 20),
('Filippo', 'Galli', 'Via Roma 10', 'Literatura', 22),
('Gabriel', 'Gómez', 'Calle Sol 101', 'Arquitectura', 19);

-- Insertar registros en Prestamo
INSERT INTO Prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES
(1, 1, '2021-07-01', '2021-07-16', TRUE),
(2, 2, '2021-07-02', '2021-07-17', FALSE),
(3, 5, '2021-07-03', '2021-07-16', TRUE),
(4, 4, '2021-07-04', '2021-07-18', TRUE),
(5, 3, '2021-07-05', '2021-07-19', FALSE);
