DROP DATABASE IF EXISTS biblioteca_db;
CREATE DATABASE biblioteca_db;
USE biblioteca_db;

CREATE TABLE autor(
	id_autor INT PRIMARY KEY,
    nombre VARCHAR(50),
    nacionalidad VARCHAR(50)
);

CREATE TABLE estudiante(
	id_estudiante INT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    direccion VARCHAR(100),
    carrera VARCHAR(100),
    edad SMALLINT
);

CREATE TABLE libro(
	id_libro INT PRIMARY KEY,
    titulo VARCHAR(50),
    editorial VARCHAR(50),
    area VARCHAR(50)
);

CREATE TABLE libro_autor(
	id_libro_autor INT PRIMARY KEY,
    id_autor INT,
    id_libro INT,
    FOREIGN KEY (id_autor) REFERENCES autor(id_autor),
    FOREIGN KEY (id_libro) REFERENCES libro(id_libro)
);

CREATE TABLE prestamo(
	id_prestamo INT PRIMARY KEY,
    id_estudiante INT,
    id_libro INT,
    fecha_prestamo DATE,
    fecha_devolucion DATE,
    devuelto TINYINT,
    FOREIGN KEY (id_estudiante) REFERENCES estudiante(id_estudiante),
    FOREIGN KEY (id_libro) REFERENCES libro(id_libro)
);


INSERT INTO autor (id_autor, nombre, nacionalidad) VALUES
(1, 'Gabriel García Márquez', 'Colombiana'),
(2, 'Pablo Neruda', 'Chilena'),
(3, 'Isabel Allende', 'Chilena'),
(4, 'Jorge Luis Borges', 'Argentina'),
(5, 'Mario Vargas Llosa', 'Peruana'),
(6, 'Julio Cortázar', 'Argentina'),
(7, 'Gabriela Mistral', 'Chilena'),
(8, 'Ray Bradbury', 'Estadounidense'),
(9, 'George Orwell', 'Británica'),
(10, 'Jane Austen', 'Británica');

INSERT INTO estudiante (id_estudiante, nombre, apellido, direccion, carrera, edad) VALUES
(1, 'Juan', 'Pérez', 'Calle 123', 'Literatura', 20),
(2, 'María', 'López', 'Avenida 456', 'Historia', 22),
(3, 'Ana', 'García', 'Calle 789', 'Sociología', 19),
(4, 'Luis', 'Vargas', 'Calle 321', 'Filosofía', 21),
(5, 'Sofía', 'Martínez', 'Calle 654', 'Antropología', 23),
(6, 'Carlos', 'Hernández', 'Calle 852', 'Informática', 24),
(7, 'Laura', 'Torres', 'Calle 963', 'Comunicación', 20),
(8, 'Javier', 'Solis', 'Calle 147', 'Psicología', 22),
(9, 'Elena', 'Mendoza', 'Calle 258', 'Ciencias Políticas', 21),
(10, 'David', 'Jiménez', 'Calle 369', 'Informática', 19);

INSERT INTO libro (id_libro, titulo, editorial, area) VALUES
(1, 'Cien años de soledad', 'Editores mexicanos', 'Ficción'),
(2, 'El amor en los tiempos del cólera', 'Random House', 'Ficción'),
(3, 'La casa de los espíritus', 'Sudamericana', 'Ficción'),
(4, 'Ficciones', 'Sur', 'Ficción'),
(5, 'La ciudad y los perros', 'Seix Barral', 'Ficción'),
(6, 'Crónica de una muerte anunciada', 'Salamandra', 'Ficción'),
(7, 'El túnel', 'Sudamericana', 'Ficción'),
(8, 'Fahrenheit 451', 'Ray Bradbury', 'Ciencia Ficción'),
(9, '1984', 'Secker and Warburg', 'Distopía'),
(10, 'Orgullo y prejuicio', 'Editorial Salamandra', 'Romance');

INSERT INTO libro_autor (id_libro_autor, id_autor, id_libro) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 2, 3),
(4, 3, 4),
(5, 4, 5),
(6, 5, 6),
(7, 6, 7),
(8, 8, 8),
(9, 9, 9),
(10, 10, 10);

INSERT INTO prestamo (id_prestamo, id_estudiante, id_libro, fecha_prestamo, fecha_devolucion, devuelto) VALUES
(1, 1, 1, '2023-01-10', '2023-02-10', 1),
(2, 1, 3, '2023-03-15', NULL, 0),
(3, 2, 2, '2023-01-20', '2023-02-20', 1),
(4, 3, 5, '2023-01-25', NULL, 0),
(5, 4, 6, '2023-02-01', '2023-03-01', 1),
(6, 5, 7, '2023-02-11', NULL, 0),
(7, 6, 4, '2023-02-05', '2023-02-25', 1),
(8, 7, 9, '2023-03-01', '2023-03-15', 1),
(9, 8, 10, '2023-03-12', NULL, 0),
(10, 9, 8, '2023-01-30', '2023-02-05', 1),
(11, 10, 1, '2023-02-12', NULL, 0);

# Listar los datos de los autores.
SELECT *
FROM autor;

# Listar nombre y edad de los estudiantes
SELECT nombre, edad
FROM estudiante;

# ¿Qué estudiantes pertenecen a la carrera informática?
SELECT *
FROM estudiante
WHERE carrera = "Informatica";

# ¿Qué autores son de nacionalidad francesa o colombiana?
SELECT *
FROM autor
WHERE nacionalidad = "Francesa" OR nacionalidad = "Colombiana";

# ¿Qué libros no son del área de internet?
SELECT *
FROM libro
WHERE area != "Internet";

# Listar los libros de la editorial Salamandra.
SELECT *
FROM libro
WHERE editorial LIKE "%Salamandra%";

# Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT *
FROM estudiante
WHERE edad > (
	SELECT AVG(edad)
	FROM estudiante
);

# Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT *
FROM estudiante
WHERE apellido LIKE "G%";

# Listar los autores del libro “Fahrenheit 451”. (Se debe listar solamente los nombres).
SELECT a.*
FROM autor a
JOIN libro_autor la ON a.id_autor = la.id_autor
JOIN libro l ON la.id_libro = l.id_libro
WHERE l.titulo = "Fahrenheit 451";

# ¿Qué libros se prestaron al lector “Juan Pérez”?
SELECT l.* 
FROM libro l
JOIN prestamo p ON l.id_libro = p.id_libro
JOIN estudiante e ON p.id_estudiante = e.id_estudiante
WHERE e.nombre = "Juan" AND e.apellido = "Pérez";

# Listar el nombre del estudiante de menor edad.
SELECT nombre
FROM estudiante
WHERE edad = (
	SELECT MIN(edad)
	FROM estudiante
);

# Listar nombres de los estudiantes a los que se prestaron libros de Ficción.
SELECT DISTINCT e.nombre, e.apellido
FROM libro l
JOIN prestamo p ON l.id_libro = p.id_libro
JOIN estudiante e ON p.id_estudiante = e.id_estudiante
WHERE l.area = "Ficción";

# Listar los libros que pertenecen a la autora Jane Austen.
SELECT l.*
FROM libro l
JOIN libro_autor la ON l.id_libro = la.id_libro
JOIN autor a ON la.id_autor = a.id_autor
WHERE a.nombre = "Jane Austen";

# Listar títulos de los libros que debían devolverse el 05/02/2023
SELECT l.titulo
FROM libro l
JOIN prestamo p ON l.id_libro = p.id_libro
WHERE p.fecha_devolucion = "2023-02-05";


