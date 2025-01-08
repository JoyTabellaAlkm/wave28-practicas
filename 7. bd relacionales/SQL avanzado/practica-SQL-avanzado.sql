USE empresa_db;

INSERT INTO departamento (depto_nro, nombre_depto, localidad)
VALUES ("D-000-1", "Software", "Los Tigres");

INSERT INTO departamento (depto_nro, nombre_depto, localidad)
VALUES ("D-000-2", "Sistemas", "Guadalupe");

INSERT INTO departamento (depto_nro, nombre_depto, localidad)
VALUES ("D-000-3", "Contabilidad", "La Roca");

INSERT INTO departamento (depto_nro, nombre_depto, localidad)
VALUES ("D-000-4", "Ventas", "Plata");

INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0001', 'Cesar', 'Piñero', 'Vendedor', '2018-05-12', 8000, 1500, 'D-000-4');

INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2');

INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3');

INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4');

INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4');

INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3');

INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');

SELECT * FROM departamento WHERE depto_nro = 'D-000-4';
SELECT * FROM departamento WHERE depto_nro = 'D-000-1';
SELECT * FROM departamento WHERE nombre_depto = 'Ventas';
SELECT * FROM departamento WHERE depto_nro = 'D-0001';
SELECT * FROM departamento;

SELECT e.nombre, e.puesto, d.localidad
FROM empleado e
JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto = 'Vendedor';

SELECT e.depto_nro, d.nombre_depto, COUNT(e.cod_emp) AS num_empleados
FROM empleado e
JOIN departamento d ON e.depto_nro = d.depto_nro
GROUP BY e.depto_nro, d.nombre_depto
HAVING COUNT(e.cod_emp) > 2;

SELECT e.nombre, e.salario, d.nombre_depto
FROM empleado e
JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto = (SELECT puesto FROM empleado WHERE nombre = 'Mito' AND apellido = 'Barchuk' LIMIT 1);

SELECT e.cod_emp, e.nombre, e.apellido, e.puesto, e.fecha_alta, e.salario, e.comision, d.nombre_depto
FROM empleado e
JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Contabilidad'
ORDER BY e.nombre;

SELECT nombre, salario
FROM empleado
WHERE salario = (SELECT MIN(salario) FROM empleado);

SELECT e.cod_emp, e.nombre, e.apellido, e.puesto, e.fecha_alta, e.salario, e.comision, d.nombre_depto
FROM empleado e
JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Ventas'
AND e.salario = (
    SELECT MAX(salario)
    FROM empleado
    WHERE depto_nro = e.depto_nro
);

