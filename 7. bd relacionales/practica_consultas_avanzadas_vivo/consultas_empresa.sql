/*
1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
2. Visualizar los departamentos con más de cinco empleados.
3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
5. Mostrar el nombre del empleado que tiene el salario más bajo.
6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
*/

-- 1.
SELECT dp.nombre_depto, emp.puesto, dp.localidad FROM departamentos as dp INNER JOIN empleados AS emp ON emp.depto_nro = dp.depto_nro WHERE emp.puesto = "Vendedor";

-- 2.
SELECT dp.nombre_depto FROM departamentos AS dp INNER JOIN empleados AS emp ON emp.depto_nro = dp.depto_nro GROUP BY emp.depto_nro HAVING count(emp.nombre)>1;

-- 3. 
SELECT emp.nombre, emp.salario, dp.nombre_depto FROM departamentos AS dp INNER JOIN empleados AS emp ON emp.depto_nro = dp.depto_nro
WHERE emp.puesto IN (SELECT puesto FROM empleados WHERE nombre = "Mito" AND apellido = "Barchuk");

-- 4.
SELECT emp.* FROM departamentos AS dp INNER JOIN empleados AS emp ON emp.depto_nro = dp.depto_nro
WHERE dp.nombre_depto = "Contabilidad" ORDER BY emp.nombre;

-- 5.
SELECT nombre, apellido FROM empleados WHERE salario IN (SELECT MIN(salario) FROM empleados);

-- 6.
SELECT * FROM empleados WHERE salario = 
(SELECT MAX(salario) FROM departamentos AS dp INNER JOIN empleados AS emp ON emp.depto_nro = dp.depto_nro WHERE dp.nombre_depto = "Ventas");

 