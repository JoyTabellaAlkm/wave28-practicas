DROP SCHEMA IF EXISTS depto_emp_ejs;
CREATE SCHEMA depto_emp_ejs;
USE depto_emp_ejs;
-- === DDL === 
drop table if exists departamento;
create table departamento (
	    depto_nro varchar(50) primary key,
        nombre_depto varchar(50),
        localidad varchar(50)
);

drop table if exists empleado;
create table empleado(
	cod_emp varchar(50) primary key,
    nombre varchar(50),
    apellido varchar(50),
    puesto varchar(50),
    fecha_alta date,
    salario int,
    comision int,
    depto_nro varchar(50),
    constraint FK_depto_nro foreign key (depto_nro) references departamento (depto_nro)
);

INSERT INTO departamento (depto_nro, nombre_depto, localidad) VALUES
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');


INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');


-- === DML === 

-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select e.nombre, e.puesto, d.localidad
from departamento as d
inner join empleado as e on d.depto_nro = e.depto_nro
where e.puesto = 'Vendedor';

-- 2. Visualizar los departamentos con más de cinco empleados.
-- OPCION 1 (mostrando campos limitados)
select d.nombre_depto, count(*) as cant_empleados
from departamento as d 
inner join empleado as e on d.depto_nro = e.depto_nro
group by d.nombre_depto 
having cant_empleados > 5;
-- OPCION 2 (mostrando todos los campos)
select * from departamento as d
where d.depto_nro in (
	select d.depto_nro 
    from departamento as d 
    inner join empleado as e on d.depto_nro = e.depto_nro
	group by d.depto_nro 
    having count(*) > 1
);
-- 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select e.nombre, e.salario, d.nombre_depto 
from empleado as e 
inner join departamento as d on e.depto_nro = d.depto_nro
where e.puesto = (
	select e.puesto
    from empleado as e 
    where e.nombre = "Mito" and e.apellido = "Barchuk"
);

-- 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select e.*, d.nombre_depto 
from empleado as e 
inner join departamento as d on e.depto_nro = d.depto_nro
where d.nombre_depto = 'Contabilidad'
order by e.nombre;

-- 5. Mostrar el nombre del empleado que tiene el salario más bajo.
-- OPCION 1
select nombre from empleado order by salario asc limit 1;
-- OPCION 2
SELECT nombre
FROM empleado
WHERE salario = (
	SELECT min(salario) FROM empleado
);
-- 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select e.*, d.nombre_depto 
from empleado as e 
inner join departamento as d on e.depto_nro = d.depto_nro
where d.nombre_depto = 'Ventas'
order by salario desc
limit 1;