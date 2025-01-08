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
('Ficciones', 'Editorial Sur', 'Literatura');

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
('Carlos', 'Torres', 'Avenida 654', 'Informatica', 23);

-- Insertar registros en la tabla prestamo
INSERT INTO prestamo (idlector, idlibro, fechaprestamo, fechadevolucion, devuelto) VALUES 
(1, 1, '2023-10-01', '2023-10-15', TRUE),
(1, 2, '2023-10-02', 2023-10-17, TRUE),
(2, 3, '2023-10-03', '2023-10-17', TRUE),
(3, 4, '2023-10-04', NULL, FALSE),
(4, 5, '2023-10-05', '2023-10-20', TRUE);

#Listar los datos de los autores.
SELECT a.*
FROM autor a;
#Listar nombre y edad de los estudiantes
SELECT e.nombre, e.edad
FROM estudiante e;
#¿Qué estudiantes pertenecen a la carrera informática?
SELECT e.*
FROM estudiante e
WHERE e.carrera = "Informatica";
#¿Qué autores son de nacionalidad francesa o italiana?
SELECT a.*
FROM autor a
WHERE a.nacionalidad="Argentina" OR a.nacionalidad="Colombiana";
#¿Qué libros no son del área de internet?
SELECT l.*
FROM libro l
WHERE NOT l.area="Internet";
#Listar los libros de la editorial Salamandra.
SELECT l.*
FROM libro l
WHERE l.editorial="Editorial Plaza & Janés";
#Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT e.nombre
FROM estudiante e
WHERE e.edad > (SELECT AVG(edad) 
				FROM estudiante);
#Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT e.*
FROM estudiante e
WHERE e.apellido LIKE "G%";
#Listar los autores del libro “El Universo: Guía de viaje”(usamos La ciudad y los perros". (Se debe listar solamente los nombres).
SELECT a.nombre
FROM autor a
INNER JOIN libroautor la ON a.idautor = la.idautor
WHERE la.idlibro = (SELECT l.idlibro
					FROM libro L
					WHERE l.titulo="La ciudad y los perros");
#¿Qué libros se prestaron al lector “Filippo Galli”? Usamos Juan Pérez
SELECT l.*
FROM prestamo p
INNER JOIN libro l ON p.idlibro = l.idlibro
WHERE p.idlector = (SELECT e.idlector
					FROM estudiante e
					WHERE e.nombre="Juan" AND e.apellido="Pérez");
#Listar el nombre del estudiante de menor edad.
SELECT e.nombre
FROM estudiante e
WHERE e.edad = (SELECT MIN(edad)
				FROM estudiante);
#Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos. Usamos Rayuela
SELECT e.nombre
FROM estudiante e
INNER JOIN prestamo p ON e.idlector = p.idlector
WHERE p.idlibro = (SELECT l.idlibro
					FROM libro l
                    WHERE l.titulo LIKE "%Rayuela%");
#Listar los libros que pertenecen a la autora J.K. Rowling. Usamos Julio Cortázar
SELECT l.*
FROM libro l
INNER JOIN libroautor la ON l.idlibro = la.idlibro
WHERE la.idautor = (SELECT a.idautor
					FROM autor a
                    WHERE a.nombre="Julio Cortázar");
#Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo
FROM prestamo p
INNER JOIN libro l ON p.idlibro = l.idlibro
WHERE p.fechadevolucion = "2023-10-17";

