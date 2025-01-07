CREATE DATABASE empresa_internet;


CREATE TABLE plan_internet (
    id INT PRIMARY KEY,
    velocidad_megas INT,
    precio DECIMAL(10, 2),
    descuento DECIMAL(5, 2)
);

CREATE TABLE cliente (
    dni INT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    fecha_nacimiento DATE,
    provincia VARCHAR(50),
    ciudad VARCHAR(50),
	plan_internet_id int,
	FOREIGN KEY (plan_internet_id) REFERENCES plan_internet(id)
);

INSERT INTO plan_internet (id, velocidad_megas, precio, descuento) VALUES
(1, 50, 2000.00, 10.00),
(2, 100, 3000.00, 15.00),
(3, 200, 4000.00, 20.00),
(4, 500, 6000.00, 25.00),
(5, 1000, 10000.00, 30.00);

select * from plan_internet;

INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, plan_internet_id) VALUES
(12345678, 'Juan', 'Pérez', '1990-05-14', 'Buenos Aires', 'La Plata', 1),
(23456789, 'María', 'Gómez', '1985-11-22', 'Córdoba', 'Córdoba', 1),
(34567890, 'Pedro', 'López', '1992-03-10', 'Santa Fe', 'Rosario', 1),
(45678901, 'Lucía', 'Martínez', '1998-08-30', 'Mendoza', 'Mendoza', 2),
(56789012, 'Sofía', 'Fernández', '1995-12-05', 'Salta', 'Salta', 2),
(67890123, 'Martín', 'Rodríguez', '1987-07-20', 'Tucumán', 'San Miguel de Tucumán', 2),
(78901234, 'Ana', 'Sánchez', '1993-01-15', 'Neuquén', 'Neuquén', 3),
(89012345, 'Carla', 'Herrera', '1999-06-12', 'Chaco', 'Resistencia', 4),
(90123456, 'Diego', 'Ríos', '1986-09-25', 'Misiones', 'Posadas', 4),
(10234567, 'Laura', 'Torres', '1991-04-18', 'San Juan', 'San Juan', 2);

select * from cliente;

/*Plantear 10 consultas SQL que se podrían realizar a la base de datos. Expresar las sentencias.*/
/*Traer clientes cuyo nombre sea Laura*/
Select * from cliente c where c.nombre = 'Laura'; 

/*Traer clientes cuyo plan sea el 1*/
Select * from cliente c where c.plan_internet_id = 1; 

/*Contar cuantos clientes tiene la empresa*/
Select count(*) as cantidadClientes from cliente c; 

/*Cual es el cliente mas grande*/ 
select * from cliente c order by fecha_nacimiento ASC limit 1 ;

/*Cual es el plan con mayor descuento*/ 
select * from plan_internet p order by descuento DESC limit 1 ;

/*Cual es el precio del plan sin descuento aplicado */ 
select ((precio/(100-descuento))*descuento)+precio  as precio_oficial from plan_internet;
select precio / (1 - descuento / 100)  as precio_oficial from plan_internet;

/*Cantidad de clientes por plan*/
select plan_internet_id, count(*) as clientes_x_plan from cliente c group by plan_internet_id;  



