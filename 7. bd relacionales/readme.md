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