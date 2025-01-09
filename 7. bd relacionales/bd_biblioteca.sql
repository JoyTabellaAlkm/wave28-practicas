-- Crear la base de datos
CREATE DATABASE biblioteca;
USE biblioteca;

-- Crear tabla autor
CREATE TABLE autor (
    idautor INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    nacionalidad VARCHAR(50) NOT NULL
);

-- Crear tabla libro
CREATE TABLE libro (
    idlibro INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(200) NOT NULL,
    editorial VARCHAR(100) NOT NULL,
    area VARCHAR(100) NOT NULL
);

-- Crear tabla libroautor (relación muchos a muchos)
CREATE TABLE libroautor (
    idautor INT,
    idlibro INT,
    PRIMARY KEY (idautor, idlibro),
    FOREIGN KEY (idautor) REFERENCES autor(idautor) ON DELETE CASCADE,
    FOREIGN KEY (idlibro) REFERENCES libro(idlibro) ON DELETE CASCADE
);

-- Crear tabla estudiante
CREATE TABLE estudiante (
    idlector INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    carrera VARCHAR(100) NOT NULL,
    edad INT NOT NULL
);

-- Crear tabla prestamo
CREATE TABLE prestamo (
    idlector INT,
    idlibro INT,
    fechaprestamo DATE NOT NULL,
    fechadevolucion DATE,
    devuelto BOOLEAN NOT NULL DEFAULT FALSE,
    PRIMARY KEY (idlector, idlibro),
    FOREIGN KEY (idlector) REFERENCES estudiante(idlector) ON DELETE CASCADE,
    FOREIGN KEY (idlibro) REFERENCES libro(idlibro) ON DELETE CASCADE
);