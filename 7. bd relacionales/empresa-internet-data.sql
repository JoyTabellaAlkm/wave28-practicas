-- Insertar datos en la tabla clients
INSERT INTO clients (dni, first_name, last_name, birthdate, department, city) VALUES
(12345678, 'Juan', 'Perez', '1990-05-15', 'Buenos Aires', 'CABA'),
(23456789, 'Maria', 'Gomez', '1985-10-20', 'Cordoba', 'Cordoba'),
(34567890, 'Carlos', 'Fernandez', '1978-03-12', 'Santa Fe', 'Rosario'),
(45678901, 'Laura', 'Martinez', '1995-07-25', 'Mendoza', 'Mendoza'),
(56789012, 'Ana', 'Lopez', '1989-11-18', 'Salta', 'Salta'),
(67890123, 'Luis', 'Rodriguez', '1992-09-10', 'Neuquen', 'Neuquen'),
(78901234, 'Sofia', 'Gonzalez', '2000-04-05', 'Entre Rios', 'Parana'),
(89012345, 'Diego', 'Silva', '1984-02-28', 'San Juan', 'San Juan'),
(90123456, 'Florencia', 'Ruiz', '1993-12-30', 'Chubut', 'Comodoro Rivadavia'),
(12345679, 'Mauro', 'Romero', '1987-08-22', 'Tucuman', 'San Miguel');

-- Insertar datos en la tabla packages
INSERT INTO packages (speed, price, discount) VALUES
(50, 1500.00, 10.00),
(100, 2500.00, 15.00),
(200, 3500.00, 20.00),
(300, 4500.00, 25.00),
(500, 6000.00, 30.00);

-- Insertar datos en la tabla clients_packages
INSERT INTO clients_packages (clients_dni, packages_id) VALUES
(12345678, 1),
(23456789, 2),
(34567890, 3),
(45678901, 4),
(56789012, 5);
