-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS biblioteca;

-- Usar la base de datos creada
USE biblioteca;

-- Tabla de autores
CREATE TABLE IF NOT EXISTS autor (
    idautor INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(45) NOT NULL,
    nacionalidad VARCHAR(45) NOT NULL,
    PRIMARY KEY (idautor)
);

-- Tabla de libros
CREATE TABLE IF NOT EXISTS libro (
    idlibro INT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    editorial VARCHAR(45) NOT NULL,
    area VARCHAR(45) NOT NULL,
    PRIMARY KEY (idlibro)
);

-- Tabla de libroautor (relación entre libros y autores)
CREATE TABLE IF NOT EXISTS libroautor (
    idautor INT NOT NULL,
    idlibro INT NOT NULL,
    PRIMARY KEY (idautor, idlibro),
    FOREIGN KEY (idautor) REFERENCES autor(idautor),
    FOREIGN KEY (idlibro) REFERENCES libro(idlibro)
);

-- Tabla de estudiantes
CREATE TABLE IF NOT EXISTS estudiante (
    idlector INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(45) NOT NULL,
    apellido VARCHAR(45) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    carrera VARCHAR(45) NOT NULL,
    edad INT NOT NULL,
    PRIMARY KEY (idlector)
);

-- Tabla de préstamos
CREATE TABLE IF NOT EXISTS prestamo (
    idlector INT NOT NULL,
    idlibro INT NOT NULL,
    fechaprestamo DATE NOT NULL,
    fechadevolucion DATE,
    devuelto BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (idlector) REFERENCES estudiante(idlector),
    FOREIGN KEY (idlibro) REFERENCES libro(idlibro)
);