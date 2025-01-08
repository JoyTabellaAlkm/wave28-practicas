CREATE TABLE DEPARTAMENTO (
    depto_nro VARCHAR(10) PRIMARY KEY,
    nombre_depto VARCHAR(50) NOT NULL,
    localidad VARCHAR(50) NOT NULL
);

CREATE TABLE EMPLEADO (
    cod_emp VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    puesto VARCHAR(50) NOT NULL,
    fecha_alta DATE NOT NULL,
    salario DECIMAL(10, 2) NOT NULL,
    comision DECIMAL(10, 2) NOT NULL,
    depto_nro VARCHAR(10) NOT NULL,
    FOREIGN KEY (depto_nro) REFERENCES DEPARTAMENTO(depto_nro)
);


INSERT INTO DEPARTAMENTO (depto_nro, nombre_depto, localidad) VALUES
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');

INSERT INTO EMPLEADO (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
('E-0005', 'Daniel', 'Brezecizki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');

#Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT E.NOMBRE, E.PUESTO, D.LOCALIDAD FROM EMPLEADO AS E JOIN DEPARTAMENTO AS D ON E.DEPTO_NRO = D.DEPTO_NRO;
#Visualizar los departamentos con más de cinco empleados.
SELECT D.nombre_depto,COUNT(*) AS CANTIDAD_EMPLEADOS FROM EMPLEADO E JOIN DEPARTAMENTO D ON E.DEPTO_NRO = D.DEPTO_NRO GROUP BY D.DEPTO_NRO HAVING COUNT(*) > 2;
#Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT E.NOMBRE, E.SALARIO, D.NOMBRE_DEPTO
FROM EMPLEADO E JOIN DEPARTAMENTO D ON E.DEPTO_NRO = D.DEPTO_NRO WHERE (
SELECT PUESTO FROM EMPLEADO WHERE NOMBRE LIKE 'César' AND APELLIDO LIKE 'PIÑERO') LIKE E.PUESTO;
#Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT * FROM EMPLEADO E JOIN DEPARTAMENTO D ON E.DEPTO_NRO = D.DEPTO_NRO  WHERE D.NOMBRE_DEPTO LIKE 'Contabilidad' order by E.NOMBRE DESC;
#Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT NOMBRE FROM EMPLEADO WHERE salario = (SELECT MIN(salario) FROM empleado) LIMIT 1;
#Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT NOMBRE FROM EMPLEADO WHERE salario = (SELECT MAX(salario) FROM empleado e JOIN DEPARTAMENTO D ON E.DEPTO_NRO = D.DEPTO_NRO where D.NOMBRE_DEPTO LIKE 'Ventas') ;