-- 1. Seleccionar todos los clientes.
SELECT * FROM Cliente;

-- 2. Seleccionar todos los planes con velocidad superior a 20 megas.
SELECT * FROM Plan WHERE Velocidad > 20;

-- 3. Contar el número de clientes por provincia (sin GROUP BY - requiere una subconsulta).
SELECT Provincia, (SELECT COUNT(*) FROM Cliente AS C WHERE C.Provincia = Cliente.Provincia) AS Numero_Clientes
FROM Cliente
LIMIT 1;  -- Limitar a un resultado para que no arroje duplicados 

-- 4. Obtener el plan más caro.
SELECT ID_Plan FROM Plan ORDER BY Precio DESC LIMIT 1;

-- 5. Listar nombres y apellidos de clientes que nacieron después de 1990.
SELECT Nombre, Apellido 
FROM Cliente 
WHERE Fecha_Nacimiento > '1990-01-01';

-- 6. Seleccionar todos los planes con descuento.
SELECT * FROM Plan WHERE Descuento > 0;

-- 7. Actualizar el precio de los planes que tienen una velocidad de 100 megas.
UPDATE Plan SET Precio = Precio * 1.10 WHERE Velocidad = 100;

-- 8. Eliminar a los clientes que no tienen un plan asociado.
DELETE FROM Cliente WHERE ID_Plan IS NULL;

-- 9. Seleccionar el plan más económico.
SELECT * FROM Plan ORDER BY Precio ASC LIMIT 1;

-- 10. Obtener la cantidad total de dinero que se generará con los precios de los planes contratados por los clientes.
SELECT SUM(Precio) AS Total_Ingresos
FROM Plan 
WHERE ID_Plan IN (SELECT ID_Plan FROM Cliente);