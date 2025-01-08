-- Seleccionar la base de datos
USE servicio_internet;

-- Insertar clientes
INSERT INTO `cliente` (`dni`, `nombre`, `apellido`, `fecha_nacimiento`, `provincia`, `ciudad`)
VALUES
  ('1234567890', 'Juan', 'Pérez', '1990-03-15 00:00:00', 'Buenos Aires', 'La Plata'),
  ('2345678901', 'Ana', 'Gómez', '1985-07-22 00:00:00', 'CABA', 'Buenos Aires'),
  ('3456789012', 'Carlos', 'Rodríguez', '1992-12-02 00:00:00', 'Cordoba', 'Cordoba'),
  ('4567890123', 'María', 'López', '1989-11-30 00:00:00', 'Santa Fe', 'Rosario'),
  ('5678901234', 'Luis', 'Martínez', '1995-06-10 00:00:00', 'Mendoza', 'Mendoza'),
  ('6789012345', 'Sofía', 'Hernández', '1993-01-25 00:00:00', 'San Juan', 'San Juan'),
  ('7890123456', 'Diego', 'García', '1980-09-13 00:00:00', 'Tucumán', 'San Miguel de Tucumán'),
  ('8901234567', 'Carla', 'Martínez', '1994-05-30 00:00:00', 'Salta', 'Salta'),
  ('9012345678', 'Fernando', 'Sánchez', '1987-04-09 00:00:00', 'Neuquén', 'Neuquén'),
  ('1023456789', 'Julieta', 'Vázquez', '1982-02-14 00:00:00', 'Misiones', 'Posadas');

-- Insertar planes de internet
INSERT INTO `plan_internet` (`velocidad`, `precio`, `descuento`)
VALUES
  (10, 120.50, 0.10),
  (20, 200.00, 0.15),
  (50, 350.00, 0.20),
  (100, 600.00, 0.25),
  (200, 1000.00, 0.30);

-- Establecer relaciones entre clientes y planes con fechas de alta aleatorias y direcciones aleatorias
INSERT INTO `cliente_plan_internet` (`cliente_id`, `plan_internet_id`, `direccion`, `fecha_alta`, `fecha_baja`)
SELECT
    cliente.id AS cliente_id,
    plan.id AS plan_internet_id,
    -- Dirección aleatoria: 'Calle', 'Avenida', 'Pasaje' + número aleatorio + ciudad aleatoria
    CONCAT(
        CASE
            WHEN RAND() < 0.33 THEN 'Calle '
            WHEN RAND() < 0.66 THEN 'Avenida '
            ELSE 'Pasaje '
        END,
        FLOOR(1 + (RAND() * 1000)),
        ', ',
        CASE
            WHEN RAND() < 0.33 THEN 'La Plata'
            WHEN RAND() < 0.66 THEN 'Rosario'
            ELSE 'Córdoba'
        END
    ) AS direccion,
    -- Generar fecha de alta aleatoria entre 2022-01-01 y 2024-12-31
    DATE_ADD('2022-01-01', INTERVAL (RAND() * 730) DAY) AS fecha_alta,
    NULL AS fecha_baja
FROM
    cliente
JOIN
    plan_internet AS plan
ORDER BY
    RAND()
LIMIT 10;
