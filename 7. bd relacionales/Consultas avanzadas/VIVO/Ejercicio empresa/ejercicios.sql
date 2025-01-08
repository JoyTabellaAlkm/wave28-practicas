-- 1 Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select em.nombre, em.puesto, dep.localidad from empleado em
left join departamento dep on em.depto_nro = dep.depto_nro where em.puesto like 'Vendedor';

-- 2 Visualizar los departamentos con más de cinco empleados.
select d.*, count(e.depto_nro) empleados from departamento d
inner join empleado e on d.depto_nro = e.depto_nro group by d.depto_nro having empleados > 2;

-- 3 Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select e.nombre,e.apellido, e.salario,e.puesto, d.nombre_depto from empleado e
inner join departamento d on e.depto_nro = d.depto_nro
where e.puesto in (select puesto from empleado where nombre like 'Mito' and apellido like 'Barchuk');

-- 4 Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select e.* from empleado e
where e.depto_nro in (select depto_nro from departamento where nombre_depto like 'Contabilidad') order by nombre asc;

select e.* from empleado e
join departamento d on e.depto_nro = d.depto_nro
where d.nombre_depto  like 'Contabilidad' order by nombre asc;

-- 5 Mostrar el nombre del empleado que tiene el salario más bajo.
select e.nombre, e.salario from empleado e order by salario asc limit 1;

-- 6 Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select e.nombre, e.salario from empleado e
join departamento d on e.depto_nro = d.depto_nro
where d.nombre_depto  like 'Ventas'
order by salario desc limit 1;