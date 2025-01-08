CREATE DATABASE IF NOT EXISTS bibliotecas;
USE bibliotecas;
-- Crear tabla AUTOR
CREATE TABLE IF NOT EXISTS AUTOR (
    idAutor INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    nacionalidad VARCHAR(50) NOT NULL
);
-- Crear tabla LIBRO
CREATE TABLE IF NOT EXISTS LIBRO (
    idLibro INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(200) NOT NULL,
    editorial VARCHAR(100) NOT NULL,
    area VARCHAR(100) NOT NULL
);
-- Crear tabla LIBROAUTOR (relación muchos a muchos)
CREATE TABLE IF NOT EXISTS LIBROAUTOR (
    idAutor INT,
    idLibro INT,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES AUTOR(idAutor) ON DELETE CASCADE,
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro) ON DELETE CASCADE
);
-- Crear tabla ESTUDIANTE
CREATE TABLE IF NOT EXISTS ESTUDIANTE (
    idLector INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    carrera VARCHAR(100) NOT NULL,
    edad INT NOT NULL
);
-- Crear tabla PRESTAMO
CREATE TABLE IF NOT EXISTS PRESTAMO (
    idLector INT,
    idLibro INT,
    fechaPrestamo DATE NOT NULL,
    fechaDevolucion DATE,
    devuelto BOOLEAN NOT NULL DEFAULT FALSE,
    PRIMARY KEY (idLector, idLibro),
    FOREIGN KEY (idLector) REFERENCES ESTUDIANTE(idLector) ON DELETE CASCADE,
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro) ON DELETE CASCADE
);

-- Insertar registros en la tabla autor
INSERT INTO autor (nombre, nacionalidad) VALUES 
('Gabriel García Márquez', 'Colombiana'),
('Julio Cortázar', 'Argentina'),
('Mario Vargas Llosa', 'Peruana'),
('Isabel Allende', 'Chilena'),
('Jorge Luis Borges', 'Argentina');

-- Insertar registros en la tabla libro
INSERT INTO libro (titulo, editorial, area) VALUES 
('Cien años de soledad', 'Editorial Sudamericana', 'Literatura'),
('Rayuela', 'Editorial Alfredo Bryce', 'Literatura'),
('La ciudad y los perros', 'Editorial Seix Barral', 'Literatura'),
('La casa de los espíritus', 'Editorial Plaza & Janés', 'Literatura'),
('Ficciones', 'Editorial Sur', 'Literatura'),
('POO', 'Editorial Sur', 'internet');

-- Insertar registros en la tabla libroautor
INSERT INTO libroautor (idautor, idlibro) VALUES 
(1, 1),  -- "Cien años de soledad" - Gabriel García Márquez
(2, 2),  -- "Rayuela" - Julio Cortázar
(3, 3),  -- "La ciudad y los perros" - Mario Vargas Llosa
(4, 4),  -- "La casa de los espíritus" - Isabel Allende
(5, 5),  -- "Ficciones" - Jorge Luis Borges
(1, 5),  -- "Ficciones" - Gabriel García Márquez
(2, 1);  -- "Cien años de soledad" - Julio Cortázar

-- Insertar registros en la tabla estudiante
INSERT INTO estudiante (nombre, apellido, direccion, carrera, edad) VALUES 
('Juan', 'Pérez', 'Calle 123', 'Literatura', 20),
('Ana', 'Gómez', 'Avenida 456', 'Historia', 22),
('Luis', 'Martínez', 'Calle 789', 'Filosofía', 19),
('Marta', 'López', 'Calle 321', 'Ciencias Sociales', 21),
('Carlos', 'Torres', 'Avenida 654', 'Sociología', 23),
('Mauricio', 'Ballesteros', 'Avenida 654', 'Informatica', 23),
('Maria', 'Torres', 'Avenida 123', 'Informatica', 24);

-- Insertar registros en la tabla prestamo
INSERT INTO prestamo (idlector, idlibro, fechaprestamo, fechadevolucion, devuelto) VALUES 
(1, 1, '2023-10-01', '2023-10-15', TRUE),
(1, 2, '2023-10-02', NULL, FALSE),
(2, 3, '2023-10-03', '2023-10-17', TRUE),
(3, 4, '2023-10-04', NULL, FALSE),
(4, 5, '2023-10-05', '2023-10-20', TRUE);


-- 1. Listar los datos de los autores.
SELECT * FROM AUTOR;

-- Listar nombre y edad de los estudiantes
SELECT nombre, apellido, edad FROM ESTUDIANTE;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM ESTUDIANTE WHERE carrera = "Informatica";

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM AUTOR WHERE nacionalidad = "Argentina" OR nacionalidad = "Colombiana";

-- ¿Qué libros no son del área de internet?
SELECT * FROM LIBRO WHERE NOT area = "Internet";

-- Listar los libros de la Editorial Sur.
SElECT * FROM LIBRO WHERE editorial = "Editorial Sur";

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM ESTUDIANTE WHERE edad > (SELECT AVG(edad) FROM ESTUDIANTE);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT * FROM ESTUDIANTE WHERE apellido LIKE "G%";

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
EXPLAIN SELECT 
    nombre
FROM
    AUTOR
        INNER JOIN
    (SELECT 
        LIBRO.titulo, LIBROAUTOR.idAutor
    FROM
        LIBRO
    INNER JOIN LIBROAUTOR ON LIBROAUTOR.idLibro = LIBRO.idLibro) AS LIBROAUTOR ON AUTOR.idAutor = LIBROAUTOR.idAutor
WHERE
    LIBROAUTOR.titulo = 'Ficciones';
