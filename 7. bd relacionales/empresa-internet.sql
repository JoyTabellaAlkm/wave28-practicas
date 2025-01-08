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
-- Table `empresa_internet`.`clients`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `empresa_internet`.`clients` ;

CREATE TABLE IF NOT EXISTS `empresa_internet`.`clients` (
  `dni` INT NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `birthdate` DATE NOT NULL,
  `department` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`dni`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empresa_internet`.`packages`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `empresa_internet`.`packages` ;

CREATE TABLE IF NOT EXISTS `empresa_internet`.`packages` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `speed` INT NOT NULL,
  `price` DECIMAL(7) NOT NULL,
  `discount` DECIMAL(7) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empresa_internet`.`clients_packages`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `empresa_internet`.`clients_packages` ;

CREATE TABLE IF NOT EXISTS `empresa_internet`.`clients_packages` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `clients_dni` INT NOT NULL,
  `packages_id` INT NOT NULL,
  INDEX `fk_clients_has_packages_packages1_idx` (`packages_id` ASC) VISIBLE,
  INDEX `fk_clients_has_packages_clients_idx` (`clients_dni` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_clients_has_packages_clients`
    FOREIGN KEY (`clients_dni`)
    REFERENCES `empresa_internet`.`clients` (`dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_clients_has_packages_packages1`
    FOREIGN KEY (`packages_id`)
    REFERENCES `empresa_internet`.`packages` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
