CREATE SCHEMA IF NOT EXISTS empresa_internet;
CREATE TABLE IF NOT EXISTS empresa_internet.plan(
id int NOT NULL AUTO_INCREMENT,
velocidad int,
precio double,
descuento double,
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS empresa_internet.cliente (
DNI int NOT NULL AUTO_INCREMENT,
nombre varchar(255),
apellido varchar(255),
fecha_nac datetime,
provincia varchar(255),
ciudad varchar(255),
id_plan	int,
PRIMARY KEY (DNI),
FOREIGN KEY (id_plan) REFERENCES plan(id)
);


INSERT INTO empresa_internet.plan VAlUES (1, 3, 2000, 10);
INSERT INTO empresa_internet.plan VAlUES (2, 3, 2000, 0);
INSERT INTO empresa_internet.plan VAlUES (3, 10, 2000, 15.5);
INSERT INTO empresa_internet.plan VAlUES (4, 5, 2000, 10.1);

INSERT INTO empresa_internet.cliente VALUES (19013190, "mauricio", "ballesteros", "1995-07-13", "bogota", "bogota", 3);