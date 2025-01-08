CREATE DATABASE empresa;

USE empresa;

CREATE TABLE DEPARTAMENTO (
    depto_nro VARCHAR(10) PRIMARY KEY,
    nombre_depto VARCHAR(50),
    localidad VARCHAR(50) 
);

CREATE TABLE EMPLEADO (
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


INSERT INTO DEPARTAMENTO (depto_nro, nombre_depto, localidad)
VALUES
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');

INSERT INTO EMPLEADO (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');


Select * from EMPLEADO;
Select * from DEPARTAMENTO;

-- Ejercicio 1
SELECT e.nombre, e.apellido, e.puesto, d.localidad from EMPLEADO e
INNER JOIN DEPARTAMENTO d ON d.depto_nro = e.depto_nro;



-- Ejercicio 2
SELECT d.* FROM EMPLEADO e
LEFT JOIN DEPARTAMENTO d ON d.depto_nro = e.depto_nro
GROUP BY d.depto_nro
HAVING COUNT(*) > 5;



-- Ejercicio 3
SELECT e.nombre, e.apellido, e.salario, d.nombre_depto from EMPLEADO e
INNER JOIN DEPARTAMENTO d ON d.depto_nro = e.depto_nro
WHERE e.puesto = (
	SELECT em.puesto FROM EMPLEADO em WHERE em.nombre = 'Mito' AND em.apellido = 'Barchuk');
    
-- Ejercicio 3 Alt
SELECT e.nombre, e.apellido, e.salario, d.nombre_depto from EMPLEADO e
INNER JOIN DEPARTAMENTO d ON d.depto_nro = e.depto_nro
WHERE e.puesto = (
	SELECT em.puesto FROM EMPLEADO em WHERE em.nombre = 'Jonathan' AND em.apellido = 'Aguilera');


-- Ejercicio 4 
SELECT e.* FROM EMPLEADO e
LEFT JOIN DEPARTAMENTO d ON d.depto_nro = e.depto_nro
WHERE d.nombre_depto = 'Contabilidad'
ORDER BY e.nombre DESC


-- Ejercicio 5
Select e.nombre from EMPLEADO e
WHERE e.salario = (SELECT MIN(em.salario) FROM EMPLEADO em)

-- Ejercicio 5 Alt 
SELECT *
FROM empleados
ORDER BY salario ASC
LIMIT 1;

/*
	6: Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
*/

-- Ejercicio 6
Select e.* from EMPLEADO e
WHERE e.salario = (
	SELECT MAX(em.salario) FROM EMPLEADO em 
	INNER JOIN DEPARTAMENTO de ON de.depto_nro = em.depto_nro 
    WHERE de.nombre_depto = 'Ventas'
    )


