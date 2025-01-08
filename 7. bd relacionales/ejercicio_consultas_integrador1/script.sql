DROP DATABASE empresa_internet;
CREATE DATABASE empresa_internet;
USE empresa_internet;

CREATE TABLE cliente (
	dni INT PRIMARY KEY,
	nombre VARCHAR(50),
    apellido VARCHAR(50),
    fecha_nacimiento DATE,
    ciudad VARCHAR(50),
    provincia VARCHAR(50)
);

CREATE TABLE plan (
	id_plan INT PRIMARY KEY,
    descuento FLOAT,
    velocidad INT,
    precio FLOAT,
    dni_cliente INT REFERENCES cliente(dni)
);

-- inserts
INSERT INTO cliente VALUES
(12345678, 'Juan', 'Pérez', '1985-03-25', 'Madrid', 'Madrid'),
(23456789, 'Ana', 'González', '1990-07-15', 'Barcelona', 'Cataluña'),
(34567890, 'Carlos', 'López', '1982-11-02', 'Valencia', 'Valencia'),
(45678901, 'María', 'Martínez', '1995-01-20', 'Sevilla', 'Andalucía'),
(56789012, 'José', 'Rodríguez', '1987-09-10', 'Zaragoza', 'Aragón'),
(67890123, 'Lucía', 'Fernández', '1992-05-30', 'Bilbao', 'País Vasco'),
(78901234, 'David', 'García', '1994-12-04', 'Alicante', 'Comunidad Valenciana'),
(89012345, 'Elena', 'Sánchez', '1989-06-18', 'Murcia', 'Murcia'),
(90123456, 'Pedro', 'Ramírez', '1983-08-27', 'Granada', 'Andalucía'),
(10123457, 'Isabel', 'Hernández', '1997-02-03', 'Salamanca', 'Castilla y León');
INSERT INTO plan (id_plan, descuento, velocidad, precio)
VALUES
(1, 10.0, 300, 29.99),
(2, 15.0, 100, 39.99),
(3, 5.0, 150, 24.99),
(4, 20.0, 250, 49.99),
(5, 12.0, 300, 59.99);

UPDATE plan SET plan.dni_cliente = 12345678 WHERE id_plan=1;
UPDATE plan SET plan.dni_cliente = 23456789 WHERE id_plan=2;
UPDATE plan SET plan.dni_cliente = 34567890 WHERE id_plan=3;
UPDATE plan SET plan.dni_cliente = 90123456 WHERE id_plan=4;
UPDATE plan SET plan.dni_cliente = 12345678 WHERE id_plan=5;

-- consultas
-- precio promedio por plan
SELECT AVG(precio) from plan;
-- plan de mayor valor
SELECT MAX(precio) from plan;
-- mayor descuento brindado
SELECT MAX(precio) from plan;
-- descuento por cliente
SELECT dni_cliente as dni, descuento from plan;
-- clientes junto con el plan adquirido
SELECT cliente.dni, cliente.nombre, cliente.apellido, plan.id_plan, plan.descuento, plan.velocidad, plan.precio
from cliente, plan
WHERE cliente.dni = plan.dni_cliente;
-- dni de los clientes que contrataron un plan con velocidad mayor a 150
SELECT cliente.dni, cliente.nombre, cliente.apellido
from cliente, plan
WHERE cliente.dni = plan.dni_cliente AND plan.velocidad > 150;
-- planes otorgados con menos de 20% de descuento
SELECT id_plan, descuento, precio
from plan
WHERE descuento < 20;
-- mayor cantidad de dinero brindada por un plan
SELECT MAX(precio*(1-descuento/100)) from plan;
-- cantidad de planes contratados
SELECT COUNT(*) from plan;
-- cantidad de planes contratados por clientes de ciudades que comienzan con M
SELECT COUNT(plan.id_plan)
from cliente, plan
WHERE cliente.dni = plan.dni_cliente AND cliente.ciudad LIKE "M%";