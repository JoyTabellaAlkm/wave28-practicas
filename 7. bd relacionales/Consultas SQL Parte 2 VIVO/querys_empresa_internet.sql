/** Link a DER: https://drive.google.com/file/d/1f1Tofkye96g45gcFaHSi9-aOmymi1eb0/view?usp=sharing **/

/** Plantear 10 consultas **/

/** nombre y apellido de quienes contrataron el plan 1 **/
SELECT nombre, apellido FROM cliente WHERE plan_id=1;

/** nombre y apellido de la persona mas joven que tiene un plan contratado **/
SELECT nombre, apellido FROM cliente ORDER BY fecha_nacimiento DESC LIMIT 1;

/** dni de la persona mayor con un plan contratado **/
SELECT dni FROM cliente ORDER BY fecha_nacimiento LIMIT 1;

/** ciudades que contratan planes en la empresa **/
SELECT DISTINCT ciudad FROM cliente;

/** fecha de nacimiento de las personas que contrataron el plan 3 **/
SELECT fecha_nacimiento FROM cliente WHERE plan_id=3;

/** provincia de las personas que contrataron el plan 5 **/
SELECT provincia FROM cliente WHERE plan_id=5;

/** todos los datos de los clientes ordenados por nombre descendente **/
SELECT * FROM cliente ORDER BY nombre DESC;

/** clientes nacidos despues del año 1990 **/
SELECT * FROM cliente WHERE YEAR(fecha_nacimiento) > 1990; 

/** planes ordenados por precio de menor a mayor **/
SELECT * FROM plan ORDER BY precio;

/** planes con precio menor a 15000 **/
SELECT * FROM plan WHERE precio < 15000;

/** planes con velocidad de 100MB **/
SELECT * FROM plan WHERE velocidad = "100MB";