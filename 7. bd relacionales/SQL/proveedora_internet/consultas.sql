USE empresa_internet;

-- 1. Obtener todos los clientes
SELECT * FROM cliente;
-- 2. Obtener todos los planes
SELECT * FROM plan;
-- 3. Obtener todos los clientes mayores a 35 años
SELECT nombre, apellido, TIMESTAMPDIFF(YEAR, fec_nacimiento, CURDATE()) as edad FROM cliente
WHERE TIMESTAMPDIFF(YEAR, fec_nacimiento, CURDATE()) > 35;
-- 4. Obtener el precio de plan más caro
SELECT MAX(precio) as precio FROM plan;
-- 5. Obtener el precio de plan más bajo
SELECT MIN(precio) as precio from plan;
-- 6. Obtener cliente más joven (edad)alter
SELECT nombre, apellido, TIMESTAMPDIFF(YEAR, fec_nacimiento, CURDATE()) as edad FROM cliente
ORDER BY 3
LIMIT 1;
-- 7. Obtener cliente más viejo (edad)
SELECT nombre, apellido, TIMESTAMPDIFF(YEAR, fec_nacimiento, CURDATE()) as edad FROM cliente
ORDER BY 3 DESC
LIMIT 1;
-- 8. Obtener cliente y su velocidad contratada
SELECT CONCAT(nombre, " ",apellido) as "Nombre completo", vel_megabits_por_sec as "Velocidad contratada (mb/s)" FROM cliente c
INNER JOIN plan p
ON c.id_plan = p.id_plan;
-- 9. Obtener planes con descuento
SELECT * FROM plan WHERE descuento != 0;
-- 10. Obtener clientes que paguen más de 10.000 por su plan.alter
SELECT CONCAT(nombre, " ",apellido) as "Nombre completo",
	vel_megabits_por_sec as "Velocidad contratada (mb/s)",
	p.precio as Precio
FROM cliente c
INNER JOIN plan p
ON c.id_plan = p.id_plan
WHERE p.precio > 10000;