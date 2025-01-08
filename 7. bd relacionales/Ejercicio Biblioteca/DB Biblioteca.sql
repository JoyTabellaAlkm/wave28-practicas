CREATE DATABASE Biblioteca;

USE Biblioteca;

-- Tabla Autor
CREATE TABLE Autor (
    idAutor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    nacionalidad VARCHAR(50) NOT NULL
);

-- Tabla Libro
CREATE TABLE Libro (
    idLibro INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    editorial VARCHAR(100) NOT NULL,
    area VARCHAR(50) NOT NULL
);

-- Tabla LibroAutor
CREATE TABLE LibroAutor (
    idAutor INT NOT NULL,
    idLibro INT NOT NULL,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES Autor(idAutor),
    FOREIGN KEY (idLibro) REFERENCES Libro(idLibro)
);

-- Tabla Estudiante
CREATE TABLE Estudiante (
    idLector INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    carrera VARCHAR(100) NOT NULL,
    edad INT NOT NULL
);

-- Tabla Prestamo
CREATE TABLE Prestamo (
    idLector INT NOT NULL,
    idLibro INT NOT NULL,
    fechaPrestamo DATE NOT NULL,
    fechaDevolucion DATE NOT NULL,
    devuelto BOOLEAN NOT NULL,
    PRIMARY KEY (idLector, idLibro, fechaPrestamo),
    FOREIGN KEY (idLector) REFERENCES Estudiante(idLector),
    FOREIGN KEY (idLibro) REFERENCES Libro(idLibro)
);
