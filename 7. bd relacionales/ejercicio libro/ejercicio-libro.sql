-- crear la BD
create database biblioteca;
use biblioteca;

-- Crear la tabla AUTOR
CREATE TABLE AUTOR (
    idAutor INT PRIMARY KEY,
    nombre VARCHAR(100),
    nacionalidad VARCHAR(50)
);

-- Crear la tabla LIBRO
CREATE TABLE LIBRO (
    idLibro INT PRIMARY KEY,
    titulo VARCHAR(255),
    editorial VARCHAR(100),
    area VARCHAR(100)
);

-- Crear la tabla LIBROAUTOR (relación muchos a muchos entre LIBRO y AUTOR)
CREATE TABLE LIBROAUTOR (
    idAutor INT,
    idLibro INT,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES AUTOR(idAutor),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);

-- Crear la tabla ESTUDIANTE
CREATE TABLE ESTUDIANTE (
    idLector INT PRIMARY KEY,
    Nombre VARCHAR(100),
    Apellido VARCHAR(100),
    Direccion VARCHAR(255),
    Carrera VARCHAR(100),
    Edad INT
);

-- Crear la tabla PRESTAMO
CREATE TABLE PRESTAMO (
    idLector INT,
    idLibro INT,
    FechaPrestamo DATETIME,
    FechaDevolucion DATETIME,
    Devuelto BOOLEAN,
    PRIMARY KEY (idLector, idLibro),
    FOREIGN KEY (idLector) REFERENCES ESTUDIANTE(idLector),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);

-- Insertar datos en la tabla AUTOR
INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad) VALUES
(1, 'Gabriel García Márquez', 'Colombiano'),
(2, 'J.K. Rowling', 'Británica'),
(3, 'Isabel Allende', 'Chilena'),
(4, 'Jose Luis Perez', 'Italiano');

-- Insertar datos en la tabla LIBRO
INSERT INTO LIBRO (idLibro, Titulo, Editorial, Area) VALUES
(1, 'Cien años de soledad', 'Editorial Sudamericana', 'Literatura'),
(2, 'Harry Potter y la piedra filosofal', 'Bloomsbury', 'Fantasía'),
(3, 'La casa de los espíritus', 'Plaza & Janés', 'Literatura'),
(4, 'Base de datos', 'Tecno', 'Tecnologia');

-- Insertar datos en la tabla LIBROAUTOR
INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES
(1, 1),  -- Gabriel García Márquez escribió 'Cien años de soledad'
(2, 2),  -- J.K. Rowling escribió 'Harry Potter y la piedra filosofal'
(3, 3),  -- Isabel Allende escribió 'La casa de los espíritus'
(1, 3),  -- Gabriel García Márquez también escribió 'La casa de los espíritus'
(4, 4);

-- Insertar datos en la tabla ESTUDIANTE
INSERT INTO ESTUDIANTE (idLector, Nombre, Apellido, Direccion, Carrera, Edad) VALUES
(1, 'Juan', 'Pérez', 'Calle 123', 'Literatura', 20),
(2, 'María', 'López', 'Avenida 456', 'Ingeniería', 22),
(3, 'Carlos', 'Fernández', 'Calle 789', 'Historia', 23),
(4, 'Jorge', 'Campos', 'Calle 518', 'Informatica', 17);

-- Insertar datos en la tabla PRESTAMO
INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES

(1, 1, '2023-10-01 10:00:00', '2024-07-16 10:00:00', FALSE), -- Juan presta 'Cien años de soledad'
(2, 2, '2023-10-02 11:00:00', '2024-10-01 10:00:00', FALSE), -- María presta 'Harry Potter y la piedra filosofal'
(3, 3, '2023-10-03 12:00:00', '2024-07-16 10:00:00', FALSE), -- Carlos presta 'La casa de los espíritus'
(4, 4, '2023-10-03 12:00:00', '2024-11-14 10:00:00', FALSE);

truncate prestamo;
-- ------------------------------------------------------------------------- 
-- Listar los datos de los autores.
select * from autor;

-- Listar nombre y edad de los estudiantes
select nombre, edad from estudiante;

-- ¿Qué estudiantes pertenecen a la carrera ingenieria?
select * from estudiante where carrera = "Ingenieria";

-- ¿Qué autores son de nacionalidad colombiano o chilena?
select * from autor where nacionalidad = "colombiano" or nacionalidad = "chilena";

-- ¿Qué libros no son del área de fantasia?
select * from libro where area = "fantasia";

-- Listar los libros de la editorial Sudamericana.
select * from libro where editorial = "Editorial Sudamericana";

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
select * from estudiante where edad > (select avg(edad) from estudiante);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select nombre, apellido from estudiante where apellido like "P%";

-- Listar los autores del libro “Cien años de soledad”. (Se debe listar solamente los nombres).
SELECT A.Nombre
FROM AUTOR A
JOIN LIBROAUTOR LA ON A.idAutor = LA.idAutor
JOIN LIBRO L ON LA.idLibro = L.idLibro
WHERE L.Titulo = 'Cien años de soledad'; 

-- ¿Qué libros se prestaron al lector “Carlos Fernandez”?
select l.* from libro l
join prestamo p on p.idLibro = l.idLibro
join estudiante e on e.idLector = p.idLector
where e.nombre = "Carlos" and e.apellido = "Fernández";

-- Listar el nombre del estudiante de menor edad.
select nombre from estudiante where edad < 18;

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
select e.nombre from estudiante e
join prestamo p on p.idLector = e.idLector
join libro l on l.idLibro = p.idLibro
where l.titulo = "Base de Datos";

-- Listar los libros que pertenecen a la autora J.K. Rowling.
select l.* from autor a
join libroautor la on a.idAutor = la.idAutor
join libro l on la.idLibro = l.idLibro
where a.nombre = "J.K. Rowling";

-- Listar títulos de los libros que debían devolverse el 16/07/2024.
select l.titulo from libro l
join prestamo p on l.idLibro = p.IdLibro
where p.fechaDevolucion like "2024-07-16 %";
