-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select em.nombre, em.puesto, dep.localidad from empleado em
join departamento dep on em.depto_nro = dep.depto_nro
where em.puesto = "Vendedor";

-- Visualizar los departamentos con más de dos empleados.
select dep.nombre_depto from departamento dep
join empleado em on em.depto_nro = dep.depto_nro
group by em.depto_nro having count(em.nombre) > 2;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select em.nombre, em.salario, dep.nombre_depto from empleado em
join departamento dep on em.depto_nro = dep.depto_nro
where puesto = (select puesto from empleado where nombre = 'Mito' and apellido = 'Barchuk');

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select em.* from empleado em
join departamento dep on em.depto_nro = dep.depto_nro
where dep.nombre_depto = "Contabilidad" order by em.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
select nombre from empleado order by salario asc limit 1;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select em.* from empleado em
join departamento dep on em.depto_nro = dep.depto_nro
where dep.nombre_depto = 'Ventas' order by em.salario desc limit 1;