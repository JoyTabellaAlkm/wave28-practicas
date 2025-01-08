CREATE DATABASE Biblioteca;
USE Biblioteca;
CREATE TABLE LIBRO (
    idLibro INT PRIMARY KEY AUTO_INCREMENT,
    Titulo VARCHAR(100) NOT NULL,
    Editorial VARCHAR(50),
    Area VARCHAR(50)
);
CREATE TABLE AUTOR (
    idAutor INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50) NOT NULL,
    Nacionalidad VARCHAR(50)
);
CREATE TABLE LIBROAUTOR (
    idAutor INT,
    idLibro INT,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES AUTOR(idAutor),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);
CREATE TABLE ESTUDIANTE (
    idLector INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50) NOT NULL,
    Apellido VARCHAR(50) NOT NULL,
    Direccion VARCHAR(100),
    Carrera VARCHAR(50),
    Edad INT
);
CREATE TABLE PRESTAMO (
    idLector INT,
    idLibro INT,
    FechaPrestamo DATE NOT NULL,
    FechaDevolucion DATE,
    Devuelto BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (idLector, idLibro, FechaPrestamo),
    FOREIGN KEY (idLector) REFERENCES ESTUDIANTE(idLector),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);

-- LIBRO
INSERT INTO LIBRO (Titulo, Editorial, Area) VALUES
('El Universo: Guía de viaje', 'Salamandra', 'Astronomía'),
('Harry Potter y la piedra filosofal', 'Salamandra', 'Fantasía'),
('Introducción a Internet', 'Pearson', 'Internet'),
('Base de Datos Avanzadas', 'McGraw-Hill', 'Base de Datos'),
('Redes Computacionales', 'Reilly', 'Redes');

-- AUTOR
INSERT INTO AUTOR (Nombre, Nacionalidad) VALUES
('Stephen Hawking', 'Británica'),
('J.K. Rowling', 'Británica'),
('Albert Einstein', 'Alemana'),
('Victor Hugo', 'Francesa'),
('Italo Calvino', 'Italiana');

-- LIBROAUTOR
INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES
(1, 1), -- Stephen Hawking - El Universo
(2, 2), -- J.K. Rowling - Harry Potter
(3, 1), -- Albert Einstein - El Universo
(4, 5), -- Victor Hugo - Redes
(5, 1); -- Italo Calvino - El Universo

-- ESTUDIANTE
INSERT INTO ESTUDIANTE (Nombre, Apellido, Direccion, Carrera, Edad) VALUES
('Filippo', 'Galli', 'Via Roma, 12', 'Informática', 22),
('María', 'Gómez', 'Calle Mayor, 10', 'Derecho', 21),
('Lucas', 'González', 'Av. Libertad, 123', 'Informática', 20),
('Laura', 'Fernández', 'Calle Sur, 5', 'Ingeniería', 24),
('Guillermo', 'García', 'Calle Norte, 8', 'Medicina', 26);

-- PRESTAMO
INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(1, 1, '2021-07-10', '2021-07-16', FALSE), -- Filippo - El Universo
(1, 4, '2022-01-05', NULL, FALSE), -- Filippo - Base de Datos
(2, 2, '2022-02-01', NULL, FALSE), -- María - Harry Potter
(3, 4, '2023-05-03', '2023-05-15', TRUE), -- Lucas - Base de Datos
(4, 5, '2023-06-20', NULL, FALSE); -- Laura - Redes


-- 1. Listar los datos de los autores.
SELECT * FROM AUTOR;

-- 2. Listar nombre y edad de los estudiantes
SELECT Nombre, Edad FROM ESTUDIANTE;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?
SELECT Nombre, Carrera FROM ESTUDIANTE WHERE Carrera = "Informática";

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?
SELECT Nombre, Nacionalidad FROM AUTOR WHERE Nacionalidad = "Francesa" OR Nacionalidad = "Italiana";

-- 5. ¿Qué libros no son del área de internet?
SELECT Titulo, Area FROM LIBRO WHERE Area != "Internet";

-- 6. Listar los libros de la editorial Salamandra.
SELECT Titulo, Editorial FROM LIBRO Where Editorial = "Salamandra";

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM ESTUDIANTE WHERE Edad > (SELECT AVG(Edad) FROM ESTUDIANTE);

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT Nombre, Apellido FROM ESTUDIANTE WHERE Apellido LIKE 'G%';

-- 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.Nombre, l.Titulo  FROM AUTOR a
INNER JOIN LIBROAUTOR la ON la.idAutor = a.idAutor
INNER JOIN LIBRO l ON l.idLibro = la.idLibro
WHERE l.Titulo = "El Universo: Guía de viaje";

-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT e.Nombre, l.Titulo FROM ESTUDIANTE e
INNER JOIN PRESTAMO p ON p.idLector = e.idLector
INNER JOIN LIBRO l ON l.idLibro = p.idLibro
WHERE e.Nombre = "Filippo" AND e.Apellido = "Galli";

-- 11. Listar el nombre del estudiante de menor edad.
SELECT Nombre, Edad FROM ESTUDIANTE ORDER BY Edad ASC LIMIT 1;

Select Nombre, Edad from ESTUDIANTE
WHERE Edad = (SELECT MIN(Edad) FROM ESTUDIANTE);

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.Nombre, l.Titulo FROM ESTUDIANTE e
INNER JOIN PRESTAMO p ON p.idLector = e.idLector
INNER JOIN LIBRO l ON l.idLibro = p.idLibro
WHERE l.Area = "Base de Datos";

-- 13. Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.Titulo  FROM LIBRO l
INNER JOIN LIBROAUTOR la ON la.idLibro = l.idLibro
INNER JOIN AUTOR a ON a.idAutor = la.idAutor
WHERE a.Nombre = "J.K. Rowling";

-- 14. Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.Titulo FROM Libro l
INNER JOIN PRESTAMO p ON p.idLibro = l.idLibro
WHERE FechaDevolucion = '2021-07-16'
AND Devuelto = FALSE;
