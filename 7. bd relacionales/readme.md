# BD Relacionales - Parte 1

## Ejercicio 1

Una mueblería necesita la implementación de una base de datos para controlar las ventas que realiza por día, el stock de sus artículos (productos) y la lista de sus clientes que realizan las compras.

Se necesita plantear:

 - ¿Cuáles serían las entidades de este sistema?
 - ¿Qué atributos se determinarán para cada entidad? (Considerar los que se crean necesarios)
 - ¿Cómo se conformarán las relaciones entre entidades? ¿Cuáles serían las cardinalidades?

Realizar un DER para modelar el escenario planteado.

![image](https://github.com/user-attachments/assets/b3dd3d78-2a44-46b7-86ac-03df2f9eee11)



# BD Relacionales - Parte 1 - VIVO

## Ejercicio 1

Realizar un diagrama de entidad - relación para el sistema de una concesionaria, que desea gestionar los servicios de los coches de sus clientes.


- Para el módulo del sistema, se necesita almacenar información de los clientes, los coches que estos poseen y los service/revisiones de cada uno de estos.
- Utilizar el formato adecuado para representar las Primary y Foreign Key en el diagrama, además de los tipos de datos de cada atributo.

![Ej_concesioraria](https://github.com/user-attachments/assets/120acf44-f848-4482-8c7e-3bafae9211fe)


# Consultas SQL - Parte 2 - VIVO

## Ejercicio 1

Se propone realizar las siguientes consultas a la base de datos movies_db.sql.

Importar el archivo movies_db.sql desde PHPMyAdmin o MySQL Workbench y resolver las siguientes consultas:

- Mostrar todos los registros de la tabla de movies.
    ```sql
    select * from movies;
    ```
- Mostrar el nombre, apellido y rating de todos los actores.
    ```sql
    select first_name, last_name, rating from actors;
    ```
- Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
    ```sql
    select title as "titulo" from series as series; 
    ```
- Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
    ```sql
    select first_name, last_name from actors where rating >= 7.5;
    ```
- Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
    ```sql
    select title, rating, awards from movies
    where rating >7.5 and awards > 2;
    ```
- Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
    ```sql
    select title, rating from movies
    order by rating asc;
    ```
- Mostrar los títulos de las primeras tres películas en la base de datos.
    ```sql
    select title from movies
    limit 3;
    ```
- Mostrar el top 5 de las películas con mayor rating.
    ```sql
    select title, rating from movies
    order by rating desc
    limit 5;
    ```
- Listar los primeros 10 actores.
    ```sql
    select first_name, last_name from actors
    limit 10;
    ```
- Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
    ```sql
    select title, rating from movies
    where title like ('%Toy Story%');
    ```
- Mostrar a todos los actores cuyos nombres empiezan con Sam.
    ```sql
    select first_name, last_name from actors
    where first_name like ('Sam%'); 
    ```
- Mostrar el título de las películas que salieron entre el 2004 y 2008.
    ```sql
    select title from movies
    where YEAR(release_date) between 2004 and 2008;
    ```
- Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.
    ```sql
    select title from movies
    where YEAR(release_date) between 1988 and 2009
    and rating > 3
    and awards > 1
    order by rating;    
    ```

# Consultas SQL Avanzadas - Parte 1

## Ejercicio 1 (Normalización)

Luego de un análisis realizado en un sistema de facturación, se ha detectado un mal diseño en la base de datos. La misma, cuenta con una tabla facturas que almacena datos de diferente naturaleza.

Como se puede observar, la tabla cuenta con datos que podrían ser normalizados y separados en diferentes entidades.

<img width="290" alt="image" src="https://github.com/user-attachments/assets/6bd26046-fe2d-4740-9c50-c95c172a9fe8" />

Se solicita para el escenario anterior:

Aplicar reglas de normalización y elaborar un modelo de DER que alcance la tercera forma normal (3FN).
Describir con sus palabras cada paso de la descomposición y aplicación de las reglas para visualizar el planteo realizado.



# Consultas SQL Avanzadas - Parte 1 - VIVO
## Consultas SQL Avanzadas Ejercicio 1
Se tiene el siguiente DER que corresponde al esquema que presenta la base de datos de una “biblioteca”.
<img width="483" alt="image" src="https://github.com/user-attachments/assets/2eabe553-a1f1-4f9f-8ae0-67c0674e444d" />

En base al mismo, plantear las consultas SQL para resolver los siguientes requerimientos:
```sql
CREATE TABLE AUTOR (
    idAutor INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    nacionalidad VARCHAR(50) NOT NULL
);

CREATE TABLE LIBRO (
    idLibro INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    editorial VARCHAR(100) NOT NULL,
    area VARCHAR(100) NOT NULL
);

CREATE TABLE ESTUDIANTE (
    idLector INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    carrera VARCHAR(100) NOT NULL,
    edad INT NOT NULL
);

CREATE TABLE LIBROAUTOR (
    idAutor INT,
    idLibro INT,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES AUTOR(idAutor) ON DELETE CASCADE,
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro) ON DELETE CASCADE
);

CREATE TABLE PRESTAMO (
    idLector INT,
    idLibro INT,
    fechaPrestamo DATE NOT NULL,
    fechaDevolucion DATE,
    devuelto BOOLEAN NOT NULL DEFAULT FALSE,
    PRIMARY KEY (idLector, idLibro, fechaPrestamo),
    FOREIGN KEY (idLector) REFERENCES ESTUDIANTE(idLector) ON DELETE CASCADE,
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro) ON DELETE CASCADE
);

INSERT INTO AUTOR (nombre, nacionalidad) VALUES
('Gabriel García Márquez', 'Colombiana'),
('J.K. Rowling', 'Británica'),
('Isaac Asimov', 'Estadounidense'),
('Victor Hugo', 'Francesa'),
('Umberto Eco', 'Italiana');

INSERT INTO LIBRO (titulo, editorial, area) VALUES
('Cien años de soledad', 'Editorial Oveja Negra', 'Novela'),
('Harry Potter y la piedra filosofal', 'Editorial Salamandra', 'Internet'),
('Yo, Robot', 'Editorial Grijalbo', 'Ciencia Ficción'),
('El Universo: Guía de viaje', 'Guía Espacial', 'Astronomía'),
('Fundación', 'Editorial Planeta', 'Ciencia Ficción'),
('Base de Datos Modernos', 'Editorial McGraw-Hill', 'Tecnología');

INSERT INTO ESTUDIANTE (nombre, apellido, direccion, carrera, edad) VALUES
('Juan', 'Pérez', 'Calle Falsa 123', 'Ingeniería', 20),
('Ana', 'Gómez', 'Avenida Siempre Viva 742', 'Literatura', 22),
('Luis', 'Martínez', 'Calle Mayor 45', 'Ciencias de la Computación', 21),
('Filippo', 'Galli', 'Vía Roma 10', 'Informática', 19),
('Clara', 'Rodríguez', 'Calle Luna 88', 'Ciencias de la Computación', 25);

INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES
(1, 1),  -- Gabriel García Márquez - Cien años de soledad
(2, 2),  -- J.K. Rowling - Harry Potter y la piedra filosofal
(3, 3),  -- Isaac Asimov - Yo, Robot
(4, 4),  -- Victor Hugo - El Universo: Guía de viaje
(5, 5),  -- Umberto Eco - Fundación
(2, 6);  -- J.K. Rowling - Base de Datos Modernos

INSERT INTO PRESTAMO (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES
(1, 1, '2023-10-01', NULL, FALSE),  -- Juan Pérez presta "Cien años de soledad"
(2, 2, '2023-10-05', '2023-10-12', TRUE),  -- Ana Gómez presta "Harry Potter", devuelto
(3, 1, '2023-10-07', NULL, FALSE),  -- Luis Martínez presta "Cien años de soledad"
(4, 6, '2023-10-10', NULL, FALSE),  -- Filippo Galli presta "Base de Datos Modernos"
(5, 4, '2023-10-11', NULL, FALSE);  -- Clara Rodríguez presta "El Universo: Guía de viaje"
```
En base al mismo, plantear las consultas SQL para resolver los siguientes requerimientos:

- Listar los datos de los autores.
```sql
SELECT * FROM AUTOR;
```
- Listar nombre y edad de los estudiantes
```sql
SELECT e.nombre, e.edad FROM ESTUDIANTE e;
```
- ¿Qué estudiantes pertenecen a la carrera informática?
```sql
SELECT e.nombre, e.edad FROM ESTUDIANTE e WHERE e.carrera = "Informática";
```
- ¿Qué autores son de nacionalidad francesa o italiana?
```sql
SELECT a.nombre, a.nacionalidad FROM AUTOR a WHERE a.nacionalidad IN ("Francesa", "Italiana");
```
- ¿Qué libros no son del área de internet?
```sql
SELECT * FROM LIBRO l WHERE l.area <> "Internet";
```
- Listar los libros de la editorial Salamandra.
```sql
SELECT * FROM LIBRO l WHERE l.editorial LIKE "%Salamandra";
```
- Listar los datos de los estudiantes cuya edad es mayor al promedio.
```sql
SELECT * FROM ESTUDIANTE e WHERE e.edad > (SELECT AVG(e2.edad) FROM ESTUDIANTE e2);
```
- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
```sql
SELECT * FROM ESTUDIANTE e WHERE e.apellido LIKE "G%";
```
- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
```sql
SELECT a.nombre FROM AUTOR a
INNER JOIN LIBROAUTOR la ON la.idAutor = a.idAutor
INNER JOIN LIBRO l ON l.idLibro = la.idLibro
WHERE l.titulo = "El Universo: Guía de viaje";
```
- ¿Qué libros se prestaron al lector “Filippo Galli”?
```sql
SELECT l.* FROM LIBRO l
INNER JOIN PRESTAMO p INNER JOIN ESTUDIANTE e ON p.idLibro = l.idLibro AND e.idLector = p.idLector
AND e.nombre = "Filippo" AND e.apellido = "Galli";
```
- Listar el nombre del estudiante de menor edad.
```sql
SELECT * FROM ESTUDIANTE e WHERE e.edad = (SELECT MIN(e2.edad) FROM ESTUDIANTE e2);
```
- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
```sql
SELECT e.nombre, e.apellido FROM LIBRO l
INNER JOIN PRESTAMO p INNER JOIN ESTUDIANTE e ON p.idLibro = l.idLibro AND e.idLector = p.idLector
AND l.area = "Base de Datos";
```
- Listar los libros que pertenecen a la autora J.K. Rowling.
```sql
SELECT l.* FROM LIBRO l
INNER JOIN LIBROAUTOR la ON la.idLibro = l.idLibro
INNER JOIN AUTOR a ON a.idAutor = la.idAutor
WHERE a.nombre = "J.K. Rowling";
```
- Listar títulos de los libros que debían devolverse el 16/07/2021.
```sql
SELECT l.titulo 
FROM LIBRO l
INNER JOIN PRESTAMO p ON p.idLibro = l.idLibro
WHERE p.fechaDevolucion = '2021-07-16';
```
