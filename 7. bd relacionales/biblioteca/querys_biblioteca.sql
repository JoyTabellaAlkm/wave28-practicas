# Listar los datos de los autores.
select nombre, nacionalidad from autor; 

# Listar nombre y edad de los estudiantes
select nombre, edad from estudiante;

# ¿Qué estudiantes pertenecen a la carrera informática?
select * from estudiante where carrera = "Informática";

# ¿Qué autores son de nacionalidad francesa o italiana?
select nombre, nacionalidad
from autor
where nacionalidad = "francés" or nacionalidad = "italiano";

# ¿Qué libros no son del área de internet?
select titulo, area
from libro
where area <> 'internet';

# Listar los libros de la editorial Salamandra.
select titulo, editorial from libro where editorial = "Salamandra";

# Listar los datos de los estudiantes cuya edad es mayor al promedio.
select nombre, apellido, edad
from estudiante
where edad > (select avg(edad) from estudiante);

# Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select nombre, apellido
from estudiante
where apellido like "G%";

# Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre
FROM autor a
INNER JOIN libroautor la ON a.idautor = la.idautor
INNER JOIN libro l ON la.idlibro = l.idlibro
WHERE l.titulo = 'El Universo: Guía de viaje';

# ¿Qué libros se prestaron al lector “Filippo Galli”?
select l.titulo, l.editorial
from libro l
inner join prestamo p on p.idlibro = l.idlibro
inner join estudiante e on p.idlector = e.idlector
where e.nombre = "Marta";

SELECT l.titulo, l.editorial
FROM libro l
INNER JOIN prestamo p ON p.idlibro = l.idlibro
INNER JOIN estudiante e ON p.idlector = e.idlector
WHERE e.nombre = "Gonzalo" and e.apellido = "López";

# Listar el nombre del estudiante de menor edad.
select nombre, apellido
from estudiante
where edad = (select min(edad) from estudiante);

# Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre, e.apellido
FROM libro l
INNER JOIN prestamo p on p.idlibro = l.idlibro
INNER JOIN estudiante e on e.idlector = p.idlector
where l.area = 'Literatura';

# Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.titulo
FROM libro l
INNER JOIN libroautor la on la.idlibro = l.idlibro
INNER JOIN autor a on a.idautor = la.idautor
where a.nombre = 'J.K. Rowling';

# Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo
FROM libro l
INNER JOIN prestamo p on p.idlibro = l.idlibro
where p.fechadevolucion = '2023-07-21';
