DROP SCHEMA IF EXISTS `biblioteca` ;

CREATE SCHEMA `biblioteca` ;

USE `biblioteca` ;

CREATE TABLE libro (
    idLibro INT PRIMARY KEY,
    Titulo VARCHAR(100),
    Editorial VARCHAR(100),
    Area VARCHAR(50)
);

CREATE TABLE autor (
    idAutor INT PRIMARY KEY,
    Nombre VARCHAR(100),
    Nacionalidad VARCHAR(50)
);

CREATE TABLE libroautor (
    idAutor INT,
    idLibro INT,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES autor(idAutor),
    FOREIGN KEY (idLibro) REFERENCES libro(idLibro)
);

CREATE TABLE estudiante (
    idLector INT PRIMARY KEY,
    Nombre VARCHAR(100),
    Apellido VARCHAR(100),
    Direccion VARCHAR(200),
    Carrera VARCHAR(100),
    Edad INT
);

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