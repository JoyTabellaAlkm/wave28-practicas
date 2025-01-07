# SocialMeli

## Descripción del problema
Las redes sociales actuales no ofrecen una experiencia optimizada para la interacción entre vendedores y compradores en un entorno estructurado. Los usuarios tienen dificultades para seguir las actividades de los vendedores, organizar sus publicaciones y obtener información relevante de manera eficiente.

## Definiciones de Equipo

## Solución
Crear una aplicación que permita a los usuarios realizar acciones clave, como seguir o dejar de seguir a vendedores, gestionar publicaciones de productos (incluyendo promociones) y acceder a estadísticas detalladas de sus interacciones. Además, ofrecer opciones de filtrado y ordenamiento para mejorar la experiencia de usuario.

## Tecnologías Utilizadas

- **IntelliJ IDEA:** Entorno de desarrollo integrado (IDE) altamente potente y versátil desarrollado por JetBrains. Ofrece herramientas avanzadas para la creación, depuración y gestión de proyectos Java, facilitando el desarrollo de software con una interfaz intuitiva y funciones inteligentes.

- **Java 21:** Lenguaje de programación versátil y robusto que forma la base del desarrollo de la API.

- **Spring Boot 3.4.0:** Framework que simplifica el desarrollo de aplicaciones Java, proporcionando configuraciones predeterminadas y una estructura fácil de usar.

- **Maven:** Herramienta de automatización de compilación y gestión de dependencias que facilita el desarrollo y la gestión del proyecto.

- **Spring Web:** Módulos de Spring que permiten el desarrollo de aplicaciones web de manera eficiente.

- **Git y GitHub:** Herramientas de control de versiones y plataforma de alojamiento que facilitan la colaboración y el seguimiento del desarrollo del proyecto.

- **Postman:** Plataforma para el desarrollo y prueba de API's, facilitando la validación de endpoints y la interacción con la API.

- **JUnit:** Marco de pruebas unitarias para garantizar la calidad del código y la funcionalidad de la API.

## Diagrama de Clases

El **Diagrama de Clases** representa las clases y las relaciones entre ellas en el sistema. Muestra la estructura estática del sistema, incluyendo las clases, sus atributos, métodos y cómo se relacionan. Este diagrama proporciona una visión general de la arquitectura y la organización de clases en el código fuente.

![Diagrama de Clases](/src/main/resources/static/Sprint%20N°%201.png)

# **Guía de Ejecución y Pruebas de la API** :rocket::rocket::rocket:
## **1. Ejecución de la API**
### **1.1 Ejecución Local**
La aplicación está desarrollada con **Spring Boot 3.4.0** y utiliza **Java 21** junto con **Maven** como herramienta de gestión de dependencias. Para ejecutar la API localmente:
#### **Pasos**
1. Abre una terminal en el directorio donde se encuentra el archivo `pom.xml`.
2. Ejecuta los siguientes comandos:
```bash
mvn clean install
mvn spring-boot:run
```
3. La aplicación se iniciará en el puerto **8080** por defecto.
4. Para verificar que la API está corriendo, accede a la siguiente URL en un navegador o herramienta de prueba:
```
http://localhost:8080
```
### **1.2 Ejecución como JAR**
Si prefieres generar el archivo JAR y ejecutarlo manualmente, sigue estos pasos:
#### **Pasos**
1. Genera el archivo `.jar`:
```bash
mvn package
```
2. El JAR se generará en la carpeta `target/`. Ejecuta el JAR con:
```bash
java -jar target/social-0.0.1-SNAPSHOT.jar
```
3. La API estará disponible en:
```
http://localhost:8080
```
---
## **2. Pruebas de la API**
Las pruebas funcionales de la API se realizan mediante **Postman**, ya que aún no hemos cubierto pruebas automatizadas en el curso.
### **2.1 Colección de Postman**
La colección de Postman, que contiene todas las solicitudes necesarias para probar la API, está ubicada en el siguiente directorio del proyecto:
```
src/main/resources/postman/SocialMeli.postman_collection.json
```
### **2.2 Importar la colección en Postman**
#### **Pasos**
1. Abre **Postman** en tu equipo.
2. Haz clic en el botón **Importar** en la parte superior izquierda.
3. Selecciona la opción **Upload Files** y busca la siguiente ruta en tu proyecto:
```
src/main/resources/postman/SocialMeli.postman_collection.json
```
4. Una vez importada, verás la colección **"SocialMeli"** en la sección de **Collections**.
5. Configura las variables necesarias si las hay (p.ej., `{{host}} = http://localhost:8080`).
6. Ejecuta cada solicitud según sea necesario para probar los endpoints.
---
## **3. Dependencias Importantes**
A continuación, se detallan las dependencias clave utilizadas en el proyecto junto con sus versiones:
- **Spring Boot Starter Web**: Proporciona funcionalidades esenciales para crear APIs REST.
  ```xml
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
      <version>3.4.0</version>
  </dependency>
  ```
- **Spring Boot DevTools**: Facilita el desarrollo con reinicio automático y herramientas adicionales.
  ```xml
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-devtools</artifactId>
      <version>3.4.0</version>
      <scope>runtime</scope>
      <optional>true</optional>
  </dependency>
  ```
- **Lombok**: Reduce el código repetitivo al generar getters, setters y constructores automáticamente.
  ```xml
  <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.18.30</version>
      <optional>true</optional>
  </dependency>
  ```
- **Spring Boot Starter Test**: Incluye herramientas de prueba como JUnit y Mockito.
  ```xml
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-test</artifactId>
      <version>3.4.0</version>
      <scope>test</scope>
  </dependency>
  ```

## Endpoints

### US 0001: Poder realizar la acción de "Follow" (seguir) a un determinado vendedor
**Responsables:** `Karina - Bryan`
**Método**: `POST`
**Ruta**: `/users/{userId}/follow/{userIdToFollow}`
**Ejemplo**: `/users/123/follow/234`
#### Respuestas
- **200 OK**: bodyless o DTO.
- **400 Bad Request**: bodyless o DTO.
#### Parámetros
| Parámetro      | Tipo | Descripción                       |
|----------------|------|-----------------------------------|
| `userId`       | int  | Número que identifica al usuario actual |
| `userIdToFollow` | int  | Número que identifica al usuario a seguir |
---
### US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
**Responsables:** `Karina - Bryan`
**Método**: `GET`
**Ruta**: `/users/{userId}/followers/count`
**Ejemplo**: `/users/234/followers/count`
#### Respuesta
```json
{
  "user_id": 234,
  "user_name": "vendedor1",
  "followers_count": 35
}
```
#### Parámetros
| Parámetro | Tipo | Descripción                       |
|-----------|------|-----------------------------------|
| `userId`  | int  | Número que identifica al usuario  |
---
### US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
**Responsables:** `Santiago Montoya - Eilin Dianella`
**Método**: `GET`
**Ruta**: `/users/{userId}/followers/list`
**Ejemplo**: `/users/234/followers/list`
#### Respuesta
```json
{
  "user_id": 234,
  "user_name": "vendedor1",
  "followers": [
    {
      "user_id": 4698,
      "user_name": "usuario1"
    },
    {
      "user_id": 1536,
      "user_name": "usuario2"
    },
    {
      "user_id": 2236,
      "user_name": "usuario3"
    }
  ]
}
```
#### Parámetros
| Parámetro | Tipo | Descripción                       |
|-----------|------|-----------------------------------|
| `userId`  | int  | Número que identifica al usuario  |
---
### US 0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
**Responsables:** `Santiago Montoya - Eilin Dianella`
**Método**: `GET`
**Ruta**: `/users/{userId}/followed/list`
**Ejemplo**: `/users/4698/followed/list`
#### Respuesta
```json
{
  "user_id": 4698,
  "user_name": "usuario1",
  "followed": [
    {
      "user_id": 234,
      "user_name": "vendedor1"
    },
    {
      "user_id": 6932,
      "user_name": "vendedor2"
    },
    {
      "user_id": 6631,
      "user_name": "vendedor3"
    }
  ]
}
```
#### Parámetros
| Parámetro | Tipo | Descripción                       |
|-----------|------|-----------------------------------|
| `userId`  | int  | Número que identifica al usuario  |
---
### US 0005: Dar de alta una nueva publicación
**Responsables:** `Santiago Mariño - Gianluca`
**Método**: `POST`
**Ruta**: `/products/post`
#### Payload
```json
{
  "user_id": 123,
  "date": "29-04-2021",
  "product": {
    "product_id": 1,
    "product_name": "Silla Gamer",
    "type": "Gamer",
    "brand": "Racer",
    "color": "Red & Black",
    "notes": "Special Edition"
  },
  "category": 100,
  "price": 1500.50
}
```
#### Respuestas
- **200 OK**
- **400 Bad Request**
#### Parámetros
| Parámetro       | Tipo       | Descripción                             |
|-----------------|------------|-----------------------------------------|
| `user_id`       | int        | Número que identifica al usuario        |
| `date`          | LocalDate  | Fecha en formato `dd-MM-yyyy`           |
| `product_id`    | int        | ID del producto asociado                |
| `product_name`  | String     | Nombre del producto                     |
| `type`          | String     | Tipo del producto                       |
| `brand`         | String     | Marca del producto                      |
| `color`         | String     | Color del producto                      |
| `notes`         | String     | Notas u observaciones del producto      |
| `category`      | int        | ID de la categoría                      |
| `price`         | double     | Precio del producto                     |




### US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas
**Responsables:** `Santiago Mariño - Gianluca`
**Método**: `GET`
**Ruta**: `/products/followed/{userId}/list`
**Ejemplo**: `/products/followed/4698/list`
#### Respuesta
```json
{
  "user_id": 4698,
  "posts": [
    {
      "user_id": 123,
      "post_id": 32,
      "date": "01-05-2021",
      "product": {
        "product_id": 62,
        "product_name": "Headset RGB Inalámbrico",
        "type": "Gamer",
        "brand": "Razer",
        "color": "Green with RGB",
        "notes": "Sin Batería"
      },
      "category": 120,
      "price": 2800.69
    },
    {
      "user_id": 234,
      "post_id": 18,
      "date": "29-04-2021",
      "product": {
        "product_id": 1,
        "productName": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
      },
      "category": 100,
      "price": 15000.50
    }
  ]
}
```
#### Parámetros
| Parámetro | Tipo | Descripción                       |
|-----------|------|-----------------------------------|
| `userId`  | int  | Número que identifica al usuario  |

### US 0007: Poder realizar la acción de "Unfollow" (dejar de seguir) a un determinado vendedor
**Responsables:** `Santiago Mariño - Gianluca`
**Método**: `POST`
**Ruta**: `/users/{userId}/unfollow/{userIdToUnfollow}`
**Ejemplo**: `/users/234/unfollow/123`
#### Respuestas
- **200 OK**: bodyless o DTO.
- **400 Bad Request**: bodyless o DTO.
#### Parámetros
| Parámetro          | Tipo | Descripción                              |
|------------------|------|----------------------------------|
| `userId`        | int  | Número que identifica al usuario actual |
| `userIdToUnfollow` | int  | Número que identifica al usuario a dejar de seguir |
---
### US 0008: Ordenamiento alfabético ascendente y descendente
**Responsables:** `Santiago Montoya - Eilin Dianella`
**Método**: `GET`
**Rutas Ejemplo**:
- `/users/{UserID}/followers/list?order=name_asc`
- `/users/{UserID}/followers/list?order=name_desc`
- `/users/{UserID}/followed/list?order=name_asc`
- `/users/{UserID}/followed/list?order=name_desc`
#### Descripción de `order`
| Orden       | Descripción                  |
|-------------|-----------------------------|
| `name_asc`  | Alfabético ascendente       |
| `name_desc` | Alfabético descendente      |
> *Nota: Este ordenamiento aplica solo para US 0003 y US 0004.*
---
### US 0009: Ordenamiento por fecha ascendente y descendente
**Responsables:** `Santiago Mariño - Gianluca`
**Método**: `GET`
**Rutas Ejemplo**:
- `/products/followed/{userId}/list?order=date_asc`
- `/products/followed/{userId}/list?order=date_desc`
#### Descripción de `order`
| Orden       | Descripción                               |
|-------------|------------------------------------------|
| `date_asc`  | Fecha ascendente (de más antigua a más nueva) |
| `date_desc` | Fecha descendente (de más nueva a más antigua) |
> *Nota: Este ordenamiento aplica solo para la US 0006.*
---
### US 0010: Llevar a cabo la publicación de un nuevo producto en promoción
**Responsables:** `Gianluca`
**Método**: `POST`
**Ruta**: `/products/promo-post`
#### Payload
```json
{
  "user_id": 234,
  "date": "29-04-2021",
  "product": {
    "product_id": 1,
    "product_name": "Silla Gamer",
    "type": "Gamer",
    "brand": "Racer",
    "color": "Red & Black",
    "notes": "Special Edition"
  },
  "category": 100,
  "price": 1500.50,
  "has_promo": true,
  "discount": 0.25
}
```
#### Respuestas
- **200 OK**
- **400 Bad Request**
#### Parámetros
| Parámetro       | Tipo       | Descripción                             |
|-----------------|------------|-----------------------------------------|
| `user_id`       | int        | Número que identifica al usuario        |
| `date`          | LocalDate  | Fecha en formato `dd-MM-yyyy`           |
| `product_id`    | int        | ID del producto asociado                |
| `product_name`  | String     | Nombre del producto                     |
| `type`          | String     | Tipo del producto                       |
| `brand`         | String     | Marca del producto                      |
| `color`         | String     | Color del producto                      |
| `notes`         | String     | Notas u observaciones del producto      |
| `category`      | int        | ID de la categoría                      |
| `price`         | double     | Precio del producto                     |
| `has_promo`     | boolean    | Campo `true` o `false` para promoción    |
| `discount`      | double     | Monto de descuento si está en promoción  |
---
### US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor
**Responsables:** `Karina - Bryan`
**Método**: `GET`
**Ruta**: `/products/promo-post/count?user_id={userId}`
#### Respuesta
```json
{
  "user_id": 234,
  "user_name": "vendedor1",
  "promo_products_count": 23
}
```
#### Parámetros
| Parámetro            | Tipo    | Descripción                                |
|----------------------|---------|------------------------------------------|
| `user_id`           | int     | Número que identifica al usuario          |
| `user_name`         | String  | Nombre del usuario                        |
| `promo_products_count` | int     | Cantidad de productos en promoción          |
---

## Bonus

### US 0012: Search 
Buscar y filtrar productos basados en atributos como `category`, `price`, `hasPromo` y `discount`, **para** encontrar fácilmente los productos que cumplan con mis criterios específicos. El buscador debe permitir filtros combinados y ordenamiento por precio o descuento.

**Responsables:** `Todo el equipo`
**Método**: `GET`
**Ruta**: `/products?search={query}&range_price={min_price}-{max_price}`

#### Respuesta
```json
[
    {
        "date": "01-11-2024",
        "product": {
            "type": "Electronics",
            "brand": "Dell",
            "color": "Silver",
            "notes": "High performance, ultra-portable laptop.",
            "product_id": 1,
            "product_name": "Laptop Dell XPS 13"
        },
        "category": 1,
        "price": 1200.0,
        "user_id": 1,
        "post_id": 1
    },
    {
        "date": "05-12-2024",
        "product": {
            "type": "Electronics",
            "brand": "Dell",
            "color": "Silver",
            "notes": "High performance, ultra-portable laptop.",
            "product_id": 1,
            "product_name": "Laptop Dell XPS 13"
        },
        "category": 1,
        "price": 1200.0,
        "user_id": 2,
        "post_id": 12
    }
]
```
#### Parámetros
| Parámetro            | Tipo    | Descripción                                |
|----------------------|---------|------------------------------------------|
| `query`           | String     | Query por el que se quiere buscar          |
| `rangePrice`         | String  | Rango de precio para filtrar productos donde se pasan dos valores numericos separados por un guion     |
---

## Validaciones
Se realizan las siguientes validaciones para los parámetros de las solicitudes:

| Dato/Parámetro   | ¿Obligatorio? | Validación                                                                                                                                                                   | Mensaje de error                                                                                                                                                            |
|------------------|---------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `user_id`        | SI            | <ul> <li>Que el campo no esté vacío.</li> <li> Mayor 0 </li> </ul>                                                                                                           | <ul> <li> El  id no puede estar vacío. </li> <li> El id debe ser mayor a cero. </li> </ul>                                                                                  |
| `date`           | SI            | <ul> <li> Que el campo no esté vacío. </li> </ul>                                                                                                                            | <ul> <li> La fecha no puede estar vacía. </li> </ul>                                                                                                                        |
| `product_id`     | SI            | <ul> <li>Que el campo no esté vacío.</li> <li> Mayor 0 </li> </ul>                                                                                                           | <ul> <li> La id no puede estar vacía. </li> <li> El id debe ser mayor a cero </li> </ul>                                                                                    |
| `product_name`   | SI            | <ul> <li>Que el campo no esté vacío.</li> <li> Longitud máxima de 40 caracteres. </li> <li> Que no posea caracteres especiales (%, &, $, etc), permite espacios. </li> </ul> | <ul> <li> El campo no puede estar vacío. </li> <li> La longitud no puede superar los 40 caracteres. </li> <li> El campo no puede poseer caracteres especiales. </li> </ul>  |
| `type`           | SI            | <ul> <li>Que el campo no esté vacío.</li> <li> Longitud máxima de 15 caracteres. </li> <li> Que no posea caracteres especiales (%, &, $, etc)  </li> </ul>                   | <ul> <li> El campo no puede estar vacío. </li> <li> La longitud no puede superar los 15 caracteres. </li> <li> El campo no puede poseer caracteres especiales. </li> </ul>  |
| `brand`          | SI            | <ul> <li>Que el campo no esté vacío.</li> <li> Longitud máxima de 25 caracteres. </li> <li> Que no posea caracteres especiales (%, &, $, etc) </li> </ul>                    | <ul> <li> La longitud no puede superar los 25 caracteres. </li> <li> El campo no puede estar vacío. </li> <li> El campo no puede poseer caracteres especiales. </li> </ul>  |
| `color`          | SI            | <ul> <li>Que el campo no esté vacío.</li> <li> Longitud máxima de 15 caracteres. </li> <li> Que no posea caracteres especiales (%, &, $, etc) </li> </ul>                    | <ul> <li> El campo no puede estar vacío. </li> <li> La longitud no puede superar los 15 caracteres. </li> <li> El campo no puede poseer caracteres especiales. </li> </ul>  |
| `notes`          | NO            | <ul> <li>Longitud máxima de 80 caracteres.</li> <li> Que no posea caracteres especiales (%, &, $, etc), permite espacios. </li> </ul>                                        | <ul> <li> La longitud no puede superar los 80 caracteres. </li> <li> El campo no puede poseer caracteres especiales. </li> </ul>                                            |
| `category`       | SI            | <ul> <li>Que el campo no esté vacío.</li> </ul>                                                                                                                              | <ul> <li> El campo no puede estar vacío. </li> </ul>                                                                                                                        |
| `price`          | SI            | <ul> <li>Que el campo no esté vacío.</li> <li> El precio máximo puede ser 10.000.000. </li> </ul>                                                                            | <ul> <li> El campo no puede estar vacío. </li> <li> El precio máximo por producto es de 10.000.000 </li> </ul>                                                              |





## Tests Unitarios

Para garantizar la robustez y la confiabilidad de la aplicación, se han implementado pruebas unitarias utilizando el framework JUnit. Las pruebas unitarias se centran en evaluar cada componente individual de la aplicación de manera aislada, verificando su comportamiento y asegurando que cumpla con los requisitos establecidos.

| No. de Test | Situaciones de Entrada                                            | Comportamiento Esperado                                      | Realizado por |
|-------------|------------------------------------------------------------------|-------------------------------------------------------------|-|
| UT-01       | Verificar que el usuario a seguir exista (US-0001)               | Se cumple: Permite continuar con normalidad.  <br/><br/>No se cumple: Notifica la no existencia mediante una excepción.               | `Brayan - Karen` |                                                                              
| UT-02       | Verificar que el usuario a dejar de seguir exista (US-0007)      | Se cumple: Permite continuar con normalidad.  <br/><br/>No se cumple: Notifica la no existencia mediante una excepción.               | `Santiago Mariño - Gianluca` |
| UT-03       | Verificar que el tipo de ordenamiento alfabético exista (US-0008) | Se cumple: Permite continuar con normalidad.  <br/><br/>No se cumple: Notifica la no existencia mediante una excepción.               | `Santiago Montoya - Eilin Dianella` |
| UT-04       | Verificar el correcto ordenamiento ascendente y descendente por nombre | Devuelve la lista ordenada según el criterio solicitado.     | `Santiago Montoya - Eilin Dianella`  |
| UT-05       | Verificar que el tipo de ordenamiento por fecha exista (US-0009) | Se cumple: Permite continuar con normalidad.    <br/><br/>No se cumple: Notifica la no existencia mediante una excepción.             | `Santiago Mariño - Gianluca` |
| UT-06       | Verificar el correcto ordenamiento ascendente y descendente por fecha (US-0009) | Verifica el correcto ordenamiento ascendente y descendente por fecha. | `Santiago Montoya - Eilin Dianella` |
| UT-07       | Verificar que la cantidad de seguidores de un determinado usuario sea correcta (US-0002) | Devuelve el cálculo correcto del total de seguidores.       | `Santiago Mariño - Gianluca`|
| UT-08       | Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas (US-0006) | Devuelve únicamente los datos de las publicaciones recientes. | `Brayan - Karen` |


## Tests de Integración

Además de las pruebas unitarias, la aplicación también se somete a pruebas de integración. Estas pruebas evalúan la interoperabilidad y el comportamiento conjunto de varios componentes del sistema. Las pruebas de integración son esenciales para garantizar que los diferentes módulos de la aplicación funcionen correctamente cuando se combinan.

| No. de Test | Situaciones de Entrada                                                                                             | Comportamiento Esperado                                                      | Realizado por               |
|-------------|--------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------|------------------------------|
| IT-01       | Usuario X sigue a Usuario Y.                                                                                       | Respuesta con status 200 (OK) y devolución correcta de la acción de "Follow".| `Brayan - Karen`            |
| IT-01       | Usuario X intenta seguir a Usuario Y (Usuario X no existe).                                                        | Respuesta con status 404 (Not Found) y mensaje de error indicando que el usuario no fue encontrado. | `Brayan - Karen`            |
| IT-02       | Usuario X solicita listado de seguidores.                                                                          | Respuesta con status 200 (OK) y listado de seguidores correcto.             | `Santiago Mariño - Gianluca` |
| IT-03       | Usuario X intenta dejar de seguir a Usuario Y.                                                                     | Respuesta con status 200 (OK) y mensaje confirmando que se ha dejado de seguir. | `Santiago Montoya - Eilin Dianella` |
| IT-04       | Usuario X solicita listado de vendedores a los que sigue.                                                          | Respuesta con status 200 (OK) y listado correcto de vendedores.            | `Brayan - Karen`            |
| IT-05       | Usuario X solicita el conteo de sus seguidores.                                                                    | Respuesta con status 200 (OK) y conteo correcto de seguidores.             | `Santiago Mariño - Gianluca` |
| IT-06       | Solicitud para dar de alta una nueva publicación con todos los datos válidos.                                      | Respuesta con status 200 (OK) y mensaje confirmando la creación correcta.  | `Santiago Mariño - Gianluca` |
| IT-07       | Solicitud de la cantidad de productos en promoción de un determinado vendedor (user_id = 2).                       | Respuesta con status 200 (OK) y devolución correcta de la cantidad de productos en promoción. | `Brayan - Karen`            |
| IT-08       | Solicitud para crear una publicación de un nuevo producto en promoción con todos los datos válidos.                | Respuesta con status 200 (OK) y mensaje confirmando la creación exitosa.   | `Santiago Mariño - Gianluca` |
| IT-09       | Usuario 1 solicita un listado de publicaciones realizadas por los vendedores que sigue en las últimas dos semanas. | Respuesta con status 200 (OK) y listado correcto de publicaciones.          | `Santiago Montoya - Eilin Dianella` |
| IT-BONUS    | Búsqueda de productos con un query "light" y un rango de precio "100-149".                                         | Respuesta con status 200 (OK) y devolución de resultados filtrados según los criterios. | `Santiago Mariño - Gianluca` |

## Cobertura de Código

Se ha realizado un análisis de cobertura de código para evaluar la extensión en la que las pruebas abarcan el código fuente. La cobertura de código proporciona información sobre las porciones de código que han sido ejecutadas durante las pruebas.

### Análisis de Cobertura de Código

La cobertura de código obtenida es superior al **80%**. Esto indica que un porcentaje significativo del código ha sido probado a través de las diferentes pruebas implementadas. Para validar la cobertura de código, se puede ejecutar el análisis de cobertura utilizando la herramienta de cobertura disponible en el IDE que estés utilizando. Esta herramienta te proporcionará un informe detallado sobre qué partes del código fueron ejecutadas durante las pruebas, así como cualquier área que pueda necesitar atención adicional en términos de pruebas.

## Integrantes

| Integrante                | País      |
|--------------------------|-----------|
| Santiago Mariño          | Argentina 🇦🇷 |
| Gianluca Panigatti      | Argentina 🇦🇷 |
| Eilin Dianella Restrepo  | Colombia 🇨🇴  |
| Santiago Montoya         | Colombia 🇨🇴  |
| Bryan Felipe Munoz       | Colombia 🇨🇴  |
| Karina Sierra            | Colombia 🇨🇴  |
