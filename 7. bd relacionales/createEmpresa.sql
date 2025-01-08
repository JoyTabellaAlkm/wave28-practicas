-- Crear la base de datos
CREATE DATABASE empresa_db;

-- Usar la base de datos
USE empresa_db;

-- Crear tabla DEPARTAMENTO
CREATE TABLE departamento (
    depto_nro VARCHAR(10) PRIMARY KEY,
    nombre_depto VARCHAR(50),
    localidad VARCHAR(50)
);

-- Insertar registros en DEPARTAMENTO
INSERT INTO departamento (depto_nro, nombre_depto, localidad) VALUES 
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');

-- Crear tabla EMPLEADO
CREATE TABLE empleado (
    cod_emp VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    puesto VARCHAR(50),
    fecha_alta DATE,
    salario DECIMAL(10,2),
    comision DECIMAL(10,2),
    depto_nro VARCHAR(10),
    FOREIGN KEY (depto_nro) REFERENCES departamento(depto_nro)
);

-- Insertar registros en EMPLEADO
INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
('E-0005', 'Daniel', 'Brezecicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1'),
('E-0008', 'Luisa', 'Pérez', 'Vendedor', '2019-01-10', 75000, 12000, 'D-000-4'),
('E-0009', 'Carlos', 'Rodríguez', 'Vendedor', '2020-09-15', 78000, 13000, 'D-000-4');
('E-0010', 'Ana', 'Muñoz', 'Presidente', '2023-10-01', 200000, 0, 'D-000-2');