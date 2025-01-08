-- Crear la base de datos
DROP DATABASE IF EXISTS empresa_db;
CREATE DATABASE IF NOT EXISTS empresa_db;
USE empresa_db;

-- Crear tablas.
CREATE TABLE IF NOT EXISTS departamento (
    depto_nro VARCHAR(10) PRIMARY KEY,
    nombre_depto VARCHAR(50),
    localidad VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS empleado (
    cod_emp VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    puesto VARCHAR(50),
    fecha_alta DATE,
    salario DECIMAL(10,2),
    comision DECIMAL(10,2),
    depto_nro VARCHAR(10),
    FOREIGN KEY (depto_nro) REFERENCES departamento(depto_nro)
);

-- Insertar datos.
INSERT INTO departamento (depto_nro, nombre_depto, localidad) VALUES
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');

INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');

-- Queries
-- 1
SELECT empleado.nombre, empleado.puesto, departamento.localidad
FROM empleado
JOIN departamento ON empleado.depto_nro = departamento.depto_nro
WHERE empleado.puesto = 'Vendedor';

-- 2
SELECT departamento.nombre_depto, COUNT(empleado.cod_emp) AS numero_empleados
FROM departamento
LEFT JOIN empleado ON departamento.depto_nro = empleado.depto_nro
GROUP BY departamento.nombre_depto
HAVING COUNT(empleado.cod_emp) > 5;

-- 3
SELECT e.nombre, e.salario, d.nombre_depto
FROM empleado e
JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto = (SELECT puesto FROM empleado WHERE nombre = 'Mito' AND apellido = 'Barchuk');

-- 4
SELECT e.*
FROM empleado e
JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Contabilidad'
ORDER BY e.nombre;

-- 5
SELECT nombre, apellido
FROM empleado
WHERE salario = (SELECT MIN(salario) FROM empleado);

-- 6
SELECT e.*
FROM empleado e
JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Ventas' AND e.salario = (SELECT MAX(salario) FROM empleado WHERE depto_nro = d.depto_nro);

-- Extra
SELECT d.*
FROM departamento d
WHERE d.depto_nro IN (SELECT e.depto_nro FROM empleado e)