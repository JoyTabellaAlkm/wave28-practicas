-- Crear tabla DEPARTAMENTO
CREATE TABLE DEPARTAMENTO (
    depto_nro CHAR(6) PRIMARY KEY,
    nombre_depto VARCHAR(50),
    localidad VARCHAR(50)
);
-- Insertar datos en DEPARTAMENTO
INSERT INTO DEPARTAMENTO (depto_nro, nombre_depto, localidad) VALUES
('D-0001', 'Software', 'Los Tigres'),
('D-0002', 'Sistemas', 'Guadalupe'),
('D-0003', 'Contabilidad', 'La Roca'),
('D-0004', 'Ventas', 'Plata');
-- Crear tabla EMPLEADO
CREATE TABLE EMPLEADO (
    cod_emp CHAR(6) PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    puesto VARCHAR(50),
    fecha_alta DATE,
    salario DECIMAL(10, 2),
    comision DECIMAL(10, 2),
    depto_nro CHAR(6),
    FOREIGN KEY (depto_nro) REFERENCES DEPARTAMENTO(depto_nro)
);
-- Insertar datos en EMPLEADO
INSERT INTO EMPLEADO (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-0004'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-0002'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-0003'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-0004'),
('E-0005', 'Daniel', 'Brezezciki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-0004'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-0003'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-0001');


-- Primero
SELECT em.nombre, em.puesto, dep.localidad FROM empleado em INNER JOIN departamento dep ON em.depto_nro = dep.depto_nro WHERE dep.nombre_depto = "Ventas";
-- Segundo
SELECT nombre_depto FROM departamento dep INNER JOIN empleado em ON em.depto_nro = dep.depto_nro GROUP BY dep.depto_nro HAVING count(*) > 5;
-- Tercero
SELECT em.nombre, em.salario, dep.nombre_depto FROM empleado em INNER JOIN departamento dep ON
em.depto_nro = dep.depto_nro WHERE em.puesto IN (SELECT puesto FROM empleado WHERE nombre = "Mito" && apellido="Barchuk");
-- Cuarto
SELECT em.* FROM empleado em INNER JOIN departamento dep ON em.depto_nro = dep.depto_nro WHERE dep.nombre_depto = "contabilidad" ORDER BY em.nombre;
 -- Quinto
SELECT nombre, salario FROM empleado WHERE salario = (SELECT MIN(salario) FROM empleado);
-- Sexto
SELECT * FROM empleado WHERE salario =
(SELECT MAX(salario) FROM departamento AS dp
INNER JOIN empleado AS emp ON
 emp.depto_nro = dp.depto_nro WHERE dp.nombre_depto = "Ventas");



El query para las tablas y rellenar:
-- Tabla AUTOR
CREATE TABLE AUTOR (
    idAutor INT PRIMARY KEY,
    Nombre VARCHAR(100),
    Nacionalidad VARCHAR(50)
);
-- Tabla LIBRO
CREATE TABLE LIBRO (
    idLibro INT PRIMARY KEY,
    Titulo VARCHAR(200),
    Editorial VARCHAR(100),
    Area VARCHAR(50)
);
-- Tabla ESTUDIANTE
CREATE TABLE ESTUDIANTE (
    idLector INT PRIMARY KEY,
    Nombre VARCHAR(100),
    Apellido VARCHAR(100),
    Direccion VARCHAR(200),
    Carrera VARCHAR(100),
    Edad INT
);
-- Tabla PRESTAMO
CREATE TABLE PRESTAMO (
    idLector INT,
    idLibro INT,
    FechaPrestamo DATE,
    FechaDevolucion DATE,
    Devuelto BOOLEAN,
    PRIMARY KEY (idLector, idLibro, FechaPrestamo),
    FOREIGN KEY (idLector) REFERENCES ESTUDIANTE(idLector),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);
-- Tabla LIBROAUTOR
CREATE TABLE LIBROAUTOR (
    idAutor INT,
    idLibro INT,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES AUTOR(idAutor),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);
-- Insertar datos en AUTOR
INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad) VALUES
(1, 'Gabriel Garcia Marquez', 'Colombiana'),
(2, 'Isabel Allende', 'Chilena');
-- Insertar datos en LIBRO
INSERT INTO LIBRO (idLibro, Titulo, Editorial, Area) VALUES
(1, 'Cien años de soledad', 'Editorial A', 'Ficción'),
(2, 'La casa de los espíritus', 'Editorial B', 'Novela');
-- Insertar datos en ESTUDIANTE
INSERT INTO ESTUDIANTE (idLector, Nombre, Apellido, Direccion, Carrera, Edad) VALUES
(1, 'Juan', 'Pérez', 'Calle Falsa 123', 'Ingeniería', 21),
(2, 'Ana', 'Gómez', 'Av. Siempre Viva 742', 'Medicina', 22);
-- Insertar datos en LIBROAUTOR
INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES
(1, 1),
(2, 2);
-- Insertar datos en PRESTAMO
INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(1, 1, '2023-01-10', '2023-01-20', FALSE),
(2, 2, '2023-02-05', '2023-03-01', TRUE);


-- Primero
SELECT * FROM autor;
-- Segundo
SELECT nombre, edad FROM estudiante;
-- Tercero
SELECT * FROM estudiante WHERE carrera = "Informatica";
-- Cuarto
SELECT * FROM autor WHERE nacionalidad IN ("Francesa", "Italiana");
-- Quinta
SELECT * FROM libro WHERE area != "Internet";
-- Sexta
SELECT * FROM libro WHERE editorial = "Salamandra";
-- Septima
SELECT * FROM estudiante WHERE edad > (SELECT AVG(edad) FROM estudiante);
-- Octava
SELECT * FROM estudiante WHERE apellido LIKE "G%";
-- Novena
SELECT autor.nombre FROM libro INNER JOIN libroautor ON libroautor.idLibro = libro.idLibro
INNER JOIN autor ON libroautor.idAutor = autor.idAutor WHERE libro.titulo = "El Universo: Guía de viaje";
-- Decimo
SELECT titulo FROM libro INNER JOIN prestamo ON libro.idLibro = prestamo.idLibro
INNER JOIN estudiante ON prestamo.idLector = estudiante.idLector WHERE estudiante.nombre = "Filippo" AND
estudiante.apellido = "Galli";
-- Once
SELECT nombre FROM estudiante WHERE edad = (SELECT MIN(edad) FROM estudiante)
-- Doceabo
SELECT estudiante.nombre FROM libro INNER JOIN prestamo ON libro.idLibro = prestamo.idLibro INNER JOIN estudiante ON prestamo.idLector = estudiante.idLector;
--treceavo
SELECT libro.nombre FROM libro INNER JOIN libroautor ON libroautor.idLibro = libro.idLibro
INNER JOIN autor ON libroautor.idAutor = autor.idAutor WHERE autor.nombre = "J.K. Rowling";
--catorceavo
SELECT estudiante.nombre FROM libro INNER JOIN prestamo ON libro.idLibro = prestamo.idLibro WHERE prestamo.FechaDevolucion = '16-07-2021'