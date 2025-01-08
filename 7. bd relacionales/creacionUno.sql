CREATE SCHEMA IF NOT EXISTS test_3_2_db;
CREATE TABLE IF NOT EXISTS test_3_2_db.departamento(
depto_nro varchar(255) NOT NULL PRIMARY KEY,
nombre_depto varchar(255),
localidad varchar(255)
);
CREATE TABLE IF NOT EXISTS test_3_2_db.empleado(
cod_emp varchar(255) NOT NULL PRIMARY KEY,
nombre varchar(255),
apellido varchar(255),
puesto varchar(255),
fecha_alta varchar(255),
salario int,
comision int,
depto_nro varchar(255),
FOREIGN KEY(depto_nro) REFERENCES departamento(depto_nro)
);
INSERT INTO test_3_2_db.departamento VALUE ("D-000-1", "Software", "Los Tigres");
INSERT INTO test_3_2_db.departamento VALUE ("D-000-2", "Sistemas", "Guadalupe");
INSERT INTO test_3_2_db.departamento VALUE ("D-000-3", "Contabilidad", "La Roca");
INSERT INTO test_3_2_db.departamento VALUE ("D-000-4", "Ventas", "Plata");
INSERT INTO test_3_2_db.empleado VALUE("E-0001", "César", "Piñero", "Vendedor", "12/05/2018", "80000", "15000", "D-000-4");
INSERT INTO test_3_2_db.empleado VALUE("E-0002", "Yosep", "Kowaleski", "Analista", "14/07/2015", "140000", "0", "D-000-2");
INSERT INTO test_3_2_db.empleado VALUE("E-0003", "Mariela", "Barrios", "Director", "05/06/2014", "185000", "0", "D-000-3");
INSERT INTO test_3_2_db.empleado VALUE("E-0004", "Jonathan", "Aguilera", "Vendedor", "03/06/2015", "85000", "10000", "D-000-4");
INSERT INTO test_3_2_db.empleado VALUE("E-0005", "Daniel", "Brezezicki", "Vendedor", "03/03/2018", "83000", "10000", "D-000-4");
INSERT INTO test_3_2_db.empleado VALUE("E-0006", "Mito", "Barchuk", "Presidente", "05/06/2014", "190000", "0", "D-000-3");
INSERT INTO test_3_2_db.empleado VALUE("E-0007", "Emilio", "Galarza", "Desarrollador", "02/08/2014", "60000", "0", "D-000-1");










