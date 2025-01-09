SELECT t.nombre, t.puesto, dp.localidad
FROM DEPARTAMENTO dp
JOIN EMPLEADO t ON t.depto_nro= dp.depto_nro
WHERE t.puesto = 'Vendedor';

SELECT COUNT(*) AS Cantidad, dp.nombre_dpto
FROM  DEPARTAMENTO dp
JOIN EMPLEADO t ON t.depto_nro = dp.depto_nro
GROUP BY dp.nombre_dpto HAVING Cantidad > 5;

SELECT t.nombre, t.salario, dp.nombre_dpto
FROM DEPARTAMENTO dp
JOIN EMPLEADO t ON t.depto_nro = dp. depto_nro
WHERE t.puesto =
(SELECT t.puesto
	FROM EMPLEADO t
	WHERE(t.nombre = 'Mito' AND t.apellido = 'Barchuk'));

SELECT *
 FROM EMPLEADO t
 JOIN DEPARTAMENTO dp ON t.depto_nro = dp. depto_nro
 WHERE dp.nombre_dpto = 'Contabilidad' ORDER BY t.nombre;

SELECT t.nombre FROM EMPLEADO t ORDER BY t.salario LIMIT 1;

SELECT t.nombre, t.salario, dp.nombre_dpto
FROM DEPARTAMENTO dp
JOIN EMPLEADO t ON t.depto_nro = dp. depto_nro
WHERE dp.nombre_dpto = 'Ventas'
ORDER BY t.salario DESC LIMIT 1;