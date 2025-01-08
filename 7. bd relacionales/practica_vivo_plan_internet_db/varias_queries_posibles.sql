-- 1. Obtener todos los clientes con el plan de 10 Mbps:
SELECT c.nombre, c.apellido, pi.velocidad, pi.precio
FROM cliente c
JOIN cliente_plan_internet cpi ON c.id = cpi.cliente_id
JOIN plan_internet pi ON cpi.plan_internet_id = pi.id
WHERE pi.velocidad = 10;

-- 2. Contar la cantidad de clientes por cada plan de internet:
SELECT pi.velocidad, COUNT(cpi.cliente_id) AS cantidad_clientes
FROM plan_internet pi
LEFT JOIN cliente_plan_internet cpi ON pi.id = cpi.plan_internet_id
GROUP BY pi.id;

-- 3. Obtener todos los clientes de una ciudad específica (por ejemplo, "Rosario"):
SELECT nombre, apellido, ciudad
FROM cliente
WHERE ciudad = 'Rosario';

-- 4. Obtener los planes de internet con un descuento mayor al 20%:
SELECT id, velocidad, precio, descuento
FROM plan_internet
WHERE descuento > 0.20;

-- 5. Obtener los clientes que no tienen ningún plan activo:
SELECT c.nombre, c.apellido
FROM cliente c
LEFT JOIN cliente_plan_internet cpi ON c.id = cpi.cliente_id
WHERE cpi.id IS NULL;

-- 6. Obtener los planes más baratos (precio menor a 200):
SELECT id, velocidad, precio, descuento
FROM plan_internet
WHERE precio < 200;

-- 7. Obtener los clientes con el plan de mayor velocidad (por ejemplo, 200 Mbps):
SELECT c.nombre, c.apellido, pi.velocidad, pi.precio
FROM cliente c
JOIN cliente_plan_internet cpi ON c.id = cpi.cliente_id
JOIN plan_internet pi ON cpi.plan_internet_id = pi.id
WHERE pi.velocidad = 200;

-- 8. Obtener el promedio de precio de los planes de internet:
SELECT AVG(precio) AS promedio_precio
FROM plan_internet;

-- 9. Actualizar el precio de un plan específico (por ejemplo, cambiar el precio del plan con 10 Mbps):
UPDATE plan_internet
SET precio = 150.00
WHERE velocidad = 10;

-- 10. Eliminar un cliente específico por su DNI (por ejemplo, con DNI '1234567890'):
DELETE FROM cliente
WHERE dni = '1234567890';

-- 11. Obtener todos los planes de un cliente específico:
SELECT  pi.velocidad, pi.precio, pi.descuento
FROM cliente c
JOIN cliente_plan_internet cpi ON c.id = cpi.cliente_id
JOIN plan_internet pi ON cpi.plan_internet_id = pi.id
WHERE c.dni = '1234567890';
