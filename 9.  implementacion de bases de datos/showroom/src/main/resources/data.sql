INSERT INTO prenda (codigo, nombre, tipo, marca, color, talle, cantidad, precio_venta) VALUES
('P-0001', 'Silla Gamer', 'Gamer', 'Racer', 'Rojo y Negro', 'M', 10, 1500.50),
('P-0002', 'Teclado Mecánico', 'Gaming', 'Logitech', 'Negro', 'M', 5, 150.75),
('P-0003', 'Auriculares', 'Audio', 'Sony', 'Azul', 'L', 15, 220.00),
('P-0004', 'Mouse Gamer', 'Accesorios', 'Razer', 'Negro', 'S', 8, 75.99),
('P-0005', 'Monitor 144Hz', 'Gaming', 'Acer', 'Negro', 'L', 3, 350.00),
('P-0006', 'Laptop Gaming', 'Computadoras', 'Dell', 'Negro', 'XL', 5, 1200.00),
('P-0007', 'Cámara Digital', 'Cámaras', 'Canon', 'Negro', 'L', 7, 500.00),
('P-0008', 'Freidora de Aire', 'Electrodomésticos', 'Philips', 'Blanco', 'N/A', 2, 250.00),
('P-0009', 'Reloj Inteligente', 'Dispositivos Portátiles', 'Apple', 'Gris Espacial', 'N/A', 12, 399.99),
('P-0010', 'Microfono USB', 'Audio', 'Blue', 'Plateado', 'N/A', 14, 99.99);

INSERT INTO ventas (fecha, total, medio_de_pago) VALUES
('2023-09-01', 2000.00, 'Tarjeta de Crédito'),
('2023-09-02', 2300.50, 'Efectivo'),
('2023-09-05', 390.75, 'PayPal'),
('2023-09-10', 1500.00, 'Tarjeta de Débito'),
('2023-09-15', 350.00, 'Efectivo');


-- Asocia las ventas con prendas
INSERT INTO venta_prenda (venta_id, prenda_id) VALUES
(1, 1),  -- Venta 1, Prenda 1 (Silla Gamer)
(1, 2),  -- Venta 1, Prenda 2 (Teclado Mecánico)
(2, 3),  -- Venta 2, Prenda 3 (Auriculares)
(2, 4),  -- Venta 2, Prenda 4 (Mouse Gamer)
(3, 9),  -- Venta 3, Prenda 9 (Reloj Inteligente)
(4, 5),  -- Venta 4, Prenda 5 (Monitor 144Hz)
(5, 6);  -- Venta 5, Prenda 6 (Laptop Gaming)
