CREATE DATABASE empresa_internet;

CREATE TABLE plan_internet(
  id int auto_increment PRIMARY KEY,
  velocidad float,
  precio float,
  descuento float
);

CREATE TABLE cliente(
    id int auto_increment PRIMARY KEY,
    dni varchar(20),
    nombre varchar(200),
    apellido varchar(200),
    fecha_nacimiento date,
    provincia varchar(200),
    ciudad varchar(200),
    id_plan_internet int,
    FOREIGN KEY (id_plan_internet) REFERENCES plan_internet(id)
);

INSERT INTO plan_internet (velocidad, precio, descuento) VALUES
 (50, 29.99, 0),
 (100, 39.99, 5),
 (200, 49.99, 10),
 (500, 69.99, 15),
 (1000, 89.99, 20);

INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan_internet) VALUES
('12345678A', 'Juan', 'Pérez', '1985-04-23', 'Madrid', 'Madrid', 1),
('23456789B', 'Maria', 'Gómez', '1978-07-19', 'Barcelona', 'Barcelona', 2),
('34567890C', 'Luis', 'Martínez', '1990-10-11', 'Valencia', 'Valencia', 3),
('45678901D', 'Ana', 'López', '1980-12-01', 'Sevilla', 'Sevilla', 1),
('56789012E', 'Pedro', 'Fernández', '1995-05-20', 'Valencia', 'Valencia', 2),
('67890123F', 'Laura', 'Sánchez', '1983-09-15', 'Sevilla', 'Sevilla', 4),
('78901234G', 'Eduardo', 'Ramírez', '1975-11-03', 'Sevilla', 'Sevilla', 5),
('89012345H', 'Sandra', 'Vidal', '1992-03-08', 'Valencia', 'Valencia', 3),
('90123456I', 'José', 'Gil', '1988-02-25', 'Barcelona', 'Barcelona', 4),
('98765432J', 'Beatriz', 'Pérez', '1986-06-12', 'Barcelona', 'Barcelona', 5);

-- Obtener los nombres y apellidos de los clientes que tienen planes con velocidades superiores a 100 Mbps
SELECT c.nombre, c.apellido
FROM cliente c
 JOIN plan_internet p ON c.id_plan_internet = p.id
WHERE p.velocidad > 100;

-- Encontrar el plan más común entre los clientes y mostrar su velocidad, precio y descuento
SELECT p.velocidad, p.precio, p.descuento
FROM plan_internet p
 JOIN cliente c ON p.id = c.id_plan_internet
GROUP BY p.id
ORDER BY COUNT(c.id) DESC
LIMIT 1;

-- Listar todos los nombres de clientes y el total de descuento que reciben con el plan que tienen
SELECT c.nombre, c.apellido, p.descuento
FROM cliente c
 JOIN plan_internet p ON c.id_plan_internet = p.id;

-- Obtener la ciudad con el menor número de clientes, junto con el conteo de esos clientes
SELECT ciudad, COUNT(*) AS numero_clientes
FROM cliente
GROUP BY ciudad
ORDER BY numero_clientes ASC
LIMIT 1;