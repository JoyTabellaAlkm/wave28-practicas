select * from DEPARTAMENTO;
select * from EMPLEADO;

CREATE TABLE DEPARTAMENTO (
    depto_nro VARCHAR(10) PRIMARY KEY,
    nombre_depto VARCHAR(50) NOT NULL,
    localidad VARCHAR(50) NOT NULL
);

CREATE TABLE EMPLEADO (
    cod_emp VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    puesto VARCHAR(50) NOT NULL,
    fecha_alta DATE NOT NULL,
    salario DECIMAL(10, 2) NOT NULL,
    comision DECIMAL(10, 2) NOT NULL,
    depto_nro VARCHAR(10) NOT NULL,
    FOREIGN KEY (depto_nro) REFERENCES DEPARTAMENTO(depto_nro)
);

INSERT INTO DEPARTAMENTO (depto_nro, nombre_depto, localidad) VALUES
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');

INSERT INTO EMPLEADO (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
('E-0005', 'Daniel', 'Brezecizki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');

-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select em.nombre, em.puesto, dep.localidad
from EMPLEADO em
join DEPARTAMENTO dep on em.depto_nro = dep.depto_nro; 

-- Visualizar los departamentos con más de cinco empleados.
select dep.depto_nro, dep.localidad, dep.nombre_depto, count(em.cod_emp) as total_empleados from DEPARTAMENTO dep
join EMPLEADO em on em.depto_nro = dep.depto_nro
group by dep.depto_nro, dep.nombre_depto, dep.localidad
having count(em.cod_emp) > 1;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select em.nombre, em.salario, dep.nombre_depto
from EMPLEADO em
join DEPARTAMENTO dep on em.depto_nro = dep.depto_nro
where em.puesto = 'Presidente';

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT * FROM EMPLEADO em
JOIN DEPARTAMENTO dep ON em.depto_nro = dep.depto_nro
WHERE dep.nombre_depto = 'Contabilidad'
ORDER BY em.nombre ASC;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT em.nombre
FROM EMPLEADO em
WHERE em.salario = (SELECT MIN(salario) FROM EMPLEADO);

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT em.*
FROM EMPLEADO em
WHERE em.depto_nro = (
    SELECT dep.depto_nro
    FROM DEPARTAMENTO dep
    WHERE dep.nombre_depto = 'Ventas'
)
AND em.salario = (
    SELECT MAX(e.salario)
    FROM EMPLEADO e
    WHERE e.depto_nro = em.depto_nro
);

