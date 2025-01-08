CREATE DATABASE `empresa_db`;

CREATE TABLE empleados (
    cod_emp VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    puesto VARCHAR(50) NOT NULL,
    fecha_alta DATE NOT NULL,
    salario DECIMAL(15, 2) NOT NULL,
    comision DECIMAL(15, 2) NOT NULL,
    depto_nro VARCHAR(10) NOT NULL
);

INSERT INTO empleados (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000.00, 15000.00, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000.00, 0.00, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000.00, 0.00, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000.00, 10000.00, 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000.00, 10000.00, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000.00, 0.00, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000.00, 0.00, 'D-000-1');

CREATE TABLE departamento (
    depto_nro VARCHAR(10) PRIMARY KEY,
    nombre_depto VARCHAR(50) NOT NULL,
    localidad VARCHAR(50) NOT NULL
);

ALTER TABLE empleados ADD CONSTRAINT FK_Department_Id FOREIGN KEY (depto_nro) REFERENCES departamento (depto_nro);

INSERT INTO departamento (depto_nro, nombre_depto, localidad) VALUES
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');


-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.puesto, d.localidad 
FROM empleados e JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto="Vendedor";

-- 2. Visualizar los departamentos con más de dos empleados.
SELECT e.depto_nro, count(e.depto_nro) AS total
FROM empleados e JOIN departamento d ON e.depto_nro = d.depto_nro
GROUP BY e.depto_nro
HAVING total>2;

-- 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan 
-- el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto 
FROM empleados e JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto=(SELECT puesto FROM empleados WHERE nombre = "Mito" and apellido="Barchuk");

-- 4. Mostrar los datos de los empleados que trabajan en el departamento de 
-- contabilidad, ordenados por nombre.
SELECT e.*
FROM empleados e JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto="Contabilidad"
ORDER BY e.nombre asc, e.apellido asc;

-- 5. Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT * FROM empleados Order by salario asc limit 1;

-- 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.*
FROM empleados e JOIN departamento d ON e.depto_nro = d.depto_nro
where d.nombre_depto="Ventas" Order by salario desc limit 1 ;
