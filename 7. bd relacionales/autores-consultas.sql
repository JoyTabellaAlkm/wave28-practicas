## Consultas

-- Primero
SELECT * FROM autor;
-- Segundo
SELECT nombre, edad FROM estudiante;
-- Tercero
SELECT * FROM estudiante WHERE carrera = "Informatica";
-- Cuarto
SELECT * FROM autor WHERE nacionalidad IN ("Francesa", "Italiana");
-- Quinta
SELECT * FROM libro WHERE area != "Internet";
-- Sexta
SELECT * FROM libro WHERE editorial = "Salamandra";
-- Septima
SELECT * FROM estudiante WHERE edad > (SELECT AVG(edad) FROM estudiante);
-- Octava
SELECT * FROM estudiante WHERE apellido LIKE "G%";
-- Novena
SELECT autor.nombre FROM libro INNER JOIN libroautor ON libroautor.idLibro = libro.idLibro
INNER JOIN autor ON libroautor.idAutor = autor.idAutor WHERE libro.titulo = "El Universo: Guía de viaje";
-- Decimo
SELECT titulo FROM libro INNER JOIN prestamo ON libro.idLibro = prestamo.idLibro
INNER JOIN estudiante ON prestamo.idLector = estudiante.idLector WHERE estudiante.nombre = "Filippo" AND
estudiante.apellido = "Galli";
-- Once
SELECT nombre FROM estudiante WHERE edad = (SELECT MIN(edad) FROM estudiante);
-- Doceabo
SELECT estudiante.nombre FROM libro INNER JOIN prestamo ON libro.idLibro = prestamo.idLibro INNER JOIN estudiante ON prestamo.idLector = estudiante.idLector;
-- treceavo
SELECT libro.nombre FROM libro INNER JOIN libroautor ON libroautor.idLibro = libro.idLibro
INNER JOIN autor ON libroautor.idAutor = autor.idAutor WHERE autor.nombre = "J.K. Rowling";
-- catorceavo
SELECT estudiante.nombre FROM libro INNER JOIN prestamo ON libro.idLibro = prestamo.idLibro WHERE prestamo.FechaDevolucion = '16-07-2021';
## Base

-- Tabla AUTOR
CREATE TABLE AUTOR (
    idAutor INT PRIMARY KEY,
    Nombre VARCHAR(100),
    Nacionalidad VARCHAR(50)
);
-- Tabla LIBRO
CREATE TABLE LIBRO (
    idLibro INT PRIMARY KEY,
    Titulo VARCHAR(200),
    Editorial VARCHAR(100),
    Area VARCHAR(50)
);
-- Tabla ESTUDIANTE
CREATE TABLE ESTUDIANTE (
    idLector INT PRIMARY KEY,
    Nombre VARCHAR(100),
    Apellido VARCHAR(100),
    Direccion VARCHAR(200),
    Carrera VARCHAR(100),
    Edad INT
);
-- Tabla PRESTAMO
CREATE TABLE PRESTAMO (
    idLector INT,
    idLibro INT,
    FechaPrestamo DATE,
    FechaDevolucion DATE,
    Devuelto BOOLEAN,
    PRIMARY KEY (idLector, idLibro, FechaPrestamo),
    FOREIGN KEY (idLector) REFERENCES ESTUDIANTE(idLector),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);
-- Tabla LIBROAUTOR
CREATE TABLE LIBROAUTOR (
    idAutor INT,
    idLibro INT,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES AUTOR(idAutor),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);
-- Insertar datos en AUTOR
INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad) VALUES
(1, 'Gabriel Garcia Marquez', 'Colombiana'),
(2, 'Isabel Allende', 'Chilena');
-- Insertar datos en LIBRO
INSERT INTO LIBRO (idLibro, Titulo, Editorial, Area) VALUES
(1, 'Cien años de soledad', 'Editorial A', 'Ficción'),
(2, 'La casa de los espíritus', 'Editorial B', 'Novela');
-- Insertar datos en ESTUDIANTE
INSERT INTO ESTUDIANTE (idLector, Nombre, Apellido, Direccion, Carrera, Edad) VALUES
(1, 'Juan', 'Pérez', 'Calle Falsa 123', 'Ingeniería', 21),
(2, 'Ana', 'Gómez', 'Av. Siempre Viva 742', 'Medicina', 22);
-- Insertar datos en LIBROAUTOR
INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES
(1, 1),
(2, 2);
-- Insertar datos en PRESTAMO
INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(1, 1, '2023-01-10', '2023-01-20', FALSE),
(2, 2, '2023-02-05', '2023-03-01', TRUE);
