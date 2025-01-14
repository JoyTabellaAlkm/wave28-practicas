
# a. ¿Cuál es la primary key para la tabla de clientes? Justificar respuesta
# La primary key la definimos como id, porque es un campo que no expone datos sensibles como el dni e identifica de manera única a cada registro


# b. ¿Cuál es la primary key para la tabla de planes de internet? Justificar respuesta.
# La primary key la definimos como id, porque es un campo que no expone datos sensibles como el identificador del plan e identifica de manera única a cada registro


# c. ¿Cómo serían las relaciones entre tablas? ¿En qué tabla debería haber foreign key? ¿A qué campo de qué tabla hace referencia dicha foreign key? Justificar respuesta.
# Nuestro equipo definio una relación de 1 a muchos (1 cliente puede contratar varios planes pero un plan puede pertenecer a un solo cliente), la FK va en la tabla planes porque es donde se da
# la relación de muchos

#Consultas

# Mostrar nombre y apellido de todos los clientes
SELECT nombre, apellido
FROM clientes;

# Mostrar identificador, velocidad y precio de todos los planes de internet
SELECT identificacion, velocidad, precio
FROM planes;

# Mostrar el nombre, apellido y la ciudad de los clientes de la provincia de Pennsylvania
SELECT nombre, apellido, ciudad
FROM clientes
WHERE provincia = "Pennsylvania";

# Mostrar la información de los clientes nacidos entre 1990 y 2000
SELECT *
FROM clientes
WHERE YEAR(fecha_nacimiento) BETWEEN 1990 AND 2000;

# Mostrar el nombre, apellido, ciudad y velocidad de internet de los clientes donde la ciudad empiece por M
SELECT c.nombre, c.apellido, c.ciudad, p.velocidad
FROM clientes c
JOIN planes p ON p.id_cliente = c.id
WHERE c.ciudad LIKE "M%";

# Top 3 clientes con planes más costosos
SELECT c.nombre, c.apellido, p.precio
FROM clientes c
JOIN planes p ON c.id = p.id_cliente
ORDER BY p.precio DESC
LIMIT 3;

# Clientes con plan sin descuento
SELECT c.nombre, c.apellido
FROM clientes c
JOIN planes p ON c.id = p.id_cliente
WHERE p.descuento IS NULL;

# TOP 3 clientes con mayor descuento
SELECT c.nombre, c.apellido, p.descuento
FROM clientes c
JOIN planes p ON c.id = p.id_cliente
ORDER BY p.descuento DESC
LIMIT 3;

# Clientes con más de una plan y la cantidad de planes
SELECT c.nombre, c.apellido, count(p.id) cantidad_planes
FROM clientes c
JOIN planes p ON c.id = p.id_cliente
GROUP BY c.nombre, c.apellido
HAVING cantidad_planes > 1;

# Costo promedio de los clientes con más de un plan
SELECT c.nombre, c.apellido, avg(p.precio) costo_promedio
FROM clientes c
JOIN planes p ON c.id = p.id_cliente
GROUP BY c.nombre, c.apellido
HAVING count(p.id) > 1;