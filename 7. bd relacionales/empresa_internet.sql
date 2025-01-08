-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema empresa_internet
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema empresa_internet
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `empresa_internet` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema new_schema1
-- -----------------------------------------------------
USE `empresa_internet` ;

-- -----------------------------------------------------
-- Table `empresa_internet`.`plan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `empresa_internet`.`plan` ;

CREATE TABLE IF NOT EXISTS `empresa_internet`.`plan` (
  `id` INT NOT NULL,
  `velocidad` INT NOT NULL,
  `precio` DECIMAL(10,2) NOT NULL,
  `descuento` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_UNIQUE` ON `empresa_internet`.`plan` (`id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `empresa_internet`.`provincia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `empresa_internet`.`provincia` ;

CREATE TABLE IF NOT EXISTS `empresa_internet`.`provincia` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_UNIQUE` ON `empresa_internet`.`provincia` (`id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `empresa_internet`.`ciudad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `empresa_internet`.`ciudad` ;

CREATE TABLE IF NOT EXISTS `empresa_internet`.`ciudad` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `id_provincia` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_CIUDAD_PROVINCIA`
    FOREIGN KEY (`id_provincia`)
    REFERENCES `empresa_internet`.`provincia` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_UNIQUE` ON `empresa_internet`.`ciudad` (`id` ASC) VISIBLE;

CREATE INDEX `FK_CIUDAD_PROVINCIA_idx` ON `empresa_internet`.`ciudad` (`id_provincia` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `empresa_internet`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `empresa_internet`.`cliente` ;

CREATE TABLE IF NOT EXISTS `empresa_internet`.`cliente` (
  `dni` VARCHAR(50) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `fecha_nacimiento` DATETIME NOT NULL,
  `id_ciudad` INT NOT NULL,
  `id_plan` INT NOT NULL,
  PRIMARY KEY (`dni`),
  CONSTRAINT `FK_CLIENTE_CIUDAD`
    FOREIGN KEY (`id_ciudad`)
    REFERENCES `empresa_internet`.`ciudad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_CLIENTE_PLAN`
    FOREIGN KEY (`id_plan`)
    REFERENCES `empresa_internet`.`plan` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `FK_CLIENTE_PLAN_idx` ON `empresa_internet`.`cliente` (`id_plan` ASC) VISIBLE;

CREATE UNIQUE INDEX `dni_UNIQUE` ON `empresa_internet`.`cliente` (`dni` ASC) VISIBLE;

CREATE INDEX `FK_CLIENTE_CIUDAD_idx` ON `empresa_internet`.`cliente` (`id_ciudad` ASC) VISIBLE;


-- -----------------------------------------------------
-- Data for table `empresa_internet`.`plan`
-- -----------------------------------------------------
START TRANSACTION;
USE `empresa_internet`;
INSERT INTO `empresa_internet`.`plan` (`id`, `velocidad`, `precio`, `descuento`) VALUES (1, 500, 100, 0);
INSERT INTO `empresa_internet`.`plan` (`id`, `velocidad`, `precio`, `descuento`) VALUES (2, 900, 200, 10);
INSERT INTO `empresa_internet`.`plan` (`id`, `velocidad`, `precio`, `descuento`) VALUES (3, 100, 50, 0);
INSERT INTO `empresa_internet`.`plan` (`id`, `velocidad`, `precio`, `descuento`) VALUES (4, 50, 40, 50);
INSERT INTO `empresa_internet`.`plan` (`id`, `velocidad`, `precio`, `descuento`) VALUES (5, 700, 150, 15);
INSERT INTO `empresa_internet`.`plan` (`id`, `velocidad`, `precio`, `descuento`) VALUES (6, 1000, 180, 20);

COMMIT;


-- -----------------------------------------------------
-- Data for table `empresa_internet`.`provincia`
-- -----------------------------------------------------
START TRANSACTION;
USE `empresa_internet`;
INSERT INTO `empresa_internet`.`provincia` (`id`, `nombre`) VALUES (1, 'Buenos Aires');
INSERT INTO `empresa_internet`.`provincia` (`id`, `nombre`) VALUES (2, 'Entre Rios');

COMMIT;


-- -----------------------------------------------------
-- Data for table `empresa_internet`.`ciudad`
-- -----------------------------------------------------
START TRANSACTION;
USE `empresa_internet`;
INSERT INTO `empresa_internet`.`ciudad` (`id`, `nombre`, `id_provincia`) VALUES (1, 'La Plata', 1);
INSERT INTO `empresa_internet`.`ciudad` (`id`, `nombre`, `id_provincia`) VALUES (2, 'Entre Rios', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `empresa_internet`.`cliente`
-- -----------------------------------------------------
START TRANSACTION;
USE `empresa_internet`;
INSERT INTO `empresa_internet`.`cliente` (`dni`, `nombre`, `apellido`, `fecha_nacimiento`, `id_ciudad`, `id_plan`) VALUES ('1', 'Cliente1', 'A', '1999-01-01', 1, 1);
INSERT INTO `empresa_internet`.`cliente` (`dni`, `nombre`, `apellido`, `fecha_nacimiento`, `id_ciudad`, `id_plan`) VALUES ('2', 'Cliente2', 'B', '1999-01-02', 2, 1);
INSERT INTO `empresa_internet`.`cliente` (`dni`, `nombre`, `apellido`, `fecha_nacimiento`, `id_ciudad`, `id_plan`) VALUES ('3', 'Cliente3', 'C', '1999-01-03', 1, 2);
INSERT INTO `empresa_internet`.`cliente` (`dni`, `nombre`, `apellido`, `fecha_nacimiento`, `id_ciudad`, `id_plan`) VALUES ('4', 'Cliente4', 'D', '1999-01-04', 2, 2);
INSERT INTO `empresa_internet`.`cliente` (`dni`, `nombre`, `apellido`, `fecha_nacimiento`, `id_ciudad`, `id_plan`) VALUES ('5', 'Cliente5', 'E', '1999-01-05', 1, 3);
INSERT INTO `empresa_internet`.`cliente` (`dni`, `nombre`, `apellido`, `fecha_nacimiento`, `id_ciudad`, `id_plan`) VALUES ('6', 'Cliente6', 'F', '1999-01-06', 2, 3);
INSERT INTO `empresa_internet`.`cliente` (`dni`, `nombre`, `apellido`, `fecha_nacimiento`, `id_ciudad`, `id_plan`) VALUES ('7', 'Cliente7', 'G', '1999-01-07', 1, 4);
INSERT INTO `empresa_internet`.`cliente` (`dni`, `nombre`, `apellido`, `fecha_nacimiento`, `id_ciudad`, `id_plan`) VALUES ('8', 'Cliente8', 'H', '1999-01-08', 2, 4);
INSERT INTO `empresa_internet`.`cliente` (`dni`, `nombre`, `apellido`, `fecha_nacimiento`, `id_ciudad`, `id_plan`) VALUES ('9', 'Cliente9', 'I', '1999-01-09', 1, 5);
INSERT INTO `empresa_internet`.`cliente` (`dni`, `nombre`, `apellido`, `fecha_nacimiento`, `id_ciudad`, `id_plan`) VALUES ('10', 'Cliente10', 'J', '1999-01-10', 2, 6);

COMMIT;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
