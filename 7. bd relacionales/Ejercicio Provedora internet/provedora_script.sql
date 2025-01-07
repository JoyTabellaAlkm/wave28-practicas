-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS empresa_internet;
USE empresa_internet;

-- Crear la tabla Plan si no existe
CREATE TABLE IF NOT EXISTS Plan (
    ID_Plan INT PRIMARY KEY AUTO_INCREMENT,
    Velocidad INT,
    Precio DECIMAL(10,2),
    Descuento DECIMAL(5, 2)
);

-- Insertar los registros en la tabla Plan
INSERT INTO Plan (Velocidad, Precio, Descuento) VALUES
(10, 200.00, 0.0),
(20, 300.00, 10.0),
(30, 400.00, 15.0),
(50, 500.00, 20.0),
(100, 700.00, 25.0);

-- Crear la tabla Cliente si no existe
CREATE TABLE IF NOT EXISTS Cliente (
    DNI VARCHAR(20) PRIMARY KEY,
    Nombre VARCHAR(100),
    Apellido VARCHAR(100),
    Fecha_Nacimiento DATE,
    Provincia VARCHAR(100),
    Ciudad VARCHAR(100),
    ID_Plan INT,
    FOREIGN KEY (ID_Plan) REFERENCES Plan(ID_Plan)
);

-- Insertar los registros en la tabla Cliente
INSERT INTO Cliente (DNI, Nombre, Apellido, Fecha_Nacimiento, Provincia, Ciudad, ID_Plan) VALUES 
('12345678', 'Juan', 'Pérez', '1990-01-01', 'Buenos Aires', 'Buenos Aires', 1),
('123456100', 'Lucia', 'Pérez', '1990-01-01', 'Buenos Aires', 'Buenos Aires', 2),
('23456789', 'María', 'Gómez', '1985-02-02', 'Córdoba', 'Córdoba', 1),
('34567890', 'Luis', 'Fernández', '1992-03-03', 'Santa Fe', 'Santa Fe', 2),
('45678901', 'Ana', 'López', '1994-04-04', 'Mendoza', 'Mendoza', 2),
('56789012', 'Carlos', 'Martínez', '1988-05-05', 'Tucumán', 'San Miguel de Tucumán', 3),
('67890123', 'Laura', 'Díaz', '1991-06-06', 'Salta', 'Salta', 3),
('78901234', 'Javier', 'Ramírez', '1993-07-07', 'Neuquén', 'Neuquén', 4),
('89012345', 'Sofía', 'Torres', '1995-08-08', 'Rio Negro', 'Viedma', 4),
('90123456', 'Diego', 'Romero', '1987-09-09', 'La Pampa', 'Santa Rosa', 5),
('01234567', 'Valentina', 'Jiménez', '1989-10-10', 'Chaco', 'Resistencia', 5);