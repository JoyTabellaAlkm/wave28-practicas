-- Crear la base de datos
CREATE DATABASE biblioteca_db;

-- Usar la base de datos
USE biblioteca_db;

-- Crear tabla AUTOR
CREATE TABLE autor (
    idAutor INT PRIMARY KEY,
    nombre VARCHAR(100),
    nacionalidad VARCHAR(100)
);

-- Crear tabla LIBRO
CREATE TABLE libro (
    idLibro INT PRIMARY KEY,
    titulo VARCHAR(200),
    editorial VARCHAR(100),
    area VARCHAR(100)
);

-- Crear tabla LIBROAUTOR
CREATE TABLE libroautor (
    idAutor INT,
    idLibro INT,
    FOREIGN KEY (idAutor) REFERENCES autor(idAutor),
    FOREIGN KEY (idLibro) REFERENCES libro(idLibro)
);

-- Crear tabla ESTUDIANTE
CREATE TABLE estudiante (
    idLector INT PRIMARY KEY,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    direccion VARCHAR(200),
    carrera VARCHAR(100),
    edad INT
);

-- Crear tabla PRESTAMO
CREATE TABLE prestamo (
	idPrestamo INT,
    idLector INT,
    idLibro INT,
    fechaPrestamo DATE,
    fechaDevolucion DATE,
    devuelto BOOLEAN,
    PRIMARY KEY (idPrestamo),
    FOREIGN KEY (idLector) REFERENCES estudiante(idLector),
    FOREIGN KEY (idLibro) REFERENCES libro(idLibro)
);

-- Insertar datos en AUTOR con datos de prueba adicionales
INSERT INTO autor (idAutor, nombre, nacionalidad) VALUES
(5, 'J.K. Rowling', 'Británica'),
(6, 'Umberto Eco', 'Italiana'),
(7, 'Albert Camus', 'Francesa'),
(8, 'Haruki Murakami', 'Japonesa'),
(9, 'Isaac Asimov', 'Rusa');

-- Insertar datos en LIBRO con datos de prueba adicionales
INSERT INTO libro (idLibro, titulo, editorial, area) VALUES
(5, 'El Universo: Guía de viaje', 'Editorial Salamandra', 'Ciencia'),
(6, 'El nombre de la rosa', 'Editorial Salamandra', 'Novela'),
(7, '1984', 'Editorial Secker & Warburg', 'Literatura'),
(8, 'El extranjero', 'Editorial Gallimard', 'Filosofía'),
(9, 'Harry Potter y la piedra filosofal', 'Editorial Salamandra', 'Fantasía'),
(10, 'Redes de Computadoras', 'Editorial Pearson', 'Internet');

-- Insertar datos en LIBROAUTOR con datos de prueba adicionales
INSERT INTO libroautor (idAutor, idLibro) VALUES
(5, 9),
(6, 6),
(7, 8),
(9,5);

-- Insertar datos en ESTUDIANTE con datos de prueba adicionales
INSERT INTO estudiante (idLector, nombre, apellido, direccion, carrera, edad) VALUES
(5, 'Filippo', 'Galli', 'Vía Roma 123', 'Informática', 20),
(6, 'María', 'González', 'Calle de la Estrella 456', 'Informática', 25),
(7, 'Lucía', 'García', 'Calle Luna 789', 'Biología', 23),
(8, 'Pedro', 'Ramírez', 'Calle Sol 101', 'Informática', 27),
(9, 'Laura', 'Gómez', 'Calle Cometa 202', 'Ingeniería', 24);

-- Insertar datos en PRESTAMO con datos de prueba adicionales
INSERT INTO prestamo (idPrestamo, idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES
(1, 5, 7, '2023-06-10', '2023-06-24', TRUE),
(2, 5, 5, '2023-07-01', '2023-07-16', TRUE),
(3, 6, 9, '2023-08-01', '2023-08-15', FALSE),
(4, 7, 6, '2023-07-15', '2023-07-29', TRUE),
(5, 8, 8, '2023-09-01', '2023-09-15', FALSE);



