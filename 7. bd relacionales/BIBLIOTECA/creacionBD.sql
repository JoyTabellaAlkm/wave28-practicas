-- Crear la base de datos
CREATE DATABASE biblioteca;
USE biblioteca;

-- Crear la tabla LIBRO
CREATE TABLE libro (
    idLibro INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    editorial VARCHAR(50) NOT NULL,
    area VARCHAR(50) NOT NULL
);

-- Crear la tabla AUTOR
CREATE TABLE autor (
    idAutor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    nacionalidad VARCHAR(50) NOT NULL
);

-- Crear la tabla LIBROAUTOR (relación muchos a muchos entre LIBRO y AUTOR)
CREATE TABLE libroautor (
    idAutor INT NOT NULL,
    idLibro INT NOT NULL,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES autor(idAutor),
    FOREIGN KEY (idLibro) REFERENCES libro(idLibro)
);

-- Crear la tabla ESTUDIANTE
CREATE TABLE estudiante (
    idLector INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    carrera VARCHAR(50) NOT NULL,
    edad INT NOT NULL
);

-- Crear la tabla PRESTAMO
CREATE TABLE prestamo (
    idPrestamo INT AUTO_INCREMENT PRIMARY KEY,
    idLector INT NOT NULL,
    idLibro INT NOT NULL,
    fechaPrestamo DATE NOT NULL,
    fechaDevolucion DATE,
    devuelto BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (idLector) REFERENCES estudiante(idLector),
    FOREIGN KEY (idLibro) REFERENCES libro(idLibro)
);
INSERT INTO autor (nombre, nacionalidad) VALUES
('J.K. Rowling', 'Británica'),
('Dan Brown', 'Estadounidense'),
('Antoine de Saint-Exupéry', 'Francesa'),
('Umberto Eco', 'Italiana'),
('Gabriel García Márquez', 'Colombiana');
INSERT INTO libro (titulo, editorial, area) VALUES
('Harry Potter y la piedra filosofal', 'Salamandra', 'Fantasía'),
('El Código Da Vinci', 'Random House', 'Misterio'),
('El Principito', 'Gallimard', 'Fantasía'),
('El Nombre de la Rosa', 'Bompiani', 'Historia'),
('Cien años de soledad', 'Sudamericana', 'Literatura'),
('El Universo: Guía de viaje', 'AstroPress', 'Ciencia'),
('Introducción a Base de Datos', 'McGraw-Hill', 'Base de Datos'),
('Internet para principiantes', 'Salamandra', 'Internet');
INSERT INTO libroautor (idAutor, idLibro) VALUES
(1, 1), -- J.K. Rowling -> Harry Potter
(2, 2), -- Dan Brown -> El Código Da Vinci
(3, 3), -- Antoine -> El Principito
(4, 4), -- Umberto Eco -> El Nombre de la Rosa
(5, 5), -- García Márquez -> Cien años de soledad
(3, 6), -- Antoine -> El Universo: Guía de viaje
(1, 7), -- J.K. Rowling -> Introducción a Base de Datos
(1, 8); -- J.K. Rowling -> Internet para principiantes
INSERT INTO estudiante (nombre, apellido, direccion, carrera, edad) VALUES
('Juan', 'García', 'Calle Falsa 123', 'Informática', 21),
('Ana', 'González', 'Av. Siempre Viva 456', 'Matemática', 22),
('Filippo', 'Galli', 'Via Roma 32', 'Informática', 23),
('María', 'López', 'Plaza Mayor 7', 'Informática', 20),
('Laura', 'Gómez', 'Calle Luna 8', 'Literatura', 24);
INSERT INTO prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES
(1, 1, '2021-07-10', '2021-07-16', true), -- Juan -> Harry Potter
(2, 7, '2021-07-11', '2021-07-16', false), -- Ana -> Introducción a Base de Datos
(3, 5, '2021-07-12', '2021-07-20', true), -- Filippo -> Cien años de soledad
(3, 2, '2021-07-13', '2021-07-18', true), -- Filippo -> El Código Da Vinci
(4, 6, '2021-07-14', '2021-07-16', false), -- María -> El Universo: Guía de viaje
(5, 8, '2021-07-15', '2021-07-20', true); -- Laura -> Internet para principiantes
