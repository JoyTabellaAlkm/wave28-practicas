-- Crear la tabla "Autor"
CREATE TABLE Autor (
    idAutor INT PRIMARY KEY,
    Nombre VARCHAR(100),
    Nacionalidad VARCHAR(50)
);
-- Crear la tabla "Libro"
CREATE TABLE Libro (
    idLibro INT PRIMARY KEY,
    Titulo VARCHAR(150),
    Editorial VARCHAR(100),
    Area VARCHAR(100)
);
-- Crear la tabla "Estudiante"
CREATE TABLE Estudiante (
    idLector INT PRIMARY KEY,
    Nombre VARCHAR(100),
    Apellido VARCHAR(100),
    Direccion VARCHAR(150),
    Carrera VARCHAR(50),
    Edad INT
);
-- Crear la tabla "LibroAutor"
CREATE TABLE LibroAutor (
    idAutor INT,
    idLibro INT,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES Autor(idAutor),
    FOREIGN KEY (idLibro) REFERENCES Libro(idLibro)
);
-- Crear la tabla "Prestamo"
CREATE TABLE Prestamo (
    idLector INT,
    idLibro INT,
    FechaPrestamo DATE,
    FechaDevolucion DATE,
    Devuelto BOOLEAN,
    PRIMARY KEY (idLector, idLibro, FechaPrestamo),
    FOREIGN KEY (idLector) REFERENCES Estudiante(idLector),
    FOREIGN KEY (idLibro) REFERENCES Libro(idLibro)
);
-- Insertar registros en la tabla "Autor"
INSERT INTO Autor (idAutor, Nombre, Nacionalidad) VALUES
(1, 'Simone Dubois', 'Francesa'),
(2, 'Giovanni Rossi', 'Italiana'),
(3, 'Isabel Allende', 'Chilena'),
(4, 'Mario Vargas Llosa', 'Peruana'),
(5, 'J.K. Rowling', 'Británica');
-- Insertar registros en la tabla "Libro"
INSERT INTO Libro (idLibro, Titulo, Editorial, Area) VALUES
(1, 'El Universo: Guía de viaje', 'Salamandra', 'Astronomía'),
(2, 'Cien años de soledad', 'Sudamericana', 'Base de datos'),
(3, 'Los pilares de la Tierra', 'Salamandra', 'Historia'),
(4, 'Harry Potter y la piedra filosofal', 'Bloomsbury', 'Fantasía'),
(5, 'Bases de datos relacionales', 'Salamandra', 'Informática');
-- Insertar registros en la tabla "Estudiante"
INSERT INTO Estudiante (idLector, Nombre, Apellido, Direccion, Carrera, Edad) VALUES
(1, 'Ana', 'López', 'Av. Siempre Viva 742', 'Ingeniería', 21),
(2, 'Carlos', 'Gómez', 'Calle Falsa 123', 'Informática', 23),
(3, 'Lucía', 'Giménez', 'Calle de la Luna 456', 'Arquitectura', 22),
(4, 'Javier', 'Rodríguez', 'Av. del Sol 789', 'Derecho', 24),
(5, 'Filippo', 'Galli', 'Pasaje del Viento 321', 'Informática', 20);
-- Insertar registros en la tabla "LibroAutor"
INSERT INTO LibroAutor (idAutor, idLibro) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 2),
(5, 4),
(5, 5);
-- Insertar registros en la tabla "Prestamo"
INSERT INTO Prestamo (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(1, 1, '2021-07-10', '2021-07-16', FALSE),
(2, 2, '2021-07-11', '2021-06-23', FALSE),
(3, 3, '2021-07-12', '2021-07-16', TRUE),
(5, 5, '2021-07-14', '2021-05-04', FALSE),
(5, 4, '2021-07-15', '2021-07-16', TRUE);


SELECT * FROM autor;

SELECT nombre,apellido, edad FROM estudiante;

SELECT nombre, carrera FROM estudiante WHERE carrera = "Informatica";

SELECT nombre, nacionalidad FROM autor WHERE nacionalidad = "Francesa" OR nacionalidad = "Italiana";

SELECT * FROM libro WHERE area != "Internet";

SELECT * FROM libro WHERE editorial = "Salamandra";

SELECT * FROM estudiante WHERE edad > (SELECT AVG(edad) FROM estudiante);

SELECT nombre, apellido FROM estudiante where apellido LIKE "G%";

SELECT a.nombre FROM autor a
	JOIN LibroAutor la
    ON a.idAutor = la.idAutor
    JOIN Libro l
    ON l.idLibro = la.idLibro
	WHERE l.titulo = "El Universo: Guía de viaje";

SELECT l.titulo FROM Libro l
	 JOIN Prestamo p
	 ON p.idLibro = l.idLibro
	 JOIN Estudiante e
	 ON e.idLector = p.idLector
	 WHERE e.Nombre = "Filippo" AND e.apellido = "Galli";


SELECT nombre FROM estudiante WHERE	edad = (SELECT min(edad) FROM estudiante);

SELECT e.nombre FROM Libro l
	 JOIN Prestamo p
	 ON p.idLibro = l.idLibro
	 JOIN Estudiante e
	 ON e.idLector = p.idLector
	 WHERE l.Area = "Base de datos";


SELECT l.titulo FROM libro l
	JOIN LibroAutor la
    ON la.idLibro = l.idLibro
	JOIN autor a
    ON a.idAutor = la.idAutor
	WHERE a.Nombre = 'J.K. Rowling';

SELECT l.titulo FROM libro l
	JOIN prestamo p
    ON l.idLibro = p.idLibro
	WHERE p.fechaDevolucion = '2021-07-16';
