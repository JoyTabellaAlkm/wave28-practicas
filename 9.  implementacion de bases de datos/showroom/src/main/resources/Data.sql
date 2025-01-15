INSERT INTO prendas (nombre, tipo, marca, color, talle, cantidad, precio_venta) VALUES
                                                                                    ('Camisa de Algodón', 'Camisa', 'Marca Ejemplo', 'Azul', 'M', 10, 29.99),
                                                                                    ('Pantalón de Mezclilla', 'Pantalón', 'Marca A', 'Negro', 'L', 20, 49.99),
                                                                                    ('Vestido de Verano', 'Vestido', 'Marca B', 'Rojo', 'S', 15, 39.99),
                                                                                    ('Short Deportivo', 'Short', 'Marca C', 'Gris', 'L', 30, 19.99),
                                                                                    ('Chaqueta de Piel', 'Abrigo', 'Marca D', 'Marrón', 'M', 5, 89.99),
                                                                                    ('Zapatos de Cuero', 'Calzado', 'Marca E', 'Negro', '42', 25, 69.99),
                                                                                    ('Sandalias de Playa', 'Calzado', 'Marca F', 'Amarillo', '38', 50, 14.99),
                                                                                    ('Bufanda de Lana', 'Accesorio', 'Marca G', 'Azul', 'Único', 40, 9.99),
                                                                                    ('Gorro de Invierno', 'Accesorio', 'Marca H', 'Rojo', 'Único', 10, 12.49),
                                                                                    ('Cinturón de Cuero', 'Accesorio', 'Marca I', 'Negro', 'M', 15, 24.99),
                                                                                    ('Playera de Manga Corta', 'Playera', 'Marca J', 'Blanco', 'M', 100, 19.99),
                                                                                    ('Sudadera con Capucha', 'Sudadera', 'Marca K', 'Gris', 'L', 8, 34.99),
                                                                                    ('Leggings Deportivos', 'Pantalón', 'Marca L', 'Negro', 'S', 60, 24.99),
                                                                                    ('Pantalones Cortos de Playa', 'Short', 'Marca M', 'Multicolor', 'M', 20, 19.99),
                                                                                    ('Camisa de Rayas', 'Camisa', 'Marca N', 'Azul/Blanco', 'L', 30, 34.99);

INSERT INTO ventas (fecha, total, medio_de_pago) VALUES
                                                     ('2023-01-15', 99.99, 'Tarjeta de Crédito'),
                                                     ('2023-01-16', 49.99, 'Efectivo'),
                                                     ('2023-01-17', 89.50, 'Transferencia'),
                                                     ('2023-01-18', 150.00, 'Tarjeta de Débito'),
                                                     ('2023-01-19', 125.75, 'Efectivo'),
                                                     ('2023-01-20', 200.00, 'PayPal'),
                                                     ('2023-01-21', 45.00, 'Efectivo'),
                                                     ('2023-01-22', 75.20, 'Tarjeta de Crédito'),
                                                     ('2023-01-23', 90.00, 'Transferencia'),
                                                     ('2023-01-24', 100.50, 'Tarjeta de Débito'),
                                                     ('2023-01-25', 60.00, 'Efectivo'),
                                                     ('2023-01-26', 75.99, 'PayPal'),
                                                     ('2023-01-27', 80.20, 'Tarjeta de Crédito'),
                                                     ('2023-01-28', 130.00, 'Efectivo'),
                                                     ('2023-01-29', 45.99, 'Transferencia');

INSERT INTO venta_prenda (venta_id, prenda_id) VALUES
                                                   (1, 1),
                                                   (1, 2),
                                                   (2, 3),
                                                   (3, 1),
                                                   (4, 4),
                                                   (5, 2),
                                                   (6, 5),
                                                   (7, 6),
                                                   (8, 7);