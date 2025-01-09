-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT empleado.nombre, empleado.puesto, departamento.localidad 
FROM empleado INNER JOIN departamento
ON empleado.depto_nro = departamento.depto_nro
WHERE puesto = "Vendedor";

-- Visualizar los departamentos con más de cinco empleados.
SELECT departamento.nombre_depto FROM departamento
INNER JOIN empleado ON empleado.depto_nro = departamento.depto_nro
GROUP BY empleado.depto_nro HAVING count(empleado.cod_emp) >= 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT em.nombre, em.apellido, em.salario, depa.nombre_depto FROM empleado em
INNER JOIN departamento depa ON em.depto_nro = depa.depto_nro
WHERE em.puesto = (
    SELECT puesto 
    FROM empleado
    WHERE nombre = 'Mito' AND apellido = 'Barchuk'
);

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT * FROM empleado INNER JOIN departamento
ON empleado.depto_nro = departamento.depto_nro
WHERE departamento.nombre_depto = 'Contabilidad'
ORDER BY empleado.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre, salario FROM empleado
WHERE salario = (SELECT MIN(salario) FROM empleado);

SELECT nombre, salario FROM empleado ORDER BY salario ASC LIMIT 1;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT empleado.nombre, empleado.salario, departamento.nombre_depto FROM empleado
INNER JOIN departamento ON empleado.depto_nro = departamento.depto_nro
WHERE salario = (SELECT MAX(salario) FROM empleado WHERE depto_nro = 'D-000-4');

