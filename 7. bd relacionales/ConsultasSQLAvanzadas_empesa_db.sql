-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.apellido, e.puesto, d.nombre_depto, d.localidad
FROM empleado e
INNER JOIN departamente d on d.depto_nro = e.depto_nro;
-- Visualizar los departamentos con más de cinco empleados.
SELECT d.depto_nro, d.nombre_depto, d.localidad
FROM empleado e
INNER JOIN departamente d on d.depto_nro = e.depto_nro
GROUP BY e.depto_nro
HAVING count(1) > 5;
-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto
FROM empleado e
INNER JOIN departamente d on d.depto_nro = e.depto_nro
WHERE e.puesto = (SELECT puesto FROM empleado WHERE nombre = 'Mito' AND apellido = 'Barchuk');
-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.*
FROM empleado e
INNER JOIN departamente d on d.depto_nro = e.depto_nro
WHERE d.nombre_depto = 'contabilidad'
ORDER BY e.nombre;
-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre
FROM empleado
where salario = (select min(salario) from empleado);
-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT nombre
FROM empleado
where salario = (select MAX(salario) from empleado where depto_nro = 'D-000-4');