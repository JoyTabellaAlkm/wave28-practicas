# Este proyecto fue creado en el marco del Bootcamp de JAVA de la Wave 28 de MERCADO LIBRE. - API SOCIAL MELI

# Descripción

Mercado Libre sigue creciendo y para el año que viene  tiene como objetivo empezar a implementar una serie de herramientas que permitan a los compradores y vendedores tener una experiencia totalmente innovadora, en donde el lazo que los una sea mucho más cercano. Es necesaria la presentación de una versión Beta de lo que va a ser conocido como “SocialMeli”, en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen.

# Requisitos

- **Java 21 (JDK 21)**
- **Maven**
- **Dependencias en pom.xml**

# Instrucciones para ejecutar el proyecto

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/NadinaJauch/be_java_hisp_w28_g07.git
2. Entrar al directorio del proyecto:
   ```bash
    cd be_java_hisp_w28_g07
    cd social-meli
3. Limpiar e instalar las dependencias con Maven:
   ```bash
    mvn clean install
4. Ejecutar la aplicación con Spring Boot:
   ```bash
   mvn spring-boot:run

# Datos

Este proyecto maneja los datos del modelo a través de listas, que inicialmente se cargan a partir de archivos de tipo `.JSON` que contienen datos de pruebas, acordes a las entidades. Estos archivos se encuentran en la carpeta `src/main/resources`.

El método que se encarga de llenar inicialmente las listas está en el `BaseRepository`, y se ejecuta cada vez que se instancia un repositorio hijo, pasando por parámetro el nombre del archivo correspondiente a la entidad del repositorio.

# Negocio

Para este proyecto se decidieron diferentes cuestiones a tener en cuenta:

- Un usuario no puede seguir a otro usuario que no es vendedor.
- Se considera que un usuario es vendedor cuando tiene un posteo realizado o mas.
- Se creo un método booleano isSeller que indica si un usuario es vendedor.

# Modelo

Diagrama:

![modelo](https://github.com/NadinaJauch/be_java_hisp_w28_g07/blob/dev/social-meli/src/main/resources/social-meli-model.png)

El user tiene:
- List<Integer> followedSellers: lista de Integer donde cada elemento representa un id de la entidad User.
- List<Integer> followers: lista de Integer donde cada elemento representa un id de la entidad User.
- List<Integer> posts: (publicaciones realizadas por el User), es una lista donde cada elemento representa un id de la entidad Post.
- List<Integer> favourites: (publicaciones favoritas del usuario), es una lista donde cada elemento representa un id de la entidad Post.

# Pruebas

Las pruebas para este proyecto se realizan desde Postman, la colección para realizar las mismas se encuentra en la carpeta de resources `src/main/resources`.

# Documentacióon

La documentación del proyecto en donde se encuentan los endpoint y la respuesta de cada uno se encuentra en`src/main/resources`.

## Repositorios

Se utilizó la clase `BaseRepository` como base para proporcionar métodos comunes a los repositorios hijos, de forma que estos puedan definir una interfaz con los métodos comunes sin tener que implementar nuevamente los mismos, ya que se encuentran implementados en la clase padre (`Base`).

# Convenciones

- **Rutas**: kebab-case
- **Datos devueltos**: snake_case
- **Métodos y variables**: camelCase
- **Nombres de clases**: PascalCase
- **Fechas**: dd-MM-yyyy (si o si con dos digitos)

# Endpoints y responsables de su programación

1. Poder realizar la acción de “Follow” (seguir) a un determinado usuario - (Fernanda Agustina Castaldo)
2. Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor - (Lisandro Giussani Alo)
3. Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?) - (Pilar Innocenti)
4. Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?) - (Martin Daniel Simonetti)
5. Dar de alta una nueva publicación. - (Martin Ignacio Romero)
6. Obtener un listado de las publicaciones realizadas en las últimas dos semanas, por los vendedores que un usuario sigue (para esto tener en cuenta      ordenamiento por fecha, publicaciones más recientes primero). - (Nadina Ambar Jauch)
7. Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor. - (Lisandro Giussani Alo)
8. Alfabético Ascendente y Descendente de los seguidos y lo seguidores - (Martin Daniel Simonetti)
9. Fecha Ascendente y Descendente de los posteos de los vendedores que sigue un usuario - (Pilar Innocenti)
10. Llevar a cabo la publicación de un nuevo producto en promoción.- (Martin Ignacio Romero)
11. Obtener la cantidad de productos en promoción de un determinado vendedor - (Lisandro Giussani Alo)
12. (Bonus) Obtener un listado de productos filtrado por una categoría y rango de precio - (Lisandro Giussani Alo)
13. (Bonus) Marcar un post de un vendedor como favoritoobtener los favoritos de un usuario - (Nadina Ambar Jauch)
14. (Bonus) Obtener una lista de los post favoritos de un usuario - (Nadina Ambar Jauch)
15. (Bonus) Sacar (eliminar) un post de los favoritos de un usuario - (Lisandro Giussani Alo)
16. (Bonus) Traer todos los usuarios - (Fernanda Agustina Castaldo)

# Testing

## Validaciones en campos para todas las US

| Dato/Parámetro  | ¿Obligatorio? | Validación                                                                                                                                                      | Mensaje de error                                                                                   |
|------------------|---------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------|
| user_id          | Sí            | Que el campo no esté vacío. <br> Mayor 0                                                                                                                   | El id no puede estar vacío. <br> El id debe ser mayor a cero                                     |
| date             | Sí            | Que el campo no esté vacío.                                                                                                                                  | La fecha no puede estar vacía.                                                                     |
| product_id       | Sí            | Que el campo no esté vacío. <br> Mayor 0                                                                                                                   | La id no puede estar vacía. <br> El id debe ser mayor a cero                                     |
| product_name     | Sí            | Que el campo no esté vacío. <br> Longitud máxima de 40 caracteres. <br> Que no posea caracteres especiales (%, &, $, etc), permite espacios.               | El campo no puede estar vacío. <br> La longitud no puede superar los 40 caracteres. <br> El campo no puede poseer caracteres especiales.  |
| type             | Sí            | Que el campo no esté vacío. <br> Longitud máxima de 15 caracteres. <br> Que no posea caracteres especiales (%, &, $, etc)                                 | El campo no puede estar vacío. <br> La longitud no puede superar los 15 caracteres. <br> El campo no puede poseer caracteres especiales.  |
| brand            | Sí            | Que el campo no esté vacío. <br> Longitud máxima de 25 caracteres. <br> Que no posea caracteres especiales (%, &, $, etc)                                 | La longitud no puede superar los 25 caracteres. <br> El campo no puede estar vacío. <br> El campo no puede poseer caracteres especiales.  |
| color            | Sí            | Que el campo no esté vacío. <br> Longitud máxima de 15 caracteres. <br> Que no posea caracteres especiales (%, &, $, etc)                                 | El campo no puede estar vacío. <br> La longitud no puede superar los 15 caracteres. <br> El campo no puede poseer caracteres especiales.  |
| notes            | No            | Longitud máxima de 80 caracteres. <br> Que no posea caracteres especiales (%, &, $, etc), permite espacios.                                                 | La longitud no puede superar los 80 caracteres. <br> El campo no puede poseer caracteres especiales.  |
| category         | Sí            | Que el campo no esté vacío.                                                                                                                                  | El campo no puede estar vacío.                                                                     |
| price            | Sí            | Que el campo no esté vacío. <br> El precio máximo puede ser 10.000.000.                                                                                     | El campo no puede estar vacío. <br> El precio máximo por producto es de 10.000.000                |

**Asignado**: Martin Ignacio Romero

## Tests unitarios

| US        | Situaciones de entrada                                                                                                     | Comportamiento Esperado                                                                                               | Asignado       |
|-----------|----------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------|-----------------|
| US-0001   | T-0001                                                                                                                    | Se cumple: Permite continuar con normalidad. <br> No se cumple: Notifica la no existencia mediante una excepción.      | Fernanda Castaldo      |
| US-0007   | T-0002                                                                                                                    | Se cumple: Permite continuar con normalidad. <br> No se cumple: Notifica la no existencia mediante una excepción.      | Lisandro Giussani Alo   |
| US-0008   | T-0003                                                                                                                    | Se cumple: Permite continuar con normalidad. <br> No se cumple: Notifica la no existencia mediante una excepción.      | Martin Daniel Simonetti  |
| US-0008   | T-0004                                                                                                                    | Devuelve la lista ordenada según el criterio solicitado.                                                                | Martin Daniel Simonetti |
| US-0009   | T-0005                                                                                                                    | Se cumple: Permite continuar con normalidad. <br> No se cumple: Notifica la no existencia mediante una excepción.      | Pilar Innocenti    |
| US-0009   | T-0006                                                                                                                    | Verificar el correcto ordenamiento ascendente y descendente por fecha.                                                 | Pilar Innocenti   |
| US-0002   | T-0007                                                                                                                    | Devuelve el cálculo correcto del total de la cantidad de seguidores que posee un usuario.                             | Lisandro Giussani Alo |
| US-0006   | T-0008                                                                                                                    | Devuelve únicamente los datos de las publicaciones que tengan fecha de publicación dentro de las últimas dos semanas a partir del día de la fecha. | Nadina Ambar Jauch     |

## Test de integración

| US         | Descripción                                                                                                       | Asignado                     |
|------------|-------------------------------------------------------------------------------------------------------------------|------------------------------|
| US-0001    | Seguir usuario                                                                                                   | Fernanda Castaldo            |
| US-0002    | Verificar que la cantidad de seguidores de un determinado usuario sea correcta.                                  | Lisandro Giussani Alo        |
| US-0005    | Crear post sin promo                                                                                              | Lisandro Giussani Alo        |
| US-0006    | Obtener posts de las últimas dos semanas de los vendedores seguidos por un usuario                                | Nadina Ambar Jauch           |
| US-0007    | Dejar de seguir usuario                                                                                            | Lisandro Giussani Alo        |
| US-0003, US-0004, US-0008 | Verificar ordenamiento de seguidores y seguidos                                                       | Martin Daniel Simonetti      |
| US-0009    | Verificar ordenamiento de fecha ascendente y descendente de los post                                            | Pilar Innocenti              |
| US-0010    | Crear post con promo                                                                                              | Martin Ignacio Romero        |
| US-0011    | Traer cantidad de posts en promoción                                                                              | Lisandro Giussani Alo        |
| US-0012    | Traer post por categoría                                                                                          | Lisandro Giussani Alo        |
| BONUS      | Traer cantidad de seguidores de usuario                                                                           | Lisandro Giussani Alo        |
| BONUS      | Traer listado de posts favoritos de un usuario                                                                    | Lisandro Giussani Alo        |

**Se logró un coverage total de 89%**

# Integrantes

- Nadina Ambar Jauch
- Martin Daniel Simonetti
- Martin Ignacio Romero
- Lisandro Giussani Alo
- Fernanda Agustina Castaldo
- Pilar Innocenti

# Cierre

Gracias por tomarse el tiempo de ver nuestro proyecto! Fue un viaje de aprendizaje en equipo. Este proyecto no solo  mejoró nuestras habilidades técnicas, sino que también nos enseñó valores fundamentales de colaboración y comunicación en un entorno de trabajo. También nos enseño a combinar el conocimiento individual con la fuerza del trabajo en conjunto para alcanzar metas comunes, a enfrentar desafíos juntos y a adaptarnos a diferentes perspectivas.
Esperamos que les guste
