
#1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT
	CONCAT(empleado.nombre, " ", empleado.apellido) as "Nombre y Apellido",
    empleado.puesto,
    departamento.nombre_depto,
    departamento.localidad
FROM
    departamento
        INNER JOIN
    empleado ON departamento.depto_nro = empleado.depto_nro;

#2. Visualizar los departamentos con más de cinco empleados.
SELECT
    de.nombre_depto, COUNT(*) AS total
FROM
    departamento AS de
        INNER JOIN
    empleado AS em ON de.depto_nro = em.depto_nro
GROUP BY em.depto_nro
HAVING total > 2;

#3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT
    empleado.nombre, empleado.salario, departamento.nombre_depto
FROM
    empleado
        INNER JOIN
    departamento ON empleado.depto_nro = departamento.depto_nro
WHERE
    empleado.puesto = (SELECT
            puesto
        FROM
            empleado
        WHERE
            nombre = 'Daniel'
                AND apellido = 'Brezezicki');

#4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT
    empleado.*
FROM
    empleado
        LEFT JOIN
    departamento ON empleado.depto_nro = departamento.depto_nro
WHERE
    LOWER(d.nombre_depto) = 'contabilidad'
ORDER BY empleado.nombre ASC;

#5. Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT
    empleado.*
FROM
    empleado
        LEFT JOIN
    departamento ON empleado.depto_nro = departamento.depto_nro
    ORDER BY salario ASC LIMIT 1;


#6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT
    empleado.*
FROM
    empleado
        INNER JOIN
    departamento ON empleado.depto_nro = departamento.depto_nro
WHERE
    departamento.nombre_depto = 'Ventas'
        AND empleado.salario = (SELECT
            MAX(salario)
        FROM
            empleado e2
                INNER JOIN
            departamento d2 ON e2.depto_nro = d2.depto_nro
        WHERE
            d2.nombre_depto = 'Ventas');


