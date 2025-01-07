-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS meli_net;
USE meli_net;

-- Crear la tabla Plan si no existe
CREATE TABLE IF NOT EXISTS plan (
    id_plan INT PRIMARY KEY AUTO_INCREMENT,
    velocidad INT,
    precio DECIMAL(10,2),
    descuento DECIMAL(5, 2)
);

-- Insertar los registros en la tabla Plan
INSERT INTO plan (velocidad, precio, descuento) VALUES
(10, 200.00, 0.0),
(20, 300.00, 10.0),
(30, 400.00, 15.0),
(50, 500.00, 20.0),
(100, 700.00, 25.0);

-- Crear la tabla Cliente si no existe
CREATE TABLE IF NOT EXISTS cliente (
    dni VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    fecha_nacimiento DATE,
    provincia VARCHAR(100),
    ciudad VARCHAR(100),
    id_plan INT,
    FOREIGN KEY (id_plan) REFERENCES Plan(id_plan)
);

-- Insertar los registros en la tabla Cliente
INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan) VALUES 
('12345678A', 'Juan', 'Pérez', '1990-01-01', 'Buenos Aires', 'Buenos Aires', 1),
('23456789B', 'María', 'Gómez', '1985-02-02', 'Córdoba', 'Córdoba', 1),
('34567890C', 'Luis', 'Fernández', '1992-03-03', 'Santa Fe', 'Santa Fe', 2),
('45678901D', 'Ana', 'López', '1994-04-04', 'Mendoza', 'Mendoza', 2),
('56789012E', 'Carlos', 'Martínez', '1988-05-05', 'Tucumán', 'San Miguel de Tucumán', 3),
('67890123F', 'Laura', 'Díaz', '1991-06-06', 'Salta', 'Salta', 3),
('78901234G', 'Javier', 'Ramírez', '1993-07-07', 'Neuquén', 'Neuquén', 4),
('89012345H', 'Sofía', 'Torres', '1995-08-08', 'Rio Negro', 'Viedma', 4),
('90123456I', 'Diego', 'Romero', '1987-09-09', 'La Pampa', 'Santa Rosa', 5),
('01234567J', 'Valentina', 'Jiménez', '1989-10-10', 'Chaco', 'Resistencia', 5);