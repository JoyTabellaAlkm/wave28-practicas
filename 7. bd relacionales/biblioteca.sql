CREATE DATABASE `biblioteca`;

CREATE TABLE AUTOR (
    idAutor INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    nacionalidad VARCHAR(100) NOT NULL
);

CREATE TABLE LIBRO (
    idLibro INT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    editorial VARCHAR(100) NOT NULL,
    area VARCHAR(100) NOT NULL
);

CREATE TABLE ESTUDIANTE (
    idLector INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    direccion VARCHAR(200) NOT NULL,
    carrera VARCHAR(100) NOT NULL,
    edad INT NOT NULL CHECK (edad > 0) 
);

CREATE TABLE PRESTAMO (
    idLector INT,
    idLibro INT,
    fechaPrestamo DATE NOT NULL,
    fechaDevolucion DATE,
    devuelto BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (idLector, idLibro),
    FOREIGN KEY (idLector) REFERENCES ESTUDIANTE(idLector),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);

CREATE TABLE LIBROAUTOR (
    idAutor INT,
    idLibro INT,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES AUTOR(idAutor),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);

INSERT INTO AUTOR (idAutor, nombre, nacionalidad) VALUES
(1, 'Gabriel García Márquez', 'Colombiana'),
(2, 'J.K. Rowling', 'Británica'),
(3, 'J.R.R. Tolkien', 'Británica'),
(4, 'Marc Levy', 'Francesa'),
(5, 'Umberto Eco', 'Italiano');

INSERT INTO LIBRO (idLibro, titulo, editorial, area) VALUES
(101, 'Cien años de soledad', 'Editorial Oveja Negra', 'Literatura'),
(102, 'Harry Potter y la piedra filosofal', 'Salamandra', 'Fantástico'),
(103, 'El hobbit', 'PockeT', 'Fantástico'),
(104, 'El Nombre de la Rosa', 'Editorial Mondadori', 'Literatura'),
(105, 'El Universo: Guía de viaje', 'Salamandra', 'Ciencia'),
(106, 'El Alquimista', 'Planeta', 'Ficción'),
(107, 'Guía de la Tierra Media', 'Tolkien', 'Internet'),
(108, 'Base de Datos para Todos', 'OReilly', 'Informática'),
(109, 'Algoritmos y Estructuras de Datos', 'McGraw-Hill', 'Informática');

INSERT INTO ESTUDIANTE (idLector, nombre, apellido, direccion, carrera, edad) VALUES
(1, 'Juan', 'Pérez', 'Calle 123', 'Informática', 20),
(2, 'Ana', 'Gómez', 'Calle 456', 'Ingeniería', 22),
(3, 'Luis', 'Rodríguez', 'Calle 789', 'Informática', 23),
(4, 'María', 'Lopez', 'Calle 101', 'Derecho', 21),
(5, 'Filippo', 'Galli', 'Calle 202', 'Informática', 19),
(6, 'César', 'Fuentes', 'Calle 303', 'Economía', 24),
(7, 'Marta', 'Santos', 'Calle 404', 'Ingeniería', 26);

INSERT INTO PRESTAMO (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES
(1, 101, '2024-01-10', null, false),
(2, 102, '2024-01-15', '2024-01-22', true),
(3, 108, '2024-01-20', null, false),
(4, 104, '2024-02-01', null, false),
(5, 109, '2024-02-10', null, false),
(6, 102, '2024-01-25', '2024-02-02', true),
(7, 104, '2024-03-05', null, false),
(5, 107, '2024-03-10', null, false);

INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES
(1, 101),  -- Gabriel García Márquez -> Cien años de soledad
(2, 102),  -- J.K. Rowling -> Harry Potter y la piedra filosofal
(3, 103),  -- J.R.R. Tolkien -> El hobbit
(4, 105),  -- Marc Levy -> El Universo: Guía de viaje
(5, 104);  -- Umberto Eco -> El Nombre de la Rosa


-- 1. Listar los datos de los autores.
SELECT * FROM AUTOR;

-- 2. Listar nombre y edad de los estudiantes
SELECT nombre, edad FROM ESTUDIANTE;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?
SELECT nombre, apellido FROM ESTUDIANTE WHERE carrera="informática";

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM AUTOR WHERE nacionalidad IN ("francesa","italiano");

-- 5. ¿Qué libros no son del área de internet?
SELECT * FROM LIBRO WHERE area <> "Internet";

-- 6. Listar los libros de la editorial Salamandra.
SELECT * FROM LIBRO WHERE editorial = "Salamandra";

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM ESTUDIANTE WHERE edad > (SELECT AVG(edad) from ESTUDIANTE);

-- 8. Listar los nombres de los estudiantes 
-- cuyo apellido comience con la letra G.
SELECT * FROM ESTUDIANTE WHERE apellido LIKE "G%";

-- 9.  Listar los autores del libro “El Universo: Guía de viaje”.
-- (Se debe listar solamente los nombres).
SELECT a.nombre FROM LIBRO l 
JOIN LIBROAUTOR la ON l.idLibro = la.idLibro
JOIN AUTOR a ON a.idAutor= la.idAutor
WHERE l.titulo="El Universo: Guía de viaje";

-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.titulo FROM ESTUDIANTE e 
JOIN PRESTAMO p ON e.idLector=p.idLector
JOIN LIBRO l ON l.idLibro=p.idLibro
WHERE e.nombre="Filippo" and e.apellido="Galli";

-- 11. Listar el nombre del estudiante de menor edad.
SELECT nombre FROM ESTUDIANTE WHERE edad=(select min(edad)from ESTUDIANTE);

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre FROM ESTUDIANTE e 
JOIN PRESTAMO p ON e.idLector=p.idLector
JOIN LIBRO l ON l.idLibro=p.idLibro
WHERE lower(l.titulo) LIKE "%base de datos%";

-- 13. Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.* FROM LIBRO l 
JOIN LIBROAUTOR la ON l.idLibro = la.idLibro
JOIN AUTOR a ON a.idAutor= la.idAutor
WHERE a.nombre="J.K. Rowling";

-- 14. Listar títulos de los libros que debían devolverse el 22/01/2024.
SELECT l.titulo
FROM LIBRO l
JOIN PRESTAMO p ON l.idLibro = p.idLibro
WHERE fechaDevolucion='2024-01-22'