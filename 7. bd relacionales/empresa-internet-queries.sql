-- 1. Buscar los clientes que tengan más de 30 años.
select first_name, last_name from clients where (2025 - year(birthdate)) > 30;

-- 2. Buscar los clientes cuyo apellido termine en 'ez'.
select first_name, last_name from clients where lower(last_name) like '%ez';

-- 3. Buscar los planes de internet cuyo precio sea menor a 3000.
select id, speed, price, discount from packages where price < 3000;

-- 4. Buscar los planes de internet cuya velocidad sea mayor o igual a 100 y el precio sea menor a 3000.
select id, speed, price, discount from packages where speed >= 100 and price < 3000;

-- 5. Buscar los clientes que hayan nacido en la década de los 90's.
select first_name, last_name from clients where year(birthdate) between 1990 and 1999;

-- 6. Buscar los clientes que sean de Buenos Aires.
select first_name, last_name from clients where department = 'Buenos Aires';

-- 7. Buscar todos los planes de internet.
select * from packages;

-- 8. Buscar todos los clientes.
select * from clients;

-- 9. Buscar todos los clientes cuyo nombre empiece por la letra 'm'.
select first_name, last_name from clients where lower(first_name) like 'm%';

-- 10. Buscar todos los clientes que hayan nacido entre el día 20 y el día 30.
select first_name, last_name from clients where day(birthdate) between 20 and 30;
