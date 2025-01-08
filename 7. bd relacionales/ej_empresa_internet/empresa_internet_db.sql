-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: laravel-database
-- ------------------------------------------------------
-- Server version	5.7.18-0ubuntu0.16.04.1
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
DROP DATABASE IF EXISTS servicio_internet;
CREATE DATABASE servicio_internet;
USE servicio_internet;
DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `dni` varchar(10) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `fecha_nacimiento` datetime NOT NULL,
  `provincia` varchar(100) NOT NULL,
  `ciudad` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Insertando datos en la tabla `Clientes`
LOCK TABLES `cliente` WRITE;
INSERT INTO `cliente` VALUES
(1, '12345678', 'Juan', 'Pérez', '1990-01-01', 'Capital federal', 'Capital Federal'),
(2, '23456789', 'Ana', 'García', '1985-02-02', 'Buenos Aires', 'La plata'),
(3, '34567890', 'Luis', 'Martínez', '1980-03-03', 'Formosa', 'Formosa'),
(4, '45678901', 'Laura', 'Sánchez', '1995-04-04', 'Capital federal', 'Capital Federal'),
(5, '56789012', 'Carlos', 'Rodríguez', '1988-05-05', 'Neuquen', 'Villa La Angostura'),
(6, '67890123', 'Maria', 'Gómez', '1992-06-06', 'Capital federal', 'Capital Federal'),
(7, '78901234', 'Pedro', 'Fernández', '1975-07-07', 'Santa Fe', 'Santa Fe'),
(8, '89012345', 'Elena', 'Hernández', '1993-08-08', 'Buenos Aires', 'Pilar'),
(9, '90123456', 'Fernando', 'Jiménez', '1981-09-09', 'Capital federal', 'Capital Federal'),
(10, '11234567', 'Sara', 'Ramírez', '1987-10-10', 'Entre Rios', 'Parana');
UNLOCK TABLES;
--
-- Table structure for table `plan_internet`
--
DROP TABLE IF EXISTS `plan_internet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plan_internet` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `velocidad` int(10) NOT NULL,
  `precio` decimal(10,2) NULL DEFAULT NULL,
  `descuento` decimal(2,2) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Insertando datos en la tabla `plan_internet`
LOCK TABLES `plan_internet` WRITE;
INSERT INTO `plan_internet` VALUES
(1, 10, 30.00, 0.2),
(2, 50, 50.00, 0.0),
(3, 100, 70.00, 0.05),
(4, 200, 100.00, 0.1),
(5, 500, 150.00, 0.12);
UNLOCK TABLES;


--
-- Table structure for table `cliente_plan_internet`
--
DROP TABLE IF EXISTS `cliente_plan_internet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente_plan_internet` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `cliente_id` int(10) UNSIGNED DEFAULT NULL,
  `plan_internet_id` int(10) UNSIGNED DEFAULT NULL,
  `direccion` varchar(120) DEFAULT NULL,
  `fecha_alta` varchar(120) DEFAULT NULL,
  `fecha_baja` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cliente_plan_internet_cliente_id_foreign` (`cliente_id`),
  CONSTRAINT `cliente_plan_internet_cliente_id_foreign` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  KEY `cliente_plan_internet_plan_internet_id_foreign` (`plan_internet_id`),
  CONSTRAINT `cliente_plan_internet_plan_internet_id_foreign` FOREIGN KEY (`plan_internet_id`) REFERENCES `plan_internet` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- Insertando datos en la tabla `cliente_plan_internet`
LOCK TABLES `cliente_plan_internet` WRITE;
INSERT INTO `cliente_plan_internet` VALUES
(1, 1, 1, 'Av. 9 de Julio','2023-01-01', '2024-01-01'),
(2, 2, 2, 'Calle 5','2023-01-15', '2024-01-15'),
(3, 3, 3, 'Calle San Martín','2023-02-01', '2024-02-01'),
(4, 4, 4, 'Medrano Av ','2023-02-10', '2024-02-10'),
(5, 5, 5, 'Calle Costa','2023-03-01', '2024-03-01'),
(6, 5, 1, 'Calle Mariano Moreno','2023-03-15', '2024-03-15'),
(7, 6, 2, 'Calle Libertador','2023-04-01', '2024-04-01'),
(8, 7, 3, 'maipu','2023-04-05', '2024-04-05'),
(9, 8, 4, 'Italia','2023-05-01', '2024-05-01'),
(10,9, 5, 'Lambare', '2023-06-01', '2024-06-01'),
(11, 10, 5, 'uriburu', '2023-06-01', '2024-06-01');

UNLOCK TABLES;



/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
-- Dump completed on 2017-06-12 10:09:28









