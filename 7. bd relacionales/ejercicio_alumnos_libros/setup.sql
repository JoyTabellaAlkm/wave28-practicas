-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema alumnos_libros
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `alumnos_libros` ;

-- -----------------------------------------------------
-- Schema alumnos_libros
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `alumnos_libros` DEFAULT CHARACTER SET utf8 ;
USE `alumnos_libros` ;

-- -----------------------------------------------------
-- Table `alumnos_libros`.`libro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `alumnos_libros`.`libro` ;

CREATE TABLE IF NOT EXISTS `alumnos_libros`.`libro` (
  `id_libro` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `editorial` VARCHAR(45) NOT NULL,
  `area` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_libro`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `alumnos_libros`.`autor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `alumnos_libros`.`autor` ;

CREATE TABLE IF NOT EXISTS `alumnos_libros`.`autor` (
  `id_autor` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `nacionalidad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_autor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `alumnos_libros`.`libro_autor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `alumnos_libros`.`libro_autor` ;

CREATE TABLE IF NOT EXISTS `alumnos_libros`.`libro_autor` (
  `id_libro_autor` INT NOT NULL AUTO_INCREMENT,
  `id_libro` INT NOT NULL,
  `id_autor` INT NOT NULL,
  PRIMARY KEY (`id_libro_autor`),
  INDEX `fk_libro_autor_libro_idx` (`id_libro` ASC) VISIBLE,
  INDEX `fk_libro_autor_autor1_idx` (`id_autor` ASC) VISIBLE,
  CONSTRAINT `fk_libro_autor_libro`
    FOREIGN KEY (`id_libro`)
    REFERENCES `alumnos_libros`.`libro` (`id_libro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_libro_autor_autor1`
    FOREIGN KEY (`id_autor`)
    REFERENCES `alumnos_libros`.`autor` (`id_autor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `alumnos_libros`.`estudiante`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `alumnos_libros`.`estudiante` ;

CREATE TABLE IF NOT EXISTS `alumnos_libros`.`estudiante` (
  `id_estudiante` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `carrera` VARCHAR(45) NOT NULL,
  `edad` SMALLINT NOT NULL,
  PRIMARY KEY (`id_estudiante`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `alumnos_libros`.`prestamo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `alumnos_libros`.`prestamo` ;

CREATE TABLE IF NOT EXISTS `alumnos_libros`.`prestamo` (
  `id_prestamo` INT NOT NULL AUTO_INCREMENT,
  `id_libro` INT NOT NULL,
  `id_estudiante` INT NOT NULL,
  `fec_prestamo` DATE NOT NULL,
  `fec_devolucion` DATE NULL,
  `devuelto` TINYINT NOT NULL,
  PRIMARY KEY (`id_prestamo`),
  INDEX `fk_prestamo_libro1_idx` (`id_libro` ASC) VISIBLE,
  INDEX `fk_prestamo_estudiante1_idx` (`id_estudiante` ASC) VISIBLE,
  CONSTRAINT `fk_prestamo_libro1`
    FOREIGN KEY (`id_libro`)
    REFERENCES `alumnos_libros`.`libro` (`id_libro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_prestamo_estudiante1`
    FOREIGN KEY (`id_estudiante`)
    REFERENCES `alumnos_libros`.`estudiante` (`id_estudiante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

use alumnos_libros;
-- ==== INSERTS ====
-- ESTUDIANTE
INSERT INTO estudiante VALUES (1, "Pepe", "Argento", "Av. Libertador 1440", "Arquitectura", 35);
INSERT INTO estudiante VALUES (2, "Ana", "Martínez", "Calle Ficticia 123", "Ingeniería Informática", 22);
INSERT INTO estudiante VALUES (3, "Luis", "Gómez", "Avenida del Sol 789", "Medicina", 27);
INSERT INTO estudiante VALUES (4, "Carlos", "Pérez", "Calle Argentina 456", "Derecho", 24);
INSERT INTO estudiante VALUES (5, "Sofía", "López", "Calle 9 de Julio 321", "Psicología", 30);
INSERT INTO estudiante VALUES (6, "Mariana", "Rodríguez", "Avenida San Martín 234", "Biología", 26);
INSERT INTO estudiante VALUES (7, "Javier", "Sánchez", "Calle Los Andes 654", "Economía", 28);
INSERT INTO estudiante VALUES (8, "Laura", "Torres", "Calle del Río 876", "Filosofía", 23);
INSERT INTO estudiante VALUES (9, "Federico", "Gutiérrez", "Calle Gran Via 567", "Literatura", 32);
INSERT INTO estudiante VALUES (10, "Martín", "Hernández", "Avenida Libertador 890", "Diseño Gráfico", 25);
INSERT INTO estudiante VALUES (11, "Gabriela", "Díaz", "Calle de la Luna 101", "Arquitectura", 29);
-- LIBRO
INSERT INTO libro VALUES (1, "Harry Potter: La piedra filosofal", "Santillana", "Ficción");
INSERT INTO libro VALUES (2, "El Hobbit", "Editorial Minotauro", "Fantasía");
INSERT INTO libro VALUES (3, "Cien años de soledad", "Editorial Sudamericana", "Realismo mágico");
INSERT INTO libro VALUES (4, "1984", "Editorial Secker & Warburg", "Distopía");
INSERT INTO libro VALUES (5, "Matar a un ruiseñor", "Editorial HarperCollins", "Ficción");
INSERT INTO libro VALUES (6, "Don Quijote de la Mancha", "Editorial Espasa Calpe", "Clásico");
INSERT INTO libro VALUES (7, "Orgullo y prejuicio", "Editorial Planeta", "Romántico");
INSERT INTO libro VALUES (8, "La sombra del viento", "Editorial Planeta", "Misterio");
INSERT INTO libro VALUES (9, "El nombre del viento", "Editorial Plaza & Janés", "Fantasía épica");
INSERT INTO libro VALUES (10, "Los pilares de la Tierra", "Editorial B", "Histórico");
INSERT INTO libro VALUES (11, "Crónica de una muerte anunciada", "Editorial Norma", "Realismo mágico");
INSERT INTO libro VALUES (12, "La casa de los espíritus", "Editorial Plaza & Janés", "Fantasía realista");
INSERT INTO libro VALUES (13, "La tregua", "Editorial Seix Barral", "Ficción");
INSERT INTO libro VALUES (14, "El alquimista", "Editorial Planeta", "Filosofía");
INSERT INTO libro VALUES (15, "El psicoanalista", "Editorial Ediciones B", "Thriller psicológico");
INSERT INTO libro VALUES (16, "Cumbres borrascosas", "Editorial Bruguera", "Romántico");
INSERT INTO libro VALUES (17, "El gran Gatsby", "Editorial Penguin Books", "Ficción");
INSERT INTO libro VALUES (18, "Ana Karenina", "Editorial Alba", "Drama");
INSERT INTO libro VALUES (19, "Los hermanos Karamazov", "Editorial Gredos", "Filosofía");
INSERT INTO libro VALUES (20, "Fahrenheit 451", "Editorial Ray Bradbury", "Ciencia ficción");
INSERT INTO libro VALUES (21, "La metamorfosis", "Editorial Acantilado", "Ficción");
INSERT INTO libro VALUES (22, "En busca del tiempo perdido", "Editorial La Pléiade", "Literatura clásica");
INSERT INTO libro VALUES (23, "El retrato de Dorian Gray", "Editorial Debolsillo", "Filosofía");
INSERT INTO libro VALUES (24, "La ciudad y los perros", "Editorial Seix Barral", "Novela contemporánea");
INSERT INTO libro VALUES (25, "Un mundo feliz", "Editorial Vintage", "Ciencia ficción");
INSERT INTO libro VALUES (26, "La ladrona de libros", "Editorial Zafiro", "Histórico");
INSERT INTO libro VALUES (27, "El código Da Vinci", "Editorial Planeta", "Misterio");
INSERT INTO libro VALUES (28, "Las aventuras de Sherlock Holmes", "Editorial Bruguera", "Detectivesco");
INSERT INTO libro VALUES (29, "Las mil y una noches", "Editorial Akal", "Fábulas");
INSERT INTO libro VALUES (30, "La isla del tesoro", "Editorial Salamandra", "Aventura");
INSERT INTO libro VALUES (31, "El último encuentro", "Editorial Lumen", "Drama");
INSERT INTO libro VALUES (32, "El círculo", "Editorial Maeva", "Distopía");
INSERT INTO libro VALUES (33, "Veinte mil leguas de viaje submarino", "Editorial Juventud", "Aventura");
INSERT INTO libro VALUES (34, "La divina comedia", "Editorial Cátedra", "Poesía épica");
INSERT INTO libro VALUES (35, "El diario de Ana Frank", "Editorial Memorias", "Autobiografía");
INSERT INTO libro VALUES (36, "En el camino", "Editorial Anagrama", "Literatura beat");
INSERT INTO libro VALUES (37, "Sapiens: De animales a dioses", "Editorial Debate", "No ficción");
INSERT INTO libro VALUES (38, "La peste", "Editorial Gallimard", "Filosofía existencialista");
INSERT INTO libro VALUES (39, "La guerra de los mundos", "Editorial Pinguin Classics", "Ciencia ficción");
INSERT INTO libro VALUES (40, "Ulises", "Editorial Oxford", "Modernismo");
-- AUTOR
INSERT INTO autor VALUES (1, "J.R.R. Tolkien", "Reino Unido");
INSERT INTO autor VALUES (2, "Gabriel García Márquez", "Colombia");
INSERT INTO autor VALUES (3, "George Orwell", "Reino Unido");
INSERT INTO autor VALUES (4, "Harper Lee", "Estados Unidos");
INSERT INTO autor VALUES (5, "Miguel de Cervantes", "España");
INSERT INTO autor VALUES (6, "Jane Austen", "Reino Unido");
INSERT INTO autor VALUES (7, "Carlos Ruiz Zafón", "España");
INSERT INTO autor VALUES (8, "Patrick Rothfuss", "Estados Unidos");
INSERT INTO autor VALUES (9, "Ken Follett", "Reino Unido");
INSERT INTO autor VALUES (10, "Gabriel García Márquez", "Colombia");
INSERT INTO autor VALUES (11, "Isabel Allende", "Chile");
INSERT INTO autor VALUES (12, "Mario Benedetti", "Uruguay");
INSERT INTO autor VALUES (13, "Paulo Coelho", "Brasil");
INSERT INTO autor VALUES (14, "John Katzenbach", "Estados Unidos");
INSERT INTO autor VALUES (15, "Emily Brontë", "Reino Unido");
INSERT INTO autor VALUES (16, "F. Scott Fitzgerald", "Estados Unidos");
INSERT INTO autor VALUES (17, "León Tolstói", "Rusia");
INSERT INTO autor VALUES (18, "Fiódor Dostoyevski", "Rusia");
INSERT INTO autor VALUES (19, "Ray Bradbury", "Estados Unidos");
INSERT INTO autor VALUES (20, "Franz Kafka", "República Checa");
INSERT INTO autor VALUES (21, "Marcel Proust", "Francia");
INSERT INTO autor VALUES (22, "Oscar Wilde", "Irlanda");
INSERT INTO autor VALUES (23, "Mario Vargas Llosa", "Perú");
INSERT INTO autor VALUES (24, "Aldous Huxley", "Reino Unido");
INSERT INTO autor VALUES (25, "Markus Zusak", "Australia");
INSERT INTO autor VALUES (26, "Dan Brown", "Estados Unidos");
INSERT INTO autor VALUES (27, "Arthur Conan Doyle", "Reino Unido");
INSERT INTO autor VALUES (28, "Anónimo", "Desconocido");
INSERT INTO autor VALUES (29, "Robert Louis Stevenson", "Reino Unido");
INSERT INTO autor VALUES (30, "Sándor Márai", "Hungría");
INSERT INTO autor VALUES (31, "Dave Eggers", "Estados Unidos");
INSERT INTO autor VALUES (32, "Yuval Noah Harari", "Israel");
INSERT INTO autor VALUES (33, "Albert Camus", "Francia");
INSERT INTO autor VALUES (34, "H.G. Wells", "Reino Unido");
INSERT INTO autor VALUES (35, "James Joyce", "Irlanda");
INSERT INTO autor VALUES (36, "J.K. Rowling", "Inglaterra");
-- LIBRO_AUTOR
INSERT INTO libro_autor (id_libro, id_autor) VALUES (1, 36);  -- "Harry Potter: La piedra filosofal" - J.K Rowling
INSERT INTO libro_autor (id_libro, id_autor) VALUES (2, 1);   -- "El Hobbit" - J.R.R. Tolkien
INSERT INTO libro_autor (id_libro, id_autor) VALUES (3, 2);   -- "Cien años de soledad" - Gabriel García Márquez
INSERT INTO libro_autor (id_libro, id_autor) VALUES (4, 3);   -- "1984" - George Orwell
INSERT INTO libro_autor (id_libro, id_autor) VALUES (5, 4);   -- "Matar a un ruiseñor" - Harper Lee
INSERT INTO libro_autor (id_libro, id_autor) VALUES (6, 5);   -- "Don Quijote de la Mancha" - Miguel de Cervantes
INSERT INTO libro_autor (id_libro, id_autor) VALUES (7, 6);   -- "Orgullo y prejuicio" - Jane Austen
INSERT INTO libro_autor (id_libro, id_autor) VALUES (8, 7);   -- "La sombra del viento" - Carlos Ruiz Zafón
INSERT INTO libro_autor (id_libro, id_autor) VALUES (9, 8);   -- "El nombre del viento" - Patrick Rothfuss
INSERT INTO libro_autor (id_libro, id_autor) VALUES (10, 9);  -- "Los pilares de la Tierra" - Ken Follett
INSERT INTO libro_autor (id_libro, id_autor) VALUES (11, 2);  -- "Crónica de una muerte anunciada" - Gabriel García Márquez
INSERT INTO libro_autor (id_libro, id_autor) VALUES (12, 11); -- "La casa de los espíritus" - Isabel Allende
INSERT INTO libro_autor (id_libro, id_autor) VALUES (13, 12); -- "La tregua" - Mario Benedetti
INSERT INTO libro_autor (id_libro, id_autor) VALUES (14, 13); -- "El alquimista" - Paulo Coelho
INSERT INTO libro_autor (id_libro, id_autor) VALUES (15, 14); -- "El psicoanalista" - John Katzenbach
INSERT INTO libro_autor (id_libro, id_autor) VALUES (16, 15); -- "Cumbres borrascosas" - Emily Brontë
INSERT INTO libro_autor (id_libro, id_autor) VALUES (17, 16); -- "El gran Gatsby" - F. Scott Fitzgerald
INSERT INTO libro_autor (id_libro, id_autor) VALUES (18, 17); -- "Ana Karenina" - León Tolstói
INSERT INTO libro_autor (id_libro, id_autor) VALUES (19, 18); -- "Los hermanos Karamazov" - Fiódor Dostoyevski
INSERT INTO libro_autor (id_libro, id_autor) VALUES (20, 19); -- "Fahrenheit 451" - Ray Bradbury
INSERT INTO libro_autor (id_libro, id_autor) VALUES (21, 20); -- "La metamorfosis" - Franz Kafka
INSERT INTO libro_autor (id_libro, id_autor) VALUES (22, 21); -- "En busca del tiempo perdido" - Marcel Proust
INSERT INTO libro_autor (id_libro, id_autor) VALUES (23, 22); -- "El retrato de Dorian Gray" - Oscar Wilde
INSERT INTO libro_autor (id_libro, id_autor) VALUES (24, 23); -- "La ciudad y los perros" - Mario Vargas Llosa
INSERT INTO libro_autor (id_libro, id_autor) VALUES (25, 24); -- "Un mundo feliz" - Aldous Huxley
INSERT INTO libro_autor (id_libro, id_autor) VALUES (26, 25); -- "La ladrona de libros" - Markus Zusak
INSERT INTO libro_autor (id_libro, id_autor) VALUES (27, 26); -- "El código Da Vinci" - Dan Brown
INSERT INTO libro_autor (id_libro, id_autor) VALUES (28, 27); -- "Las aventuras de Sherlock Holmes" - Arthur Conan Doyle
INSERT INTO libro_autor (id_libro, id_autor) VALUES (29, 28); -- "Las mil y una noches" - Anónimo
INSERT INTO libro_autor (id_libro, id_autor) VALUES (30, 29); -- "La isla del tesoro" - Robert Louis Stevenson
INSERT INTO libro_autor (id_libro, id_autor) VALUES (31, 30); -- "El último encuentro" - Sándor Márai
INSERT INTO libro_autor (id_libro, id_autor) VALUES (32, 31); -- "El círculo" - Dave Eggers
INSERT INTO libro_autor (id_libro, id_autor) VALUES (33, 32); -- "Veinte mil leguas de viaje submarino" - Jules Verne
INSERT INTO libro_autor (id_libro, id_autor) VALUES (34, 33); -- "La divina comedia" - Dante Alighieri
INSERT INTO libro_autor (id_libro, id_autor) VALUES (35, 34); -- "El diario de Ana Frank" - Ana Frank
INSERT INTO libro_autor (id_libro, id_autor) VALUES (36, 35); -- "En el camino" - Jack Kerouac
INSERT INTO libro_autor (id_libro, id_autor) VALUES (37, 36); -- "Sapiens: De animales a dioses" - Yuval Noah Harari
INSERT INTO libro_autor (id_libro, id_autor) VALUES (38, 37); -- "La peste" - Albert Camus
INSERT INTO libro_autor (id_libro, id_autor) VALUES (39, 38); -- "La guerra de los mundos" - H.G. Wells
INSERT INTO libro_autor (id_libro, id_autor) VALUES (40, 39); -- "Ulises" - James Joyce
-- prestamo
INSERT INTO prestamo (id_libro, id_estudiante, fec_prestamo, fec_devolucion, devuelto) VALUES
(1, 1, '2023-09-01', '2023-09-15', 1),
(2, 2, '2023-09-05', '2023-09-20', 1),
(3, 3, '2023-09-10', '2023-09-25', 1),
(4, 4, '2023-09-12', '2023-09-26', 1),
(5, 5, '2023-09-14', '2023-09-28', 1),
(6, 6, '2023-09-16', '2023-09-30', 1),
(7, 7, '2023-09-18', '2023-10-02', 1),
(8, 8, '2023-09-20', '2023-10-04', 1),
(9, 9, '2023-09-22', '2023-10-06', 1),
(10, 10, '2023-09-24', '2023-10-08', 1),
(11, 11, '2023-09-26', '2023-10-10', 1),
(1, 1, '2023-09-28', '2023-10-12', 1),
(2, 2, '2023-09-30', '2023-10-14', 1),
(3, 3, '2023-10-02', '2023-10-16', 1),
(4, 4, '2023-10-04', '2023-10-18', 1),
(5, 5, '2023-10-06', '2023-10-20', 1),
(6, 6, '2023-10-08', '2023-10-22', 1),
(7, 7, '2023-10-10', '2023-10-24', 1),
(8, 8, '2023-10-12', '2023-10-26', 1),
(9, 9, '2023-10-14', '2023-10-28', 1),
(10, 10, '2023-10-16', '2023-10-30', 1),
(11, 11, '2023-10-18', '2023-11-01', 1),
(1, 1, '2023-10-20', '2023-11-03', 1),
(2, 2, '2023-10-22', '2023-11-06', 1),
(3, 3, '2023-10-24', '2023-11-08', 1),
(4, 4, '2023-10-26', '2023-11-10', 1),
(5, 5, '2023-10-28', '2023-11-12', 1),
(6, 6, '2023-10-30', '2023-11-14', 1),
(7, 7, '2023-11-01', '2023-11-15', 1),
(8, 8, '2023-11-03', '2023-11-17', 1),
(9, 9, '2023-11-05', '2023-11-19', 1),
(10, 10, '2023-11-07', '2023-11-21', 1),
(11, 11, '2023-11-09', '2023-11-23', 1),
(1, 1, '2023-11-11', '2023-11-25', 1),
(2, 2, '2023-11-13', '2023-11-27', 1),
(3, 3, '2023-11-15', '2023-11-29', 1),
(4, 4, '2023-11-17', '2023-12-01', 1),
(5, 5, '2023-11-19', '2023-12-03', 1),
(6, 6, '2023-11-21', '2023-12-05', 1),
(7, 7, '2023-11-23', '2023-12-07', 1),
(8, 8, '2023-11-25', '2023-12-09', 1),
(9, 9, '2023-11-27', '2023-12-11', 1),
(10, 10, '2023-11-29', '2023-12-13', 1),
(11, 11, '2023-12-01', '2023-12-15', 1),
(1, 1, '2023-12-03', '2023-12-17', 1),
(2, 2, '2023-12-05', '2023-12-19', 1),
(3, 3, '2023-12-07', '2023-12-21', 1),
(4, 4, '2023-12-09', '2023-12-23', 1),
(5, 5, '2023-12-11', '2023-12-25', 1),
(6, 6, '2023-12-13', '2023-12-27', 1),
(7, 7, '2023-12-15', '2023-12-29', 1),
(8, 8, '2023-12-17', '2023-12-31', 1),
(9, 9, '2023-12-19', '2024-01-02', 1),
(10, 10, '2023-12-21', '2024-01-04', 1),
(11, 11, '2023-12-23', '2024-01-06', 1),
(1, 1, '2023-12-25', '2024-01-08', 1),
(2, 2, '2023-12-27', '2024-01-10', 1),
(3, 3, '2023-12-29', '2024-01-12', 1),
(4, 4, '2024-01-02', '2024-01-14', 1),
(5, 5, '2024-01-04', '2024-01-16', 1),
(6, 6, '2024-01-06', '2024-01-18', 1),
(7, 7, '2024-01-08', '2024-01-20', 1),
(8, 8, '2024-01-10', '2024-01-22', 1),
(9, 9, '2024-01-12', '2024-01-24', 1),
(10, 10, '2024-01-14', '2024-01-26', 1),
(11, 11, '2024-01-16', '2024-01-28', 1),
(1, 1, '2024-01-18', NULL, 0),
(2, 2, '2024-01-20', NULL, 0),
(3, 3, '2024-01-22', NULL, 0),
(4, 4, '2024-01-24', NULL, 0),
(5, 5, '2024-01-26', NULL, 0),
(6, 6, '2024-01-28', NULL, 0),
(7, 7, '2024-01-30', NULL, 0),
(8, 8, '2024-02-01', NULL, 0),
(9, 9, '2024-02-03', NULL, 0),
(10, 10, '2024-02-05', NULL, 0),
(11, 11, '2024-02-07', NULL, 0),
(1, 1, '2024-02-09', NULL, 0),
(2, 2, '2024-02-11', NULL, 0),
(3, 3, '2024-02-13', NULL, 0),
(4, 4, '2024-02-15', NULL, 0),
(5, 5, '2024-02-17', NULL, 0),
(6, 6, '2024-02-19', NULL, 0),
(7, 7, '2024-02-21', NULL, 0),
(8, 8, '2024-02-23', NULL, 0),
(9, 9, '2024-02-25', NULL, 0),
(10, 10, '2024-02-27', NULL, 0),
(11, 11, '2024-02-29', NULL, 0); 
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
