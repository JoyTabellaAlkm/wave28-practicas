-- Crear la base de datos
DROP DATABASE IF EXISTS biblioteca;
CREATE DATABASE biblioteca;
USE biblioteca;

-- Crear la tabla de autores
DROP TABLE IF EXISTS autor;
CREATE TABLE autor (
    idAutor INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100),
    Nacionalidad VARCHAR(50)
);

-- Crear la tabla de libros
DROP TABLE IF EXISTS libro;
CREATE TABLE libro (
    idLibro INT AUTO_INCREMENT PRIMARY KEY,
    Titulo VARCHAR(100),
    Editorial VARCHAR(50),
    Area VARCHAR(50)
);

-- Crear la tabla de estudiantes
DROP TABLE IF EXISTS estudiante;
CREATE TABLE estudiante (
    idLector INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(50),
    Apellido VARCHAR(50),
    Direccion VARCHAR(100),
    Carrera VARCHAR(50),
    Edad INT
);

-- Crear la tabla de préstamos
DROP TABLE IF EXISTS prestamo;
CREATE TABLE prestamo (
    idLector INT,
    idLibro INT,
    FechaPrestamo DATE,
    FechaDevolucion DATE,
    Devuelto BOOLEAN,
    PRIMARY KEY (idLector, idLibro, FechaPrestamo),
    FOREIGN KEY (idLector) REFERENCES estudiante(idLector),
    FOREIGN KEY (idLibro) REFERENCES libro(idLibro)
);

-- Crear la tabla de relación entre libros y autores
DROP TABLE IF EXISTS libroautor;
CREATE TABLE libroautor (
    idAutor INT,
    idLibro INT,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES autor(idAutor),
    FOREIGN KEY (idLibro) REFERENCES libro(idLibro)
);

-- Insertar datos ficticios en la tabla de autores
INSERT INTO autor (Nombre, Nacionalidad)
VALUES
    ('J.K. Rowling', 'Británica'),
    ('Gabriel García Márquez', 'Colombiana'),
    ('Jules Verne', 'Francesa'),
    ('Italo Calvino', 'Italiana'),
    ('Stephen King', 'Estadounidense');

-- Insertar datos ficticios en la tabla de libros
INSERT INTO libro (Titulo, Editorial, Area)
VALUES
    ('Harry Potter y la Piedra Filosofal', 'Salamandra', 'Fantasía'),
    ('Cien Años de Soledad', 'Sudamericana', 'Realismo Mágico'),
    ('Viaje al Centro de la Tierra', 'Hachette', 'Aventura'),
    ('Las Ciudades Invisibles', 'Einaudi', 'Filosofía'),
    ('El Resplandor', 'Viking', 'Terror'),
    ('El Universo: Guía de viaje', 'Salamandra', 'Astronomía'),
    ('Base de Datos para Principiantes', 'O’Reilly', 'Internet');

-- Insertar datos ficticios en la tabla de estudiantes
INSERT INTO estudiante (Nombre, Apellido, Direccion, Carrera, Edad)
VALUES
    ('Filippo', 'Galli', 'Via Roma 12, Milán', 'Informática', 22),
    ('Ana', 'González', 'Calle Falsa 123, Madrid', 'Literatura', 20),
    ('Luis', 'Pérez', 'Avenida Siempreviva 742, Bogotá', 'Informática', 24),
    ('Marie', 'Dubois', 'Rue de Rivoli 56, París', 'Física', 23),
    ('John', 'Smith', '221B Baker Street, Londres', 'Historia', 21);

-- Insertar datos ficticios en la tabla de relación libroautor
INSERT INTO libroautor (idAutor, idLibro)
VALUES
    (1, 1), -- J.K. Rowling -> Harry Potter
    (2, 2), -- Gabriel García Márquez -> Cien Años de Soledad
    (3, 3), -- Jules Verne -> Viaje al Centro de la Tierra
    (4, 4), -- Italo Calvino -> Las Ciudades Invisibles
    (5, 5), -- Stephen King -> El Resplandor
    (3, 6); -- Jules Verne -> El Universo: Guía de viaje

-- Insertar datos ficticios en la tabla de préstamos
INSERT INTO prestamo (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto)
VALUES
    (1, 1, '2021-07-01', '2021-07-16', TRUE), -- Filippo -> Harry Potter
    (1, 7, '2021-07-10', '2021-07-16', TRUE), -- Filippo -> Base de Datos
    (2, 2, '2021-07-05', '2021-07-15', TRUE), -- Ana -> Cien Años de Soledad
    (3, 7, '2021-07-12', '2021-07-20', FALSE), -- Luis -> Base de Datos
    (4, 4, '2021-07-08', '2021-07-16', TRUE); -- Marie -> Las Ciudades Invisibles
