#Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select e.nombre, e.puesto, d.localidad
from empleados e inner join departamentos d on e.depto_nro=d.depto_nro
where e.puesto = "vendedor";


#Visualizar los departamentos con más de dos empleados.
select d.nombre_depto
from empleados e inner join departamentos d on e.depto_nro=d.depto_nro
group by e.depto_nro
having count(1) > 2;


#Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select e.nombre, e.salario, d.nombre_depto
from empleados e inner join departamentos d on e.depto_nro=d.depto_nro
where e.puesto = (select puesto from empleados where nombre = "Mito" and apellido = "Barchuk");


#Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select e.*
from empleados e inner join departamentos d on e.depto_nro=d.depto_nro
where d.nombre_depto = "Contabilidad"
order by e.nombre;


#Mostrar el nombre del empleado que tiene el salario más bajo.
select nombre
from empleados
where salario = (select min(salario) from empleados);



#Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select e.*
from empleados e inner join departamentos d on e.depto_nro=d.depto_nro
where e.salario = (
	select max(salario)
	from empleados e inner join departamentos d on e.depto_nro=d.depto_nro
    where d.nombre_depto = "ventas"
);

#Opcion 2
SELECT em.*
FROM empleados em
         INNER JOIN departamentos de ON em.depto_nro = de.depto_nro
WHERE de.nombre_depto = 'Ventas'
ORDER BY em.salario DESC
    LIMIT 1;