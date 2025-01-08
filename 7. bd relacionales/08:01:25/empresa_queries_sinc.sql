-- 1
SELECT empleado.nombre, empleado.puesto, departamento.localidad
FROM empleado
JOIN departamento ON empleado.depto_nro = departamento.depto_nro
WHERE empleado.puesto = 'Vendedor';

-- 2
SELECT departamento.nombre_depto, COUNT(empleado.cod_emp) AS numero_empleados
FROM departamento
LEFT JOIN empleado ON departamento.depto_nro = empleado.depto_nro
GROUP BY departamento.nombre_depto
HAVING COUNT(empleado.cod_emp) > 5;

-- 3
SELECT e.nombre, e.salario, d.nombre_depto
FROM empleado e
JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto = (SELECT puesto FROM empleado WHERE nombre = 'Mito' AND apellido = 'Barchuk');

-- 4
SELECT e.*
FROM empleado e
JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Contabilidad'
ORDER BY e.nombre;

-- 5
SELECT nombre, apellido
FROM empleado
WHERE salario = (SELECT MIN(salario) FROM empleado);

-- 6
SELECT e.*
FROM empleado e
JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Ventas' AND e.salario = (SELECT MAX(salario) FROM empleado WHERE depto_nro = d.depto_nro);

-- Extra
SELECT d.*
FROM departamento d
WHERE d.depto_nro IN (SELECT e.depto_nro FROM empleado e)