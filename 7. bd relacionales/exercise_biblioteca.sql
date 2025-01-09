#Listar los datos de los autores.
SELECT
    a.*
FROM
    autor a;

#Listar nombre y edad de los estudiantes
SELECT
    e.nombre, e.edad
FROM
    estudiante e;

#¿Qué estudiantes pertenecen a la carrera informática?
SELECT
    e.*
FROM
    estudiante e
WHERE
    e.carrera = Lower("Informatica");

#¿Qué autores son de nacionalidad francesa o italiana?
SELECT
    a.*
FROM
    autor a
WHERE
    a.nacionalidad = 'Argentina'
        OR a.nacionalidad = 'Colombiana';

#¿Qué libros no son del área de internet?
SELECT
    l.*
FROM
    libro l
WHERE
    NOT l.area = LOWER('Internet');

#Listar los libros de la editorial Salamandra.
SELECT
    l.*
FROM
    libro l
WHERE
    l.editorial = 'Editorial Plaza & Janés';

#Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT
    *
FROM
    estudiante e
WHERE
    e.edad > (SELECT
            AVG(edad)
        FROM
            estudiante);

#Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT
    e.*
FROM
    estudiante e
WHERE
    e.apellido LIKE 'G%';

#Listar los autores del libro "El Universo: Guía de viaje"(usamos La ciudad y los perros". (Se debe listar solamente los nombres).
SELECT
    a.nombre
FROM
    autor a
        INNER JOIN
    libroautor la ON a.idautor = la.idautor
WHERE
    la.idlibro = (SELECT
            l.idlibro
        FROM
            libro L
        WHERE
            l.titulo = 'La ciudad y los perros');

#¿Qué libros se prestaron al lector "Filippo Galli"? Usamos Juan Pérez
SELECT
    l.*
FROM
    prestamo p
        INNER JOIN
    libro l ON p.idlibro = l.idlibro
WHERE
    p.idlector = (SELECT
            e.idlector
        FROM
            estudiante e
        WHERE
            e.nombre = 'Juan'
                AND e.apellido = 'Pérez');

#Lista el nombre del estudiante de menor edad.
SELECT * FROM estudiante ORDER BY edad ASC LIMIT 1;

#Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT
    estudiante.*
FROM
    estudiante
        INNER JOIN
    prestamo ON estudiante.idlector = prestamo.idlector
        INNER JOIN
    libro ON prestamo.idlibro = libro.idlibro
WHERE
    libro.titulo = 'Base de Datos';

#Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT
    libro.*
FROM
    autor
        INNER JOIN
    libroautor ON libroautor.idautor = autor.idautor
        INNER JOIN
    libro ON libro.idlibro = libroautor.idlibro
WHERE
    autor.nombre = 'J.K. Rowling';

#Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT
    libro.*
FROM
    prestamo
        INNER JOIN
    libro ON libro.idlibro = prestamo.idlibro
WHERE
    fechadevolucion = '2021-07-16';

    SELECT * FROM prestamo;

