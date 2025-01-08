
INSERT INTO Departamento  VALUES ('D-000-1', 'Software', 'Los Tigres'), ('D-000-2', 'Sistemas', 'Guadalupe'), ('D-000-3', 'Contabilidad', 'La Roca'), ('D-000-4', 'Ventas', 'Plata');


INSERT INTO Empleado
VALUES ('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
 ('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
 ('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
 ('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
 ('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
 ('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
 ('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');




/*Consulta uno*/
SELECT e.nombre,e.puesto,d.localidad
FROM Empleado e JOIN Departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto="Vendedor";

/*Consulta dos*/
SELECT e.depto_nro , count(*) AS CantidadEmpleadosXdepto
FROM Empleado e GROUP BY e.depto_nro HAVING CantidadEmpleadosXdepto>=5;

/*Consulta tres*/
SELECT e.nombre, e.puesto, d.nombre_dpto
FROM Empleado e JOIN Departamento d ON e.depto_nro=d.depto_nro
WHERE e.puesto IN (SELECT e.puesto FROM Empleado WHERE e.nombre="Mito" AND e.apellido="Barchuk");

/*Consulta cuatro*/
SELECT e.*
FROM EMPLEADO e JOIN DEPARTAMENTO d ON e.depto_nro = d.depto_nro
WHERE
    d.nombre_dpto = 'Contabilidad'
ORDER BY
    e.nombre;

/*Consulta cinco*/
SELECT e.nombre, e.salario
FROM EMPLEADO e
WHERE e.salario = (SELECT MIN(salario) FROM EMPLEADO);

/*Consulta seis*/
SELECT e.*
FROM EMPLEADO e JOIN DEPARTAMENTO d ON e.depto_nro = d.depto_nro
WHERE d.nombre_dpto = 'Ventas' AND e.salario = (SELECT MAX(salario) FROM EMPLEADO WHERE depto_nro = d.depto_nro);
