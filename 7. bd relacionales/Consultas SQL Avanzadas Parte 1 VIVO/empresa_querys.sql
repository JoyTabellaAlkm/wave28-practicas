/** Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores. **/
SELECT nombre_depto, puesto, localidad
FROM empleado AS e
JOIN departamento AS d ON e.depto_nro = d.depto_nro;

/** Visualizar los departamentos con más de cinco empleados. **/
SELECT d.*
FROM departamento AS d
JOIN empleado as e ON e.depto_nro = d.depto_nro
GROUP BY d.depto_nro
HAVING COUNT(d.depto_nro)>5;

/** Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’. **/
SELECT e.nombre, e.apellido, e.salario, d.nombre_depto
FROM departamento AS d
JOIN empleado AS e ON d.depto_nro = e.depto_nro
WHERE e.puesto IN (SELECT puesto FROM empleado WHERE nombre = "Mito" AND apellido= "Barchuk");

/** Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre. **/
SELECT e.*
FROM empleado AS e
JOIN departamento AS d ON d.depto_nro = e.depto_nro
WHERE d.nombre_depto = "Contabilidad"
ORDER BY e.nombre;

/** Mostrar el nombre del empleado que tiene el salario más bajo. **/
SELECT e.nombre
FROM empleado AS e
ORDER BY e.salario
LIMIT 1;

/** Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’. **/
SELECT e.* 
FROM empleado AS e
JOIN departamento AS d ON d.depto_nro = e.depto_nro
WHERE d.nombre_depto = "Ventas" AND e.salario = 
	(SELECT e.salario 
		FROM empleado AS e 
        JOIN departamento AS d ON d.depto_nro = e.depto_nro 
        WHERE d.nombre_depto = "Ventas" 
        ORDER BY e.salario DESC 
        LIMIT 1);