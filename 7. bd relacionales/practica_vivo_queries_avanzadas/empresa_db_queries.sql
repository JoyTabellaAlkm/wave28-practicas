CREATE DATABASE empresa;
USE empresa;

CREATE TABLE departamento (
    depto_nro VARCHAR(10) PRIMARY KEY,
    nombre_depto VARCHAR(50),
    localidad VARCHAR(50)
);

CREATE TABLE empleado (
    cod_emp VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    puesto VARCHAR(50),
    fecha_alta DATE,
    salario DECIMAL(10, 2),
    comision DECIMAL(10, 2),
    depto_nro VARCHAR(10),
    FOREIGN KEY (depto_nro) REFERENCES DEPARTAMENTO(depto_nro)
);

INSERT INTO departamento (depto_nro, nombre_depto, localidad)
VALUES
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');

INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');

-- Ejercicio 1
SELECT e.nombre, e.apellido, e.puesto, d.localidad from empleado e
INNER JOIN departamento d ON d.depto_nro = e.depto_nro;

-- Ejercicio 2
SELECT d.* FROM empleado e
LEFT JOIN departamento d ON d.depto_nro = e.depto_nro
GROUP BY d.depto_nro
HAVING COUNT(*) > 5;

-- Ejercicio 3
SELECT e.nombre, e.apellido, e.salario, d.nombre_depto from empleado e
INNER JOIN departamento d ON d.depto_nro = e.depto_nro
WHERE e.puesto = (
	SELECT em.puesto FROM empleado em WHERE em.nombre = 'Mito' AND em.apellido = 'Barchuk');

-- Ejercicio 3 Alt
SELECT e.nombre, e.apellido, e.salario, d.nombre_depto from EMPLEADO e
INNER JOIN DEPARTAMENTO d ON d.depto_nro = e.depto_nro
WHERE e.puesto = (
	SELECT em.puesto FROM empleado em WHERE em.nombre = 'Jonathan' AND em.apellido = 'Aguilera');

-- Ejercicio 4
SELECT e.* FROM empleado e
LEFT JOIN departamento d ON d.depto_nro = e.depto_nro
WHERE d.nombre_depto = 'Contabilidad'
ORDER BY e.nombre DESC;

-- Ejercicio 5
SELECT nombre, salario from empleado
WHERE salario = (SELECT MIN(salario) FROM EMPLEADO);

-- Ejercicio 5 Alt
SELECT nombre, salario FROM empleado ORDER BY salario ASC LIMIT 1;

-- Ejercicio 6
SELECT nombre, salario FROM empleado
WHERE salario = (SELECT MAX(salario) FROM EMPLEADO);

-- Ejercicio 6 Alt
SELECT nombre, salario FROM empleado e ORDER BY salario DESC LIMIT 1;
