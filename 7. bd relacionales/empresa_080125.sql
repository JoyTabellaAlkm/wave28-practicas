#Crear BD y tablas
CREATE SCHEMA IF NOT EXISTS empresa_080125;
CREATE TABLE IF NOT EXISTS empresa_080125.departamento(
depto_nro varchar(255) NOT NULL PRIMARY KEY,
nombre_depto varchar(255),
localidad varchar(255)
);
CREATE TABLE IF NOT EXISTS empresa_080125.empleado(
cod_emp varchar(255) NOT NULL PRIMARY KEY,
nombre varchar(255),
apellido varchar(255),
puesto varchar(255),
fecha_alta varchar(255),
salario int,
comision int,
depto_nro varchar(255),
FOREIGN KEY(depto_nro) REFERENCES departamento(depto_nro)
);
INSERT INTO empresa_080125.departamento VALUE ("D-000-1", "Software", "Los Tigres");
INSERT INTO empresa_080125.departamento VALUE ("D-000-2", "Sistemas", "Guadalupe");
INSERT INTO empresa_080125.departamento VALUE ("D-000-3", "Contabilidad", "La Roca");
INSERT INTO empresa_080125.departamento VALUE ("D-000-4", "Ventas", "Plata");

INSERT INTO empresa_080125.empleado VALUE("E-0001", "César", "Piñero", "Vendedor", "12/05/2018", "80000", "15000", "D-000-4");
INSERT INTO empresa_080125.empleado VALUE("E-0002", "Yosep", "Kowaleski", "Analista", "14/07/2015", "140000", "0", "D-000-2");
INSERT INTO empresa_080125.empleado VALUE("E-0003", "Mariela", "Barrios", "Director", "05/06/2014", "185000", "0", "D-000-3");
INSERT INTO empresa_080125.empleado VALUE("E-0004", "Jonathan", "Aguilera", "Vendedor", "03/06/2015", "85000", "10000", "D-000-4");
INSERT INTO empresa_080125.empleado VALUE("E-0005", "Daniel", "Brezezicki", "Vendedor", "03/03/2018", "83000", "10000", "D-000-4");
INSERT INTO empresa_080125.empleado VALUE("E-0006", "Mito", "Barchuk", "Presidente", "05/06/2014", "190000", "0", "D-000-3");
INSERT INTO empresa_080125.empleado VALUE("E-0007", "Emilio", "Galarza", "Desarrollador", "02/08/2014", "60000", "0", "D-000-1");

#Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre,e.puesto, d.nombre_depto, d.localidad
FROM departamento d
INNER JOIN empleado e ON d.depto_nro = e.depto_nro
WHERE e.puesto = "Vendedor";

#Visualizar los departamentos con más de cinco empleados.
SELECT d.*
FROM empleado e
INNER JOIN departamento d ON e.depto_nro = d.depto_nro
GROUP BY e.depto_nro
HAVING count(*)>2;

#Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto
FROM empleado e
INNER JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto = (SELECT e.puesto
				FROM empleado e
                WHERE e.nombre = "Daniel" AND e.apellido ="Brezezicki");
                
#Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.*
FROM empleado e
WHERE e.depto_nro = (SELECT d.depto_nro
					FROM departamento d
					WHERE d.nombre_depto = "Contabilidad")
ORDER BY e.nombre;

#Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT e.nombre
FROM empleado e
ORDER BY e.salario
LIMIT 1;

#Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.*
FROM empleado e
WHERE e.depto_nro = (SELECT d.depto_nro
					FROM departamento d
					WHERE d.nombre_depto = "Ventas")
ORDER BY e.salario DESC
LIMIT 1;
