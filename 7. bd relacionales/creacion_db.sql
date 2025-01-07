CREATE DATABASE empresa_internet;

CREATE TABLE clientes(
	id INT AUTO_INCREMENT,
    nombre VARCHAR(20) NOT NULL,
    apellido VARCHAR(20) NOT NULL,
    fecha_nacimiento DATETIME NULL DEFAULT NULL,
    provincia VARCHAR(20) NOT NULL,
    ciudad VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE planes(
	id INT AUTO_INCREMENT,
    velocidad_en_MB INT NOT NULL,
    precio INT NOT NULL,
    descuento FLOAT,
    PRIMARY KEY (id)
);

CREATE TABLE cliente_plan(
	cliente_id INT NOT NULL,
    plan_id INT NOT NULL,
    fecha_alta TIMESTAMP NOT NULL,
    PRIMARY KEY (cliente_id, plan_id),
    FOREIGN KEY (cliente_id) REFERENCES clientes(id) ON DELETE CASCADE,    
    FOREIGN KEY (plan_id) REFERENCES planes(id) ON DELETE CASCADE
);

-- CREO LOS DIFERENTES PLANES QUE EXISTEN
INSERT INTO planes(id, velocidad_en_MB, precio, descuento) VALUES (1, 200, 40000, 0.50);
INSERT INTO planes(id, velocidad_en_MB, precio, descuento) VALUES (2, 400, 80000, 0.25);
INSERT INTO planes(id, velocidad_en_MB, precio, descuento) VALUES (3, 1024, 95000, 0.0);

SELECT id, velocidad_en_MB as velocidad FROM planes;

-- CREO LOS DIFERENTES USUARIOS
INSERT INTO clientes(id, nombre, apellido, fecha_nacimiento, provincia, ciudad)
VALUES (1, "Hugo", "Peykovich", "1995-12-08", "Buenos Aires", "Adrogue");
INSERT INTO clientes(id, nombre, apellido, fecha_nacimiento, provincia, ciudad)
VALUES (2, "Fede", "Moss", "1997-03-10", "Buenos Aires", "Burzaco");

SELECT id, nombre FROM clientes;

-- EL USER 1 ADQUIRIO EL PLAN 2
INSERT INTO cliente_plan(cliente_id, plan_id, fecha_alta) VALUES(1, 2, CURRENT_TIMESTAMP);
INSERT INTO cliente_plan(cliente_id, plan_id, fecha_alta) VALUES(2, 2, CURRENT_TIMESTAMP);

SELECT cliente_id, plan_id, fecha_alta FROM cliente_plan;


-- QUERY -> MUESTRO EL NOMBRE DE CLIENTE Y EL PRECIO DE SU PLAN
SELECT nombre, precio
FROM cliente_plan
INNER JOIN clientes as c ON cliente_plan.cliente_id = c.id
INNER JOIN planes as p ON cliente_plan.plan_id = p.id;

