-- Seleccionar todos los clientes
SELECT * FROM `empresa_internet`.`Client`;

-- Seleccionar todos los planes disponibles
SELECT * FROM `empresa_internet`.`plan`;

-- Seleccionar todos los registros de client_plan
SELECT * FROM `empresa_internet`.`client_plan`;

-- Seleccionar clientes de una provincia específica
SELECT first_name, last_name
FROM `empresa_internet`.`Client`
WHERE province = 'Córdoba';

-- Seleccionar clientes cuyo apellido empieza con 'P'
SELECT first_name, last_name
FROM `empresa_internet`.`Client`
WHERE last_name LIKE 'P%';

-- Seleccionar clientes que nacieron después de 1990
SELECT first_name, last_name, birth_date
FROM `empresa_internet`.`Client`
WHERE birth_date > '1990-01-01';

-- Seleccionar planes con un precio superior a 50 y ordenarlos por precio descendente
SELECT idplan, speed_mb, price
FROM `empresa_internet`.`plan`
WHERE price > 50
ORDER BY price DESC;

-- Seleccionar todos los clientes ordenados por apellido y luego por nombre
SELECT first_name, last_name
FROM `empresa_internet`.`Client`
ORDER BY last_name ASC, first_name ASC;

-- Seleccionar planes que ofrecen una velocidad igual o mayor a 200 MB
SELECT idplan, speed_mb
FROM `empresa_internet`.`plan`
WHERE speed_mb >= 200;

-- Seleccionar todos los registros de client_plan donde el plan_id es 3
SELECT * FROM `empresa_internet`.`client_plan`
WHERE plan_id = 3;