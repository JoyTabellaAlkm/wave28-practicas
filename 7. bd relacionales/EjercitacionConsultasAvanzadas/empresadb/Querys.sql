/*select d.nombre_depto, e.puesto, d.localidad
 from departamento d
 join empleado e
 on d.depto_nro = e.depto_nro
 where e.puesto = "Vendedor"*/


 /*select d.nombre_depto, COUNT(e.cod_emp) empleados
 from departamento d
 join empleado e
 on d.depto_nro = e.depto_nro
 group by d.depto_nro
 having count(e.cod_emp) < 5*/

/*select e.nombre, e.salario, d.nombre_depto
from empleado e
join departamento d on e.depto_nro = d.depto_nro
where e.puesto = (select puesto from empleado where nombre = 'Mito' and apellido = 'Barchuk')*/

/*select * from empleado e
 join departamento d
 on e.depto_nro = d.depto_nro
 where d.nombre_depto = "Contabilidad"
 order by e.nombre */

/* select * from empleado e
 order by salario
 limit 1 */

 /* select * from empleado e
 join departamento d
 on e.depto_nro = d.depto_nro
 where d.nombre_depto = "Ventas"
 order by salario desc
 limit 1 */
