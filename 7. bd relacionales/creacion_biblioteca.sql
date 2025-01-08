DROP DATABASE IF EXISTS Biblioteca;
create DATABASE Biblioteca;
use Biblioteca;
CREATE TABLE Autor(
idAutor int auto_increment PRIMARY KEY,
nombre varchar(30),
nacionalidad varchar(15)
);

CREATE TABLE Libro(
idLibro int auto_increment PRIMARY KEY,
titulo varchar(100),
editorial varchar(50),
area varchar (40)
);

CREATE TABLE LibroAutor(
idAutor int,
foreign key (idAutor) references Autor(idAutor),
idLibro int,
foreign key (idLibro) references Libro(idLibro)
);

CREATE TABLE Estudiante(
idLector int auto_increment PRIMARY KEY,
nombre varchar(20),
apellido varchar(20),
direccion varchar(40),
carrera varchar(20),
edad int
);

CREATE TABLE Prestamo(
idLector int,
foreign key (idLector) references Estudiante(idLector),
idLibro int,
foreign key (idLibro) references Libro(idLibro),
fechaPrestamo date,
fechaDevolucion date,
devuelto boolean
);

INSERT INTO Autor (nombre, nacionalidad) VALUES
('J.K. Rowling', 'Británica'),
('Dan Brown', 'Estadounidense'),
('Antoine de Saint-Exupéry', 'Francesa'),
('Umberto Eco', 'Italiana'),
('Gabriel García Márquez', 'Colombiana');

INSERT INTO Libro (titulo, editorial, area) VALUES
('Harry Potter y la piedra filosofal', 'Salamandra', 'Fantasía'),
('El Código Da Vinci', 'Random House', 'Misterio'),
('El Principito', 'Gallimard', 'Fantasía'),
('El Nombre de la Rosa', 'Bompiani', 'Historia'),
('Cien años de soledad', 'Sudamericana', 'Literatura'),
('El Universo: Guía de viaje', 'AstroPress', 'Ciencia'),
('Introducción a Base de Datos', 'McGraw-Hill', 'Base de Datos'),
('Internet para principiantes', 'Salamandra', 'Internet');

INSERT INTO LibroAutor (idAutor, idLibro) VALUES
(1, 1), -- J.K. Rowling -> Harry Potter
(2, 2), -- Dan Brown -> El Código Da Vinci
(3, 3), -- Antoine -> El Principito
(4, 4), -- Umberto Eco -> El Nombre de la Rosa
(5, 5), -- García Márquez -> Cien años de soledad
(3, 6), -- Antoine -> El Universo: Guía de viaje
(1, 7), -- J.K. Rowling -> Introducción a Base de Datos
(1, 8); -- J.K. Rowling -> Internet para principiantes

INSERT INTO Estudiante (nombre, apellido, direccion, carrera, edad) VALUES
('Juan', 'García', 'Calle Falsa 123', 'Informática', 21),
('Ana', 'González', 'Av. Siempre Viva 456', 'Matemática', 22),
('Filippo', 'Galli', 'Via Roma 32', 'Informática', 23),
('María', 'López', 'Plaza Mayor 7', 'Informática', 20),
('Laura', 'Gómez', 'Calle Luna 8', 'Literatura', 24);

INSERT INTO Prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES
(1, 1, '2021-07-10', '2021-07-16', true), -- Juan -> Harry Potter
(2, 7, '2021-07-11', '2021-07-16', false), -- Ana -> Introducción a Base de Datos
(3, 5, '2021-07-12', '2021-07-20', true), -- Filippo -> Cien años de soledad
(3, 2, '2021-07-13', '2021-07-18', true), -- Filippo -> El Código Da Vinci
(4, 6, '2021-07-14', '2021-07-16', false), -- María -> El Universo: Guía de viaje
(5, 8, '2021-07-15', '2021-07-20', true); -- Laura -> Internet para principiantes
