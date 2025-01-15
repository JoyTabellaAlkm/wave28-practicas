# Comandos SQL

## Crear ventas

```
INSERT INTO ventas (numero, fecha, total, medio_pago) VALUES
(1, '2023-10-01', 109.97, 'Tarjeta de crédito'),
(2, '2023-10-02', 79.98, 'Efectivo'),
(3, '2023-10-03', 49.99, 'Tarjeta de débito'),
(4, '2023-10-04', 199.99, 'Transferencia bancaria'),
(5, '2023-10-05', 59.98, 'Tarjeta de crédito'),
(6, '2023-10-06', 84.97, 'Efectivo'),
(7, '2023-10-07', 99.99, 'Tarjeta de crédito'),
(8, '2023-10-08', 129.98, 'Tarjeta de débito'),
(9, '2023-10-09', 69.98, 'Efectivo'),
(10, '2023-10-10', 49.99, 'Transferencia bancaria'),
(11, '2023-10-11', 25.99, 'Tarjeta de crédito'),
(12, '2023-10-12', 64.97, 'Efectivo'),
(13, '2023-10-13', 119.98, 'Tarjeta de débito'),
(14, '2023-10-14', 149.99, 'Transferencia bancaria'),
(15, '2023-10-15', 39.99, 'Tarjeta de crédito');
```
## crear prendas

```
INSERT INTO prendas (codigo, nombre, tipo, marca, color, talle, cantidad, precio) VALUES
(11, 'Camiseta Básica', 'Camiseta', 'Marca A', 'Rojo', 'M', 50, 19.99),
(12, 'Pantalón Chino', 'Pantalón', 'Marca B', 'Azul', 'L', 30, 49.99),
(13, 'Chaqueta Lluvia', 'Chaqueta', 'Marca C', 'Verde', 'XL', 15, 99.99),
(14, 'Vestido Estampado', 'Vestido', 'Marca D', 'Multicolor', 'S', 20, 79.99),
(15, 'Falda Denim', 'Falda', 'Marca E', 'Azul', 'M', 25, 29.99),
(16, 'Camisa Formal', 'Camisa', 'Marca F', 'Blanco', 'L', 45, 39.99),
(17, 'Suéter Lana', 'Suéter', 'Marca G', 'Gris', 'M', 35, 59.99),
(18, 'Blazer Elegante', 'Blazer', 'Marca H', 'Negro', 'L', 10, 129.99),
(19, 'Short Deportivo', 'Short', 'Marca I', 'Amarillo', 'S', 60, 15.99),
(20, 'Abrigo Invierno', 'Abrigo', 'Marca J', 'Marrón', 'XL', 5, 199.99),
(21, 'Jeans Ajustados', 'Jeans', 'Marca K', 'Azul Oscuro', 'M', 40, 69.99),
(22, 'Sudadera Casual', 'Sudadera', 'Marca L', 'Negro', 'S', 30, 49.99),
(23, 'Bikini Playa', 'Bikini', 'Marca M', 'Rojo', 'S', 20, 25.99),
(24, 'Polo Estilo', 'Polo', 'Marca N', 'Rosa', 'M', 30, 34.99),
(25, 'Parka Impermeable', 'Parka', 'Marca O', 'Verde Oliva', 'L', 15, 149.99);
```

## Asociar ventas y prendas

```
UPDATE prendas SET venta_id = CASE
WHEN codigo = 11 THEN 1
WHEN codigo = 12 THEN 1
WHEN codigo = 13 THEN 2
WHEN codigo = 14 THEN 2
WHEN codigo = 15 THEN 3
WHEN codigo = 16 THEN 8
WHEN codigo = 17 THEN 5
WHEN codigo = 18 THEN 6
WHEN codigo = 19 THEN 9
WHEN codigo = 20 THEN 4
WHEN codigo = 21 THEN 7
WHEN codigo = 22 THEN 6
WHEN codigo = 23 THEN 10
WHEN codigo = 24 THEN 11
WHEN codigo = 25 THEN 14
ELSE NULL
END;
```