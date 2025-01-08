
DROP DATABASE IF EXISTS empresa_internet;
CREATE DATABASE empresa_internet;
USE empresa_internet;

DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `velocidad` varchar(50),
  `precio` decimal(50),
  `descuento` varchar(50),
  PRIMARY KEY (`id`)
);

LOCK TABLES `plan` WRITE;
INSERT INTO `plan` VALUES 
	(1,"100MB",15990,"10%"),
    (2,"200MB",20990,"10%"),
    (3,"500MB",25990,"15%"),
    (4,"100MB",13990,"0%"),
    (5,"800MB",30990,"5%");
UNLOCK TABLES;

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `dni` varchar(10) NOT NULL,
  `nombre` varchar(50),
  `apellido` varchar(50),
  `fecha_nacimiento` date,
  `provincia` varchar(50),
  `ciudad` varchar(50),
  `plan_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`dni`),
  KEY `plan_id_foreign` (`plan_id`),
  CONSTRAINT `plan_id_foreign` FOREIGN KEY (`plan_id`) REFERENCES `plan` (`id`)
);

LOCK TABLES `cliente` WRITE;
INSERT INTO `cliente` VALUES 
	("12345678-9","Juan","Gabriel","1999-02-12","Lampa","Santiago",1),
    ("87654321-9","Darla","Gonzalez","1990-12-30","Puente Alto","Santiago",3),
    ("18273645-9","Martin","Ferreiro","1983-06-12","Lampa","Santiago",5),
    ("54637281-9","Tomas","Parker","1985-07-16","Lota","Concepcion",3),
    ("98765123-9","Gabriel","Reyes","1989-07-02","Recoleta","Santiago",2),
    ("12349876-9","Mariana","Zapata","1976-04-06","Lota","Concepcion",1),
    ("19283746-9","Sofia","Reyes","1972-11-18","Rancagua","Rancagua",3),
    ("91827364-9","Emiliano","Lopez","1998-12-23","San Miguel","Santiago",3),
    ("11111111-9","Martina","Soto","1998-01-09","Recoleta","Santiago",1),
    ("99991999-9","Luz","Gonzalez","1970-02-11","Lampa","Santiago",5);
UNLOCK TABLES;