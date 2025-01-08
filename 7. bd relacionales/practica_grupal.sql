CREATE TABLE AUTOR (
    idAutor INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    nacionalidad VARCHAR(50) NOT NULL
);

CREATE TABLE LIBRO (
    idLibro INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    editorial VARCHAR(100) NOT NULL,
    area VARCHAR(100) NOT NULL
);

CREATE TABLE ESTUDIANTE (
    idLector INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    carrera VARCHAR(100) NOT NULL,
    edad INT NOT NULL
);

CREATE TABLE LIBROAUTOR (
    idAutor INT,
    idLibro INT,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES AUTOR(idAutor) ON DELETE CASCADE,
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro) ON DELETE CASCADE
);

CREATE TABLE PRESTAMO (
    idLector INT,
    idLibro INT,
    fechaPrestamo DATE NOT NULL,
    fechaDevolucion DATE,
    devuelto BOOLEAN NOT NULL DEFAULT FALSE,
    PRIMARY KEY (idLector, idLibro, fechaPrestamo),
    FOREIGN KEY (idLector) REFERENCES ESTUDIANTE(idLector) ON DELETE CASCADE,
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro) ON DELETE CASCADE
);

INSERT INTO AUTOR (nombre, nacionalidad) VALUES
('Gabriel García Márquez', 'Colombiana'),
('J.K. Rowling', 'Británica'),
('Isaac Asimov', 'Estadounidense'),
('Victor Hugo', 'Francesa'),
('Umberto Eco', 'Italiana');

INSERT INTO LIBRO (titulo, editorial, area) VALUES
('Cien años de soledad', 'Editorial Oveja Negra', 'Novela'),
('Harry Potter y la piedra filosofal', 'Editorial Salamandra', 'Internet'),
('Yo, Robot', 'Editorial Grijalbo', 'Ciencia Ficción'),
('El Universo: Guía de viaje', 'Guía Espacial', 'Astronomía'),
('Fundación', 'Editorial Planeta', 'Ciencia Ficción'),
('Base de Datos Modernos', 'Editorial McGraw-Hill', 'Tecnología');

INSERT INTO ESTUDIANTE (nombre, apellido, direccion, carrera, edad) VALUES
('Juan', 'Pérez', 'Calle Falsa 123', 'Ingeniería', 20),
('Ana', 'Gómez', 'Avenida Siempre Viva 742', 'Literatura', 22),
('Luis', 'Martínez', 'Calle Mayor 45', 'Ciencias de la Computación', 21),
('Filippo', 'Galli', 'Vía Roma 10', 'Informática', 19),
('Clara', 'Rodríguez', 'Calle Luna 88', 'Ciencias de la Computación', 25);

INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES
(1, 1),  -- Gabriel García Márquez - Cien años de soledad
(2, 2),  -- J.K. Rowling - Harry Potter y la piedra filosofal
(3, 3),  -- Isaac Asimov - Yo, Robot
(4, 4),  -- Victor Hugo - El Universo: Guía de viaje
(5, 5),  -- Umberto Eco - Fundación
(2, 6);  -- J.K. Rowling - Base de Datos Modernos

INSERT INTO PRESTAMO (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES
(1, 1, '2023-10-01', NULL, FALSE),  -- Juan Pérez presta "Cien años de soledad"
(2, 2, '2023-10-05', '2023-10-12', TRUE),  -- Ana Gómez presta "Harry Potter", devuelto
(3, 1, '2023-10-07', NULL, FALSE),  -- Luis Martínez presta "Cien años de soledad"
(4, 6, '2023-10-10', NULL, FALSE),  -- Filippo Galli presta "Base de Datos Modernos"
(5, 4, '2023-10-11', NULL, FALSE);  -- Clara Rodríguez presta "El Universo: Guía de viaje"


-- En base al mismo, plantear las consultas SQL para resolver los siguientes requerimientos:

-- Listar los datos de los autores.
SELECT * FROM AUTOR;

-- Listar nombre y edad de los estudiantes
SELECT e.nombre, e.edad FROM ESTUDIANTE e;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT e.nombre, e.edad FROM ESTUDIANTE e WHERE e.carrera = "Informática";

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT a.nombre, a.nacionalidad FROM AUTOR a WHERE a.nacionalidad IN ("Francesa", "Italiana");

-- ¿Qué libros no son del área de internet?
SELECT * FROM LIBRO l WHERE l.area <> "Internet"; -- !=

-- Listar los libros de la editorial Salamandra.
SELECT * FROM LIBRO l WHERE l.editorial LIKE "%Salamandra";

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM ESTUDIANTE e WHERE e.edad > (SELECT AVG(e2.edad) FROM ESTUDIANTE e2);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT * FROM ESTUDIANTE e WHERE e.apellido LIKE "G%";

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre FROM AUTOR a
INNER JOIN LIBROAUTOR la ON la.idAutor = a.idAutor
INNER JOIN LIBRO l ON l.idLibro = la.idLibro
WHERE l.titulo = "El Universo: Guía de viaje";


-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.* FROM LIBRO l
INNER JOIN PRESTAMO p INNER JOIN ESTUDIANTE e ON p.idLibro = l.idLibro AND e.idLector = p.idLector
AND e.nombre = "Filippo" AND e.apellido = "Galli";

-- Listar el nombre del estudiante de menor edad.
SELECT * FROM ESTUDIANTE e WHERE e.edad = (SELECT MIN(e2.edad) FROM ESTUDIANTE e2);

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre, e.apellido FROM LIBRO l
INNER JOIN PRESTAMO p INNER JOIN ESTUDIANTE e ON p.idLibro = l.idLibro AND e.idLector = p.idLector
AND l.area = "Base de Datos";

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.* FROM LIBRO l
INNER JOIN LIBROAUTOR la ON la.idLibro = l.idLibro
INNER JOIN AUTOR a ON a.idAutor = la.idAutor
WHERE a.nombre = "J.K. Rowling";

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo 
FROM LIBRO l
INNER JOIN PRESTAMO p ON p.idLibro = l.idLibro
WHERE p.fechaDevolucion = '2021-07-16';