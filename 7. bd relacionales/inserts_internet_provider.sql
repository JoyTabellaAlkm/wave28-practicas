use empresa_internet;
-- Inserts tabla plan internet
INSERT INTO empresa_internet.internet_plan
(speed_in_mb, price, discount)
VALUES
(50, 5000, 0.10),
(60, 6000, 0.09),
(70, 7000, 0.08),
(80, 8000, 0.07),
(90, 9000, 0.06);

-- Inserts tabla cliente
INSERT INTO empresa_internet.client
VALUES
("Jose", "Sanchez", "2001-12-01", "1", "Buenos Aires", "San Miguel", "1"),
("Juan", "Perez", "2001-12-01", "2", "Entre rios", "Paraná", "2"),
("Mario", "Gomez", "2001-12-01", "3", "Buenos Aires", "Lanus", "3"),
("Belen", "Julia", "2001-12-01", "4", "Buenos Aires", "Escobar","4"),
("Ricardo", "Marin", "2001-12-01", "5", "Chubut", "Rawson","5"),
("Nicolas", "Moreno", "2001-12-01", "6", "Córdoba", "Mina Clavero","1"),
("Jose", "Barco", "2001-12-01", "7", "Córdoba", "Villa Gral Belgrano", "2"),
("Pepe", "Lopez", "2001-12-01", "8", "Corrientes", "Mocoretá","3"),
("Juana", "Sanchez", "2001-12-01", "9", "Santa Cruz", "Rio Gallegos", "4"),
("Marcos", "Marin", "2001-12-01", "10", "Santa Fe", "Rosario", "5");

-- Operaciones SQL
-- 1
SELECT id, speed_in_mb FROM internet_plan WHERE speed_in_mb >= 80;
-- 2
SELECT id, speed_in_mb, price FROM internet_plan WHERE price <= 7000;
-- 3
SELECT id, speed_in_mb, price FROM internet_plan WHERE discount >= 0.1;
-- 4
SELECT id, speed_in_mb, price FROM internet_plan WHERE price = 7000;
-- 5
SELECT id, speed_in_mb, price FROM internet_plan WHERE speed_in_mb BETWEEN 60 AND 80;
-- 6
SELECT c.dni as client_id, i.id as internet_plan_id, i.price as plan_price
FROM internet_plan as i, client as c
WHERE i.price >= 8000;
-- 7 
SELECT dni, name, surname
FROM client
WHERE state = "Buenos Aires";
-- 8
SELECT dni, name, surname
FROM client
WHERE dni BETWEEN 5 AND 10
ORDER BY dni DESC;
-- 9
SELECT dni, name, surname
FROM client
WHERE surname = "Marin";
-- 10
SELECT *
FROM client
ORDER BY internet_plan_id;
