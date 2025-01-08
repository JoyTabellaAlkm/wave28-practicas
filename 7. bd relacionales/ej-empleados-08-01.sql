SELECT e.nombre, e.puesto, d.localidad
FROM empleado as e
JOIN departamento as d ON d.depto_nro = e.depto_nro
WHERE e.puesto = "Vendedor";

SELECT d.nombre_depto, COUNT(e.cod_emp)
FROM departamento as d
JOIN empleado as e ON d.depto_nro = e.depto_nro
GROUP BY d.nombre_depto
HAVING COUNT(e.cod_emp) > 5;

SELECT e.nombre, e.salario, d.nombre_depto
FROM empleado e
JOIN departamento d ON d.depto_nro = e.depto_nro
WHERE e.puesto = (
	SELECT emp.puesto
    FROM empleado emp
    WHERE emp.nombre = "Mito" AND emp.apellido = "Barchuk"
 -- WHERE CONCAT(emp.nombre, " ", emp.apellido) = "Mito Barchuk"
);

SELECT e.*
FROM empleado e
JOIN departamento d ON d.depto_nro = e.depto_nro
WHERE d.nombre_depto = "Contabilidad"
ORDER BY e.nombre;

SELECT e.nombre
FROM empleado e
ORDER BY e.salario ASC
LIMIT 1;

SELECT e.*
FROM empleado e
JOIN departamento d ON d.depto_nro = e.depto_nro
WHERE d.nombre_depto = "Ventas"
ORDER BY e.salario DESC
LIMIT 1;