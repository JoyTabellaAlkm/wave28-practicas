#Listar los datos de los autores.
SELECT a.*
FROM autor a;
#Listar nombre y edad de los estudiantes
SELECT e.nombre, e.edad
FROM estudiante e;
#¿Qué estudiantes pertenecen a la carrera informática?
SELECT e.*
FROM estudiante e
WHERE e.carrera = "Informatica";
#¿Qué autores son de nacionalidad francesa o italiana?
SELECT a.*
FROM autor a
WHERE a.nacionalidad="Argentina" OR a.nacionalidad="Colombiana";
#¿Qué libros no son del área de internet?
SELECT l.*
FROM libro l
WHERE NOT l.area="Internet";
#Listar los libros de la editorial Salamandra.
SELECT l.*
FROM libro l
WHERE l.editorial="Editorial Plaza & Janés";
#Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT e.nombre
FROM estudiante e
WHERE e.edad > (SELECT AVG(edad) 
				FROM estudiante);
#Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT e.*
FROM estudiante e
WHERE e.apellido LIKE "G%";
#Listar los autores del libro "El Universo: Guía de viaje"(usamos La ciudad y los perros". (Se debe listar solamente los nombres).
SELECT a.nombre
FROM autor a
INNER JOIN libroautor la ON a.idautor = la.idautor
WHERE la.idlibro = (SELECT l.idlibro
					FROM libro L
					WHERE l.titulo="La ciudad y los perros");
#¿Qué libros se prestaron al lector "Filippo Galli"? Usamos Juan Pérez
SELECT l.*
FROM prestamo p
INNER JOIN libro l ON p.idlibro = l.idlibro
WHERE p.idlector = (SELECT e.idlector
					FROM estudiante e
					WHERE e.nombre="Juan" AND e.apellido="Pérez");
#Listar el nombre del estudiante de menor edad.
#Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
#Listar los libros que pertenecen a la autora J.K. Rowling.
#Listar títulos de los libros que debían devolverse el 16/07/2021.