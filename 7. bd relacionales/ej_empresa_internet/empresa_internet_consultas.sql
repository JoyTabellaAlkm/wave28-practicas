-- Encontrar todos los clientes en la provincia de buenos aires
select nombre, apellido, dni from cliente where provincia = 'Buenos Aires';
-- Encontrar todos los clientes con plan 1
Select nombre, apellido, dni 
from cliente A 
inner join cliente_plan_internet B on A.id = B.cliente_id
where B.plan_internet_id = 1;
-- Encontrar todos los planes con mas de 5% de descuento
Select id, velocidad, precio, descuento from plan_internet where descuento > 0.05;
-- Encontrar los tres planes mas caros de internet
Select id, velocidad, precio, descuento from plan_internet order by precio desc limit 3;
-- Encontrar el plan de internet mas barato 
Select id, velocidad, precio, descuento from plan_internet order by precio asc limit 1;
-- Encontrar los clientes nacidos entre 1980 y 1990
select nombre, apellido, dni, fecha_nacimiento from cliente where year(fecha_nacimiento) between 1980 and 1990;
-- Encontrar los primeros 5 clientes
select nombre, apellido, dni, fecha_nacimiento from cliente limit 5;
-- Encontrar los 2 planes mas veloces
Select id, velocidad, precio, descuento from plan_internet order by velocidad desc limit 2;
-- Encontrar los clientes que se llamen Juan
select nombre, apellido, dni from cliente where nombre = 'juan';
-- Ordernar los clientes por fecha de nacimiento
select nombre, apellido, dni, fecha_nacimiento from cliente order by fecha_nacimiento;
-- Mostrar cuantos clientes contrataron cada plan
select count(1), plan_internet_id
from cliente_plan_internet
group by plan_internet_id




