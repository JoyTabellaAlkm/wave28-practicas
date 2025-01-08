DROP DATABASE IF EXISTS servicio_internet;
CREATE DATABASE servicio_internet;
USE servicio_internet;

DROP TABLE IF EXISTS `cliente`;
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

DROP TABLE IF EXISTS `plan_internet`;
CREATE TABLE `plan_internet` (
                                 `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                                 `velocidad` int(10) NOT NULL,
                                 `precio` decimal(10,2) NULL DEFAULT NULL,
                                 `descuento` decimal(2,2) NOT NULL DEFAULT 0,
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `cliente_plan_internet`;
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