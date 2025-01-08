-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS biblioteca;
USE biblioteca;

-- Crear las tablas

-- Tabla Autor
CREATE TABLE IF NOT EXISTS Autor (
    IdAutor INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
    Nacionalidad VARCHAR(50) NOT NULL
);

-- Tabla Libro
CREATE TABLE IF NOT EXISTS Libro (
    IdLibro INT AUTO_INCREMENT PRIMARY KEY,
    Titulo VARCHAR(150) NOT NULL,
    Editorial VARCHAR(100),
    Area VARCHAR(50)
);

-- Tabla LibroAutor
CREATE TABLE IF NOT EXISTS LibroAutor (
    IdAutor INT,
    IdLibro INT,
    PRIMARY KEY(IdAutor, IdLibro),
    FOREIGN KEY(IdAutor) REFERENCES Autor(IdAutor),
    FOREIGN KEY(IdLibro) REFERENCES Libro(IdLibro)
);

-- Tabla Estudiante (Lector)
CREATE TABLE IF NOT EXISTS Estudiante (
    IdLector INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
    Apellido VARCHAR(100) NOT NULL,
    Direccion TEXT,
    Carrera VARCHAR(100),
    Edad INT CHECK (Edad >= 18)
);

-- Tabla Prestamo
CREATE TABLE IF NOT EXISTS Prestamo (
    IdLector INT,
    IdLibro INT,
    FechaPrestamo DATE NOT NULL,
    FechaDevolucion DATE NOT NULL,
    Devuelto BOOLEAN DEFAULT FALSE,
    PRIMARY KEY(IdLector, IdLibro, FechaPrestamo),
    FOREIGN KEY(IdLector) REFERENCES Estudiante(IdLector),
    FOREIGN KEY(IdLibro) REFERENCES Libro(IdLibro)
);

-- Insertar autores
INSERT INTO Autor (Nombre, Nacionalidad) VALUES 
('Gabriel García Márquez', 'Colombiana'),
('J.K. Rowling', 'Británica'),
('Umberto Eco', 'Italiano'),
('Marcel Proust', 'Francés'),
('Mario Vargas Llosa', 'Peruana');

-- Insertar libros
INSERT INTO Libro (Titulo, Editorial, Area) VALUES 
('Cien años de soledad', 'Sudamericana', 'Literatura'),
('Harry Potter y la piedra filosofal', 'Salamandra', 'Fantasía'),
('El Nombre de la Rosa', 'Penguin Random House', 'Historia'),
('El Universo: Guía de viaje', 'Planeta', 'Ciencia'),
('Fundamentos de bases de datos', 'McGraw-Hill', 'Base de Datos'),
('El Tiempo Perdido', 'Galaxia Gutenberg', 'Literatura');

-- Relacionar libros y autores
INSERT INTO LibroAutor (IdAutor, IdLibro) VALUES 
(1, 1),  -- Gabriel García Márquez y Cien años de soledad
(2, 2),  -- J.K. Rowling y Harry Potter y la piedra filosofal
(3, 3),  -- Umberto Eco y El Nombre de la Rosa
(4, 4),  -- Marcel Proust y El Universo: Guía de viaje
(5, 5),  -- Mario Vargas Llosa y Fundamentos de bases de datos
(1, 6),  -- Gabriel García Márquez y El Tiempo Perdido
(5, 6);  -- Mario Vargas Llosa y El Tiempo Perdido

-- Insertar estudiantes
INSERT INTO Estudiante (Nombre, Apellido, Direccion, Carrera, Edad) VALUES 
('Filippo', 'Galli', 'Via Roma 45, Milán', 'Informática', 22),
('Ana', 'Gómez', 'Calle Mayor 12, Madrid', 'Historia', 20),
('Pedro', 'Martínez', 'Avenida Central 80, Buenos Aires', 'Ingeniería', 25),
('Lucía', 'González', 'Calle Serrano 56, Madrid', 'Psicología', 30),
('Carlos', 'Gómez', 'Calle del Sol 34, Sevilla', 'Informática', 18),
('Sofía', 'Pérez', 'Av. Libertador 99, Buenos Aires', 'Matemáticas', 27);

-- Insertar préstamos
INSERT INTO Prestamo (IdLector, IdLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES 
(1, 5, '2021-06-01', '2021-06-15', TRUE),  -- Filippo Galli (Base de Datos)
(2, 1, '2021-07-01', '2021-07-15', TRUE),  -- Ana Gómez (Cien años de soledad)
(3, 2, '2021-06-10', '2021-06-20', FALSE), -- Pedro Martínez (Harry Potter)
(4, 3, '2021-06-05', '2021-06-10', TRUE),  -- Lucía González (El Nombre de la Rosa)
(5, 4, '2021-06-01', '2021-06-30', TRUE);  -- Carlos Gómez (El Universo: Guía de viaje)


-- Verificación de datos insertados
SELECT * FROM Autor;
SELECT * FROM Libro;
SELECT * FROM LibroAutor;
SELECT * FROM Estudiante;
SELECT * FROM Prestamo;

#Listar los datos de los autores.
SELECT * FROM Autor;
#Listar nombre y edad de los estudiantes
SELECT NOMBRE, EDAD FROM ESTUDIANTE;
#¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM ESTUDIANTE WHERE CARRERA LIKE 'Informática';
#¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM AUTOR WHERE NACIONALIDAD IN ('Italiano','Frances');
#¿Qué libros no son del área de internet?
SELECT * FROM LIBRO WHERE AREA NOT LIKE 'Base de Datos';
#Listar los libros de la editorial Salamandra.
SELECT * FROM LIBRO WHERE EDITORIAL LIKE 'Salamandra';
#Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM ESTUDIANTE E WHERE (SELECT AVG(EDAD) FROM ESTUDIANTE ) < E.EDAD;
#Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT * FROM ESTUDIANTE WHERE APELLIDO LIKE 'G%';
#Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT A.NOMBRE FROM AUTOR A 
JOIN LIBROAUTOR LA ON A.IDAUTOR = LA.IDAUTOR
JOIN LIBRO L ON L.IDLIBRO = LA.IDLIBRO
WHERE L.TITULO LIKE 'El Universo: Guía de viaje';

#¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT L.TITULO FROM ESTUDIANTE E
JOIN PRESTAMO P ON E.IDLECTOR = P.IDLECTOR
JOIN LIBRO L ON L.IDLIBRO = P.IDLIBRO
WHERE E.NOMBRE LIKE 'Filippo' AND E.APELLIDO LIKE 'Galli';
#Listar el nombre del estudiante de menor edad.
SELECT E.NOMBRE FROM ESTUDIANTE E WHERE (SELECT MIN(EDAD) FROM ESTUDIANTE) = E.EDAD LIMIT 1;
#Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT E.NOMBRE, E.APELLIDO FROM ESTUDIANTE E
JOIN PRESTAMO P ON E.IDLECTOR = P.IDLECTOR
JOIN LIBRO L ON L.IDLIBRO = P.IDLIBRO
WHERE L.AREA LIKE 'Base de Datos';
#Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT L.TITULO FROM AUTOR A 
JOIN LIBROAUTOR LA ON A.IDAUTOR = LA.IDAUTOR
JOIN LIBRO L ON L.IDLIBRO = LA.IDLIBRO
WHERE A.NOMBRE LIKE 'J.K. Rowling';
#Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT L.TITULO FROM ESTUDIANTE E
JOIN PRESTAMO P ON E.IDLECTOR = P.IDLECTOR
JOIN LIBRO L ON L.IDLIBRO = P.IDLIBRO
WHERE P.FechaDevolucion = '2021-06-15';
