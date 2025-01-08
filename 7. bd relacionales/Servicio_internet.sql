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
-- Mostrar todos los registros de la tabla de movies.
SELECT * FROM movies;
-- Mostrar el nombre, apellido y rating de todos los actores.
SELECT nombre, apellido, rating FROM actors;
-- Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
SELECT title AS "titulo" FROM series;
-- Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
SELECT first_name, last_name FROM actors WHERE rating > 7.5;
-- Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
SELECT title, rating, awards FROM movies WHERE rating > 7.5 AND awards > 2;
-- Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
SELECT title, rating FROM movies ORDER BY rating ASC;
-- Mostrar los títulos de las primeras tres películas en la base de datos.
SELECT title FROM movies LIMIT 3;
-- Mostrar el top 5 de las películas con mayor rating.
SELECT title, rating FROM movies ORDER BY rating DESC LIMIT 5;
-- Listar los primeros 10 actores.
SELECT first_name, last_name FROM actors LIMIT 10;
-- Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
SELECT title, rating FROM movies WHERE title = 'Toy Story';
-- Mostrar a todos los actores cuyos nombres empiezan con Sam.
SELECT first_name, last_name FROM actors WHERE name LIKE 'Sam%';
-- Mostrar el título de las películas que salieron entre el 2004 y 2008.
SELECT title, release_date FROM movies WHERE release_date BETWEEN '2004-01-01' AND '2008-12-31';
-- Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009.
-- Ordenar los resultados por rating.
SELECT title, release_date FROM movies WHERE rating > 3 AND awards > 1 AND release_date BETWEEN '1988-01-01' AND '2009-12-31' ORDER BY rating DESC;
