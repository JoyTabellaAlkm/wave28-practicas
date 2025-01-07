-- Inserts para la tabla Client
INSERT INTO `empresa_internet`.`Client` (dni, first_name, last_name, birth_date, province, city) VALUES (123456789, 'Juan', 'Pérez', '1985-03-12 00:00:00', 'Buenos Aires', 'La Plata');
INSERT INTO `empresa_internet`.`Client` (dni, first_name, last_name, birth_date, province, city) VALUES (987654321, 'Maria', 'Lopez', '1990-07-21 00:00:00', 'Córdoba', 'Córdoba Capital');
INSERT INTO `empresa_internet`.`Client` (dni, first_name, last_name, birth_date, province, city) VALUES (111223344, 'Carlos', 'Garcia', '1975-11-30 00:00:00', 'Santa Fe', 'Rosario');
INSERT INTO `empresa_internet`.`Client` (dni, first_name, last_name, birth_date, province, city) VALUES (222334455, 'Ana', 'Martinez', '1988-05-17 00:00:00', 'Mendoza', 'Mendoza');
INSERT INTO `empresa_internet`.`Client` (dni, first_name, last_name, birth_date, province, city) VALUES (333445566, 'Miguel', 'Rodriguez', '1992-09-10 00:00:00', 'Salta', 'Salta');
INSERT INTO `empresa_internet`.`Client` (dni, first_name, last_name, birth_date, province, city) VALUES (444556677, 'Luisa', 'Fernandez', '1983-02-25 00:00:00', 'Jujuy', 'San Salvador');
INSERT INTO `empresa_internet`.`Client` (dni, first_name, last_name, birth_date, province, city) VALUES (555667788, 'Pedro', 'Sanchez', '1995-08-14 00:00:00', 'Tucumán', 'San Miguel');
INSERT INTO `empresa_internet`.`Client` (dni, first_name, last_name, birth_date, province, city) VALUES (666778899, 'Lucia', 'Gomez', '2000-12-01 00:00:00', 'San Luis', 'La Punta');
INSERT INTO `empresa_internet`.`Client` (dni, first_name, last_name, birth_date, province, city) VALUES (777889900, 'Roberto', 'Diaz', '1982-04-18 00:00:00', 'Entre Ríos', 'Paraná');
INSERT INTO `empresa_internet`.`Client` (dni, first_name, last_name, birth_date, province, city) VALUES (888990011, 'Elena', 'Ruiz', '1998-06-05 00:00:00', 'La Rioja', 'La Rioja');

-- Inserts para la tabla plan
INSERT INTO `empresa_internet`.`plan` (idplan, speed_mb, price, discount) VALUES (1, 50, 19.99, 0.00);
INSERT INTO `empresa_internet`.`plan` (idplan, speed_mb, price, discount) VALUES (2, 100, 29.99, 5.00);
INSERT INTO `empresa_internet`.`plan` (idplan, speed_mb, price, discount) VALUES (3, 200, 49.99, 10.00);
INSERT INTO `empresa_internet`.`plan` (idplan, speed_mb, price, discount) VALUES (4, 500, 79.99, 15.00);
INSERT INTO `empresa_internet`.`plan` (idplan, speed_mb, price, discount) VALUES (5, 1000, 99.99, 20.00);

-- Inserts para la tabla client_plan (asignación aleatoria)
INSERT INTO `empresa_internet`.`client_plan` (id, client_dni, plan_id) VALUES (1, 123456789, 2);
INSERT INTO `empresa_internet`.`client_plan` (id, client_dni, plan_id) VALUES (2, 987654321, 4);
INSERT INTO `empresa_internet`.`client_plan` (id, client_dni, plan_id) VALUES (3, 111223344, 1);
INSERT INTO `empresa_internet`.`client_plan` (id, client_dni, plan_id) VALUES (4, 222334455, 5);
INSERT INTO `empresa_internet`.`client_plan` (id, client_dni, plan_id) VALUES (5, 333445566, 3);
INSERT INTO `empresa_internet`.`client_plan` (id, client_dni, plan_id) VALUES (6, 444556677, 2);
INSERT INTO `empresa_internet`.`client_plan` (id, client_dni, plan_id) VALUES (7, 555667788, 4);
INSERT INTO `empresa_internet`.`client_plan` (id, client_dni, plan_id) VALUES (8, 666778899, 1);
INSERT INTO `empresa_internet`.`client_plan` (id, client_dni, plan_id) VALUES (9, 777889900, 5);
INSERT INTO `empresa_internet`.`client_plan` (id, client_dni, plan_id) VALUES (10, 888990011, 3);

