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

SELECT em.nombre, em.puesto, de.localidad FROM test_3_2_db.empleado AS em INNER JOIN test_3_2_db.departamento AS de ON
 em.depto_nro = de.depto_nro;
 
 SELECT de.nombre_depto, COUNT(*) AS total FROM test_3_2_db.departamento AS de INNER JOIN test_3_2_db.empleado AS em ON de.depto_nro = em.depto_nro
 GROUP BY em.depto_nro HAVING total > 2;
 
 SELECT 
    em.nombre, em.salario, de.nombre_depto
FROM
    test_3_2_db.empleado AS em
        INNER JOIN
    test_3_2_db.departamento AS de ON em.depto_nro = de.depto_nro
WHERE
    em.puesto = (SELECT 
            em.salario
        FROM
            test_3_2_db.empleado AS em
        WHERE
            em.nombre = 'Mito'
                AND em.apellido = 'Barchuk');
 
 SELECT 
    em.*
FROM
    test_3_2_db.empleado AS em
        INNER JOIN
    test_3_2_db.departamento AS de ON em.depto_nro = de.depto_nro
WHERE
    de.nombre_depto = 'Contabilidad'
ORDER BY em.nombre ASC;
 
 SELECT * FROM test_3_2_db.empleado ORDER BY salario ASC LIMIT 1;
 
 SELECT
    e.*
FROM
    test_3_2_db.empleado e
        INNER JOIN
    test_3_2_db.departamento d ON e.depto_nro = d.depto_nro
WHERE
    d.nombre_depto = 'Ventas'
        AND e.salario = (SELECT
            MAX(salario)
        FROM
            test_3_2_db.empleado e2
                INNER JOIN
            test_3_2_db.departamento d2 ON e2.depto_nro = d2.depto_nro
        WHERE
            d2.nombre_depto = 'Ventas');

