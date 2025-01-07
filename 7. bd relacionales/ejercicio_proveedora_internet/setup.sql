-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema empresa_internet
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `empresa_internet` ;

-- -----------------------------------------------------
-- Schema empresa_internet
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `empresa_internet` DEFAULT CHARACTER SET utf8 ;
USE `empresa_internet` ;

-- -----------------------------------------------------
-- Table `empresa_internet`.`plan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `empresa_internet`.`plan` ;

CREATE TABLE IF NOT EXISTS `empresa_internet`.`plan` (
  `id_plan` INT NOT NULL AUTO_INCREMENT,
  `vel_megabits_por_sec` VARCHAR(8) NOT NULL,
  `precio` DOUBLE NOT NULL,
  `descuento` DECIMAL(5,2) NULL,
  PRIMARY KEY (`id_plan`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empresa_internet`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `empresa_internet`.`cliente` ;

CREATE TABLE IF NOT EXISTS `empresa_internet`.`cliente` (
  `dni` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `fec_nacimiento` DATE NOT NULL,
  `provincia` VARCHAR(45) NOT NULL,
  `ciudad` VARCHAR(45) NOT NULL,
  `id_plan` INT NOT NULL,
  PRIMARY KEY (`dni`),
  INDEX `fk_cliente_plan_idx` (`id_plan` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_plan`
    FOREIGN KEY (`id_plan`)
    REFERENCES `empresa_internet`.`plan` (`id_plan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `empresa_internet`.`plan`
-- -----------------------------------------------------
START TRANSACTION;
USE `empresa_internet`;
INSERT INTO `empresa_internet`.`plan` (`id_plan`, `vel_megabits_por_sec`, `precio`, `descuento`) VALUES
(1, '1000', 15000, 10),
(2, '500', 8000, 15),
(3, '250', 4500, 5),
(4, '2000', 22000, 20),
(5, '100', 3500, 10),
(6, '1500', 18000, 12),
(7, '50', 2000, 0),
(8, '3000', 25000, 25),
(9, '600', 11000, 8),
(10, '1200', 16000, 18);
COMMIT;


-- -----------------------------------------------------
-- Data for table `empresa_internet`.`cliente`
-- -----------------------------------------------------
START TRANSACTION;
USE `empresa_internet`;
INSERT INTO `empresa_internet`.`cliente` (`dni`, `nombre`, `apellido`, `fec_nacimiento`, `provincia`, `ciudad`, `id_plan`) VALUES
(1, 'Lionel Andrés', 'Messi', '1987-06-24', 'Santa Fe', 'Rosario', 1),
(2, 'Carlos Alberto', 'Tevez', '1984-02-05', 'Buenos Aires', 'Ciudad Autónoma de Buenos Aires', 2),
(3, 'Sergio Leonel', 'Aguero', '1988-06-02', 'Buenos Aires', 'Avellaneda', 3),
(4, 'Ángel Fabián', 'Di María', '1988-02-14', 'Santa Fe', 'Rosario', 4),
(5, 'Javier Alejandro', 'Mascherano', '1984-06-08', 'Buenos Aires', 'Don Torcuato', 5),
(6, 'Ezequiel Iván', 'Lavezzi', '1985-05-03', 'Buenos Aires', 'Villa María', 6),
(7, 'Rodrigo Andrés', 'Palacio', '1982-02-05', 'Buenos Aires', 'Bahía Blanca', 7),
(8, 'Gabriel Mercado', 'Mercado', '1987-03-18', 'Mendoza', 'Mendoza', 8),
(9, 'Federico Gastón', 'Fazio', '1987-03-17', 'Buenos Aires', 'Morón', 9),
(10, 'Marcos Rojo', 'Rojo', '1990-03-20', 'Buenos Aires', 'La Plata', 10),
(11, 'Matías Nicolás', 'Cecchini', '1994-01-08', 'Buenos Aires', 'Mar del Plata', 2),
(12, 'Joaquín Correa', 'Correa', '1994-08-13', 'Buenos Aires', 'Lanús', 3),
(13, 'Exequiel Nicolás', 'Palacios', '1999-10-05', 'CABA', 'Ciudad Autónoma de Buenos Aires', 4),
(14, 'Gonzalo Gerardo', 'Higuaín', '1987-12-10', 'Buenos Aires', 'Banfield', 5),
(15, 'Juan Martín', 'Del Potro', '1988-09-23', 'Buenos Aires', 'Tandil', 6),
(16, 'Emiliano Ariel', 'Martínez', '1992-09-02', 'Buenos Aires', 'Mar del Plata', 7),
(17, 'Lisandro Andrés', 'López', '1983-05-02', 'Buenos Aires', 'Río Cuarto', 8),
(18, 'Ramiro Ángel', 'Funes Mori', '1991-03-05', 'CABA', 'Ciudad Autónoma de Buenos Aires', 9),
(19, 'Pablo Javier', 'Zabaleta', '1985-01-16', 'Buenos Aires', 'Buenos Aires', 10),
(20, 'Santiago Alejandro', 'Sosa', '1989-05-19', 'Buenos Aires', 'La Plata', 1),
(21, 'José Juan', 'Bautista', '1992-02-25', 'Mendoza', 'Mendoza', 2),
(22, 'Santiago Darío', 'Cerro', '1993-09-20', 'CABA', 'Ciudad Autónoma de Buenos Aires', 3),
(23, 'Carlos Eduardo', 'Tajín', '1990-06-15', 'Santa Fe', 'Rosario', 4),
(24, 'Diego Sebastián', 'López', '1986-11-24', 'Buenos Aires', 'Lomas de Zamora', 5),
(25, 'Lucas Eduardo', 'González', '1990-08-15', 'Misiones', 'Posadas', 6),
(26, 'Marcos Emiliano', 'Sánchez', '1989-11-22', 'Buenos Aires', 'Avellaneda', 7),
(27, 'Ricardo Gabriel', 'Benedetto', '1990-05-18', 'Buenos Aires', 'Buenos Aires', 8),
(28, 'Agustín Nicolás', 'Alvarez', '1998-10-31', 'Mendoza', 'Mendoza', 9),
(29, 'Leandro Damián', 'Paredes', '1994-06-29', 'Buenos Aires', 'San Martín', 10),
(30, 'Lucas Rafael', 'Martínez', '1993-03-18', 'Buenos Aires', 'Tigre', 1),
(31, 'Gabriel Alejandro', 'Aguero', '1991-03-10', 'Buenos Aires', 'San Fernando', 2),
(32, 'Santiago Maximiliano', 'Rosales', '1992-07-03', 'CABA', 'Ciudad Autónoma de Buenos Aires', 3),
(33, 'Nicolás Ángel', 'Tagliafico', '1992-08-31', 'Buenos Aires', 'Banfield', 4),
(34, 'Rodrigo Ezequiel', 'Pérez', '1991-10-22', 'Santa Fe', 'Santa Fe', 5),
(35, 'Leonardo Sebastián', 'Jara', '1991-11-05', 'CABA', 'Ciudad Autónoma de Buenos Aires', 6),
(36, 'Carlos Andrés', 'Pérez', '1989-09-21', 'La Pampa', 'Santa Rosa', 7),
(37, 'Ricardo Luis', 'Méndez', '1988-05-06', 'Mendoza', 'Mendoza', 8),
(38, 'Franco Javier', 'Vázquez', '1990-10-14', 'Buenos Aires', 'La Plata', 9),
(39, 'Maximiliano Ariel', 'Madrigal', '1993-07-27', 'Buenos Aires', 'Mar del Plata', 10),
(40, 'Federico Sebastián', 'Chavez', '1992-04-17', 'CABA', 'Ciudad Autónoma de Buenos Aires', 1),
(41, 'Carlos David', 'Pereyra', '1986-11-29', 'Mendoza', 'Mendoza', 2),
(42, 'José Ignacio', 'Pavón', '1990-01-21', 'Buenos Aires', 'Morón', 3),
(43, 'Marcos Javier', 'Romero', '1986-02-16', 'Buenos Aires', 'Lanús', 4),
(44, 'Federico Nicolás', 'Ricci', '1993-05-10', 'Buenos Aires', 'Luján', 5),
(45, 'Juan Gabriel', 'Chaves', '1991-09-15', 'Buenos Aires', 'San Miguel', 6),
(46, 'Esteban Nicolás', 'Castaño', '1991-02-20', 'CABA', 'Ciudad Autónoma de Buenos Aires', 7),
(47, 'Julián Andrés', 'Fernández', '1994-11-17', 'San Juan', 'San Juan', 8),
(48, 'Raúl Eduardo', 'Domínguez', '1990-05-03', 'CABA', 'Ciudad Autónoma de Buenos Aires', 9),
(49, 'Emilio Javier', 'Varela', '1992-12-01', 'CABA', 'Ciudad Autónoma de Buenos Aires', 10),
(50, 'Manuel Sebastián', 'Torres', '1995-02-19', 'Buenos Aires', 'Tigre', 1);
COMMIT;
