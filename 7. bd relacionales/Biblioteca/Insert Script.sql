INSERT INTO autor (idAutor, Nombre, Nacionalidad) VALUES
(1, 'J.K. Rowling', 'Británica'),
(2, 'Gabriel García Márquez', 'Colombiana'),
(3, 'George R.R. Martin', 'Estadounidense'),
(4, 'Jules Verne', 'Francesa'),
(5, 'Umberto Eco', 'Italiana');

INSERT INTO libro (idLibro, Titulo, Editorial, Area) VALUES
(1, 'Harry Potter y la Piedra Filosofal', 'Salamandra', 'Fantasía'),
(2, 'Cien Años de Soledad', 'Sudamericana', 'Realismo Mágico'),
(3, 'Juego de Tronos', 'Bantam', 'Fantasía'),
(4, 'El Universo: Guía de viaje', 'Alianza', 'Ciencia'),
(5, 'Viaje al Centro de la Tierra', 'Penguin', 'Aventura'),
(6, 'El Nombre de la Rosa', 'Salamandra', 'Ficción Histórica');

INSERT INTO libroautor (idAutor, idLibro) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 6);

INSERT INTO estudiante (idLector, Nombre, Apellido, Direccion, Carrera, Edad) VALUES
(1, 'Filippo', 'Galli', 'Calle Falsa 123', 'Informática', 21),
(2, 'María', 'Gómez', 'Avenida Siempre Viva', 'Matemáticas', 22),
(3, 'Carlos', 'Rodríguez', 'Calle Luna', 'Informática', 20),
(4, 'Ana', 'Gutiérrez', 'Calle Sol', 'Filosofía', 24),
(5, 'Luis', 'Fernández', 'Calle Sol', 'Informática', 19);

INSERT INTO prestamo (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(1, 4, '2021-06-10', '2021-07-16', TRUE),
(2, 6, '2021-05-09', '2021-07-16', FALSE),
(3, 1, '2021-04-22', '2021-06-10', TRUE),
(4, 3, '2021-03-11', '2021-05-15', TRUE),
(5, 5, '2021-07-01', '2021-08-01', TRUE);