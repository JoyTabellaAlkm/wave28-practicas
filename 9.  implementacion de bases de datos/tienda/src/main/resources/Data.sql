-- Limpia la tabla antes de insertar datos (opcional, si la tabla ya tiene datos)
DELETE FROM prenda;

-- Inserta datos de ejemplo en la tabla Prenda
INSERT INTO prenda (codigo, nombre, tipo, marca, color, talle, cantidad, precio_venta) VALUES
(1, 'Camisa Casual', 'Camisa', 'Zara', 'Azul', 42, 10, 1999.99);
