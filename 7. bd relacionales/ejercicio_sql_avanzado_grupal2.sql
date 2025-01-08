use libreria;

-- Crear las tablas

CREATE TABLE AUTOR (
    idAutor INT PRIMARY KEY,
    Nombre VARCHAR(100),
    Nacionalidad VARCHAR(50)
);

CREATE TABLE LIBRO (
    idLibro INT PRIMARY KEY,
    Titulo VARCHAR(150),
    Editorial VARCHAR(100),
    Area VARCHAR(50)
);

CREATE TABLE LIBROAUTOR (
    idAutor INT,
    idLibro INT,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES AUTOR(idAutor),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);

CREATE TABLE ESTUDIANTE (
    idLector INT PRIMARY KEY,
    Nombre VARCHAR(100),
    Apellido VARCHAR(100),
    Direccion VARCHAR(200),
    Carrera VARCHAR(100),
    Edad INT
);

CREATE TABLE PRESTAMO (
    idLector INT,
    idLibro INT,
    FechaPrestamo DATE,
    FechaDevolucion DATE,
    Devuelto BOOLEAN,
    PRIMARY KEY (idLector, idLibro),
    FOREIGN KEY (idLector) REFERENCES ESTUDIANTE(idLector),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);

-- Insertar datos representativos

INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad) VALUES
(1, 'Gabriel García Márquez', 'Colombiana'),
(2, 'Mario Vargas Llosa', 'Peruana'),
(3, 'J.K. Rowling', 'Británica');

INSERT INTO LIBRO (idLibro, Titulo, Editorial, Area) VALUES
(1, 'Cien años de soledad', 'Editorial Sudamericana', 'Novela'),
(2, 'La ciudad y los perros', 'Editorial Planeta', 'Novela'),
(3, 'Harry Potter y la piedra filosofal', 'Editorial Salamandra', 'Fantasía');

INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES
(1, 1),
(2, 2),
(3, 3);

INSERT INTO ESTUDIANTE (idLector, Nombre, Apellido, Direccion, Carrera, Edad) VALUES
(1, 'Juan', 'Pérez', 'Calle Falsa 123', 'Ingeniería', 20),
(2, 'Ana', 'Gómez', 'Calle Ocho', 'Literatura', 21),
(3, 'Luis', 'Martínez', 'Avenida Siempre Viva 742', 'Historia', 22);

INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(1, 1, '2023-01-10', '2023-01-20', TRUE),
(2, 2, '2023-02-15', '2023-02-25', FALSE),
(3, 3, '2023-03-05', NULL, FALSE);

SELECT * FROM ESTUDIANTE;

-- Listar los datos de los autores.
SELECT * FROM AUTOR;

-- Listar nombre y edad de los estudiantes
SELECT Nombre, Edad FROM ESTUDIANTE;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM ESTUDIANTE
WHERE Carrera = 'Informática';

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM AUTOR
WHERE Nacionalidad = 'Francesa' OR 'Italiana';

-- ¿Qué libros no son del área de internet?
SELECT * FROM LIBRO
WHERE NOT Area = 'Internet';

-- Listar los libros de la editorial Salamandra.
SELECT * FROM LIBRO
WHERE Editorial = 'Editorial Salamandra';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM ESTUDIANTE
WHERE Edad > (SELECT AVG(EDAD) FROM ESTUDIANTE);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT Nombre 
FROM ESTUDIANTE
WHERE Apellido LIKE 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT * FROM AUTOR;
SELECT * FROM LIBROAUTOR;
SELECT * FROM LIBRO;

SELECT au.Nombre
FROM LIBROAUTOR la
JOIN AUTOR au ON la.idAutor = au.idAutor
JOIN LIBRO li ON la.idLibro = li.idLibro
WHERE li.Titulo = 'El Universo: Guía de viaje';

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT li.*
FROM PRESTAMO pr
JOIN ESTUDIANTE es ON es.idLector = pr.idLector
JOIN LIBRO li ON li.idLibro = pr.idLibro
WHERE es.Nombre = 'Filippo' AND es.Apellido = 'Galli';

-- Listar el nombre del estudiante de menor edad.
SELECT Nombre
FROM ESTUDIANTE
WHERE Edad = (SELECT MIN(Edad) FROM ESTUDIANTE);

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT es.Nombre
FROM PRESTAMO pr
JOIN ESTUDIANTE es ON es.idLector = pr.idLector;

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT li.*
FROM LIBROAUTOR la
JOIN AUTOR au ON la.idAutor = au.idAutor
JOIN LIBRO li ON la.idLibro = li.idLibro
WHERE au.Nombre = 'J.K. Rowling';

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT li.Titulo
FROM PRESTAMO pr
JOIN LIBRO li ON li.idLibro = pr.idLibro
WHERE pr.FechaDevolucion = '2021-07-16';
