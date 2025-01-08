# Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select em.nombre, em.puesto, de.localidad
from empleado em
inner join departamento de on em.depto_nro = de.depto_nro
where em.puesto = "Vendedor";

# Visualizar los departamentos con más de dos empleados.
select de.nombre_depto
from empleado em
inner join departamento de on em.depto_nro = de.depto_nro
group by em.depto_nro
having count(1) > 5;

# Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select em.nombre, em.salario, de.nombre_depto
from empleado em
inner join departamento de on em.depto_nro = de.depto_nro
where em.puesto = (select puesto from empleado where nombre = "Mito" and apellido = "Barchuk");

# Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select em.*
from empleado em inner join departamento de on em.depto_nro = de.depto_nro
where de.nombre_depto = "contabilidad"
order by em.nombre;

# Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre
FROM empleado
ORDER BY salario ASC
LIMIT 1;

# Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select e.*
from empleados e inner join departamentos d on e.depto_nro=d.depto_nro
where e.salario = (
	select max(salario)
	from empleados e inner join departamentos d on e.depto_nro=d.depto_nro
    where d.nombre_depto = "ventas"
);

# Opcion 2
SELECT em.*
FROM empleados em
INNER JOIN departamentos de ON em.depto_nro = de.depto_nro
WHERE de.nombre_depto = 'Ventas'
ORDER BY em.salario DESC
LIMIT 1;