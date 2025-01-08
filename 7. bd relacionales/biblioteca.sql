-- Eliminar la base de datos si existe y crearla.
DROP DATABASE IF EXISTS biblioteca_db;
CREATE DATABASE biblioteca_db;
USE biblioteca_db;

-- Crear las tablas.
CREATE TABLE Autor (
    idautor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(55),
    nacionalidad VARCHAR(55)
);

CREATE TABLE Libro (
    idlibro INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200),
    editorial VARCHAR(100),
    area VARCHAR(50)
);

CREATE TABLE libroAutor (
    idautor INT,
    idlibro INT,
    FOREIGN KEY (idautor) REFERENCES Autor(idautor),
    FOREIGN KEY (idlibro) REFERENCES Libro(idlibro)
);

CREATE TABLE Estudiante (
    idlector INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    direccion VARCHAR(200),
    carrera VARCHAR(100),
    edad INT
);

CREATE TABLE Prestamo (
    idlector INT,
    idlibro INT,
    fechaPrestamo DATE,
    fechaDevolucion DATE,
    devuelto BOOLEAN,
    FOREIGN KEY (idlector) REFERENCES Estudiante(idlector),
    FOREIGN KEY (idlibro) REFERENCES Libro(idlibro)
);

-- Insertar Datos
INSERT INTO Autor (nombre, nacionalidad) VALUES
('J.K. Rowling', 'Británica'),
('Gabriel García Márquez', 'Colombiana'),
('Franz Kafka', 'Checa'),
('George Orwell', 'Británica'),
('Jane Austen', 'Británica'),
('Italo Calvino', 'Italiana'),
('Victor Hugo', 'Francesa');

INSERT INTO Libro (titulo, editorial, area) VALUES
('Harry Potter y la piedra filosofal', 'Salamandra', 'Ficción'),
('Harry Potter y la cámara secreta', 'Salamandra', 'Ficción'),
('Harry Potter y el prisionero de Azkaban', 'Salamandra', 'Ficción'),
('Fundamentos de Bases de Datos', 'McGraw-Hill', 'Base de Datos'),
('Cien años de soledad', 'HarperCollins', 'Literatura'),
('El proceso', 'Anagrama', 'Ficción'),
('1984', 'Debolsillo', 'Ficción'),
('Orgullo y prejuicio', 'Panamericana', 'Ficción'),
('El Universo: Guía de viaje', 'Planeta', 'Ciencia');

INSERT INTO libroAutor (idautor, idlibro) VALUES
((SELECT idautor FROM Autor WHERE nombre = 'J.K. Rowling'), (SELECT idlibro FROM Libro WHERE titulo = 'Harry Potter y la piedra filosofal')),
((SELECT idautor FROM Autor WHERE nombre = 'J.K. Rowling'), (SELECT idlibro FROM Libro WHERE titulo = 'Harry Potter y la cámara secreta')),
((SELECT idautor FROM Autor WHERE nombre = 'J.K. Rowling'), (SELECT idlibro FROM Libro WHERE titulo = 'Harry Potter y el prisionero de Azkaban')),
((SELECT idautor FROM Autor WHERE nombre = 'Gabriel García Márquez'), (SELECT idlibro FROM Libro WHERE titulo = 'Cien años de soledad')),
((SELECT idautor FROM Autor WHERE nombre = 'Franz Kafka'), (SELECT idlibro FROM Libro WHERE titulo = 'El proceso')),
((SELECT idautor FROM Autor WHERE nombre = 'George Orwell'), (SELECT idlibro FROM Libro WHERE titulo = '1984')),
((SELECT idautor FROM Autor WHERE nombre = 'Jane Austen'), (SELECT idlibro FROM Libro WHERE titulo = 'Orgullo y prejuicio')),
((SELECT idautor FROM Autor WHERE nombre = 'Italo Calvino'), (SELECT idlibro FROM Libro WHERE titulo = 'El Universo: Guía de viaje'));

INSERT INTO Estudiante (nombre, apellido, direccion, carrera, edad) VALUES
('Filippo', 'Galli', '123 Calle Falsa', 'Informática', 20),
('Ana', 'Mendoza', '456 Avenida Siempre Viva', 'Derecho', 22),
('Luis', 'Zapata', '789 Plaza de La Libertad', 'Informática', 19),
('María', 'González', '321 Calle Esperanza', 'Literatura', 21),
('Carlos', 'Sánchez', '654 Bulevar de Los Sueños', 'Ingeniería', 23);


INSERT INTO Prestamo (idlector, idlibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES
(1, 1, '2021-07-01', '2021-07-16', TRUE),
(2, 2, '2021-07-05', '2021-07-19', TRUE),
(3, 3, '2021-06-20', '2021-07-20', FALSE),
(4, 4, '2021-06-25', '2021-08-01', FALSE),
(5, 5, '2021-07-10', '2021-07-25', TRUE);
