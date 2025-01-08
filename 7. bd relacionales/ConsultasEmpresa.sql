-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select empleado.nombre, empleado.apellido, empleado.puesto, departamento.localidad from empleado 
inner join departamento on empleado.depto_nro = departamento.depto_nro
where empleado.puesto = 'Vendedor';

-- Visualizar los departamentos con más de cinco empleados.
SELECT departamento.*, COUNT(empleado.cod_emp) AS numero_empleados FROM departamento
JOIN empleado ON departamento.depto_nro = empleado.depto_nro
GROUP BY departamento.depto_nro HAVING COUNT(empleado.cod_emp) >= 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select empleado.nombre, empleado.salario, departamento.nombre_depto from empleado inner join departamento on departamento.depto_nro = empleado.depto_nro 
where empleado.puesto = (select puesto from empleado where nombre = 'Mito' and apellido = 'Barchuk');

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select empleado.* from empleado inner join departamento on departamento.depto_nro = empleado.depto_nro
where departamento.depto_nro = 'D-000-3' order by empleado.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo
SELECT nombre, apellido, salario FROM empleado WHERE salario = (SELECT MIN(salario) FROM empleado);
SELECT nombre, apellido,salario FROM empleado ORDER BY salario ASC LIMIT 1;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select empleado.* from empleado inner join departamento on departamento.depto_nro = empleado.depto_nro
where empleado.salario = (SELECT MAX(salario) FROM empleado where depto_nro='D-000-4');
