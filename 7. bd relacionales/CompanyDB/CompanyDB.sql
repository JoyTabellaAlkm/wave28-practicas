-- Crear una nueva base de datos
CREATE DATABASE CompanyDB;

-- Usar la nueva base de datos
USE CompanyDB;

-- Crear la tabla de DEPARTMENTS
CREATE TABLE Departments (
    depto_nro VARCHAR(10) PRIMARY KEY,
    nombre_depto VARCHAR(50),
    localidad VARCHAR(50)
);

-- Crear la tabla de EMPLOYEES
CREATE TABLE Employees (
    cod_emp VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    puesto VARCHAR(50),
    fecha_alta DATE,
    salario DECIMAL(10, 2),
    comision DECIMAL(10, 2),
    depto_nro VARCHAR(10),
    FOREIGN KEY (depto_nro) REFERENCES Departments(depto_nro)
);

-- Insertar datos en la tabla de DEPARTMENTS
INSERT INTO Departments (depto_nro, nombre_depto, localidad) VALUES
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');

-- Insertar datos en la tabla de EMPLOYEES
INSERT INTO Employees (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');


-- Se requiere obtener las siguientes consultas:

-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedoresEMPLEADOEMPLEADO.
SELECT e.nombre, e.puesto, d.localidad FROM Departments d 
INNER JOIN Employees e ON e.depto_nro = d.depto_nro AND e.puesto = "Vendedor";

SELECT e.nombre, e.apellido, e.puesto, d.localidad FROM Employees e
INNER JOIN Departments d ON d.depto_nro = e.depto_nro
WHERE e.puesto = "Vendedor";

-- Visualizar los departamentos con más de cinco empleados.
SELECT d.depto_nro, d.nombre_depto, COUNT(e.cod_emp) as total_empleados FROM Departments d 
INNER JOIN Employees e ON e.depto_nro = d.depto_nro
GROUP BY d.depto_nro HAVING COUNT(e.cod_emp) > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.apellido, e.salario, d.nombre_depto FROM Employees e
INNER JOIN Departments d ON d.depto_nro = e.depto_nro
WHERE e.puesto IN (SELECT e2.puesto FROM Employees e2 WHERE e2.nombre = "Mito" AND e2.apellido = "Barchuk");

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.nombre, e.apellido, e.puesto, d.localidad FROM Employees e
INNER JOIN Departments d ON d.depto_nro = e.depto_nro AND d.depto_nro = "D-000-3"
ORDER BY e.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT e.nombre FROM Employees e WHERE e.salario = (SELECT MIN(e2.salario) FROM Employees e2);

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.nombre, e.apellido, e.salario FROM Employees e 
WHERE e.salario = (SELECT MAX(e2.salario) FROM Employees e2
INNER JOIN Departments d ON d.depto_nro = e2.depto_nro AND d.depto_nro = "D-000-4");