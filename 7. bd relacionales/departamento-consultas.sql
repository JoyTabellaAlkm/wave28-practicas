-- Crear tabla DEPARTAMENTO
CREATE TABLE DEPARTAMENTO (
    depto_nro CHAR(6) PRIMARY KEY,
    nombre_depto VARCHAR(50),
    localidad VARCHAR(50)
);
-- Insertar datos en DEPARTAMENTO
INSERT INTO DEPARTAMENTO (depto_nro, nombre_depto, localidad) VALUES
('D-0001', 'Software', 'Los Tigres'),
('D-0002', 'Sistemas', 'Guadalupe'),
('D-0003', 'Contabilidad', 'La Roca'),
('D-0004', 'Ventas', 'Plata');
-- Crear tabla EMPLEADO
CREATE TABLE EMPLEADO (
    cod_emp CHAR(6) PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    puesto VARCHAR(50),
    fecha_alta DATE,
    salario DECIMAL(10, 2),
    comision DECIMAL(10, 2),
    depto_nro CHAR(6),
    FOREIGN KEY (depto_nro) REFERENCES DEPARTAMENTO(depto_nro)
);
-- Insertar datos en EMPLEADO
INSERT INTO EMPLEADO (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-0004'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-0002'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-0003'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-0004'),
('E-0005', 'Daniel', 'Brezezciki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-0004'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-0003'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-0001');
-- Primero
SELECT em.nombre, em.puesto, dep.localidad FROM empleado em INNER JOIN departamento dep ON em.depto_nro = dep.depto_nro WHERE dep.nombre_depto = "Ventas";
-- Segundo
SELECT nombre_depto FROM departamento dep INNER JOIN empleado em ON em.depto_nro = dep.depto_nro GROUP BY dep.depto_nro HAVING count(*) > 5;
-- Tercero
SELECT em.nombre, em.salario, dep.nombre_depto FROM empleado em INNER JOIN departamento dep ON
em.depto_nro = dep.depto_nro WHERE em.puesto IN (SELECT puesto FROM empleado WHERE nombre = "Mito" && apellido="Barchuk");
-- Cuarto
SELECT em.* FROM empleado em INNER JOIN departamento dep ON em.depto_nro = dep.depto_nro WHERE dep.nombre_depto = "contabilidad" ORDER BY em.nombre;
 -- Quinto
SELECT nombre, salario FROM empleado WHERE salario = (SELECT MIN(salario) FROM empleado);
-- Sexto
SELECT * FROM empleado WHERE salario =
(SELECT MAX(salario) FROM departamento AS dp
INNER JOIN empleado AS emp ON
 emp.depto_nro = dp.depto_nro WHERE dp.nombre_depto = "Ventas");
