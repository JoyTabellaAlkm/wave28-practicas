-- 1. Seleccionar todos los clientes.
SELECT * FROM cliente;

-- 2. Seleccionar todos los planes con velocidad superior a 20 megas.
SELECT * FROM plan WHERE velocidad > 20;

-- 3. Contar el número de clientes por provincia (sin GROUP BY - requiere una subconsulta).
SELECT DISTINCT provincia, (SELECT COUNT(*) FROM cliente AS c WHERE c.provincia = cliente.provincia) AS numero_clientes
FROM cliente;  -- Limitar a un resultado para que no arroje duplicados 

-- 4. Obtener el plan más caro.
SELECT id_plan FROM plan ORDER BY precio DESC LIMIT 1;

-- 5. Listar nombres y apellidos de clientes que nacieron después de 1990.
SELECT nombre, apellido 
FROM cliente 
WHERE fecha_nacimiento > '1990-01-01';

-- 6. Seleccionar todos los planes con descuento.
SELECT * FROM plan WHERE descuento > 0;

-- 7. Actualizar el precio de los planes que tienen una velocidad de 100 megas.
UPDATE plan SET precio = precio * 1.10 WHERE velocidad = 100;

-- 8. Eliminar a los clientes que no tienen un plan asociado.
DELETE FROM cliente WHERE id_plan IS NULL;

-- 9. Seleccionar el plan más económico.
SELECT * FROM plan ORDER BY precio ASC LIMIT 1;

-- 10. Obtener la cantidad total de dinero que se generará con los precios de los planes contratados por los clientes.
SELECT SUM(precio) AS total_ingresos
FROM plan 
WHERE id_plan IN (SELECT id_plan FROM cliente);

INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan) VALUES ('012324567J', 'Francisco', 'Jiménez', '1989-12-10', 'Chaco', 'Resistencia', 3);