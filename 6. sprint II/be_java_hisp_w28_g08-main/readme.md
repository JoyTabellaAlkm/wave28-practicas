# Documentación de API Rest SocialMeli

## 1. Descripción del problema 📝

Mercado Libre sigue creciendo y para el año que viene tiene como objetivo empezar a implementar una serie de herramientas que permitan a los compradores y vendedores tener una experiencia totalmente innovadora, en donde el lazo que los une sea mucho más cercano. El objetivo de SocialMeli es permitir a los compradores poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen en la plataforma.

## 2. Definiciones de equipo 📚

### 2.1 Diagrama de clases

<center>
    <img src="./src/main/resources/class-diagram.png">
</center>

### 2.2 Ejecución de la API

Para ejecutar la API, se recomienda seguir los siguientes pasos:

1. Clonar el proyecto con el comando `git clone`
2. Abrir el proyecto en IntelliJ
3. Ejecutar la aplicación con el botón ▶️
4. Verificar la conexión del proyecto en la ruta `http://localhost:8080`

### 2.3 Postman

Para cargar la colección de Postman con todos los endpoints de los requerimientos implementados, se recomiendoa seguir los siguientes pasos:

1. Abrir Postman
2. Importar la colección que se encuentra en la ruta `src/main/resources/postmanCollection-V3.json`
3. Enviar alguna solicitud al aplicativo y revisar su respuesta

### 2.4 Realizar pruebas funcionales a la API

Para realizar las pruebas correspondientes a cada uno de los requerimientos, se debe seleccionar alguno de los endpoints cargados en Postman, definir los datos que serán enviados al servidor, y por último, enviar la solicitud y esperar la respuesta. A continuación se muestra un ejemplo.

1. Seleccionar el endpoint de Postman y definir las variables o el cuerpo de la petición correspondientes.
<center>
    <img src="./src/main/resources/postman1.png">
</center>

2. Realizar el envío de la petición y confirmar que la respuesta dada sea la esperada.
<center>
    <img src="./src/main/resources/postman2.png">
</center>

### 2.5 Enlace a repositorio grupal

https://github.com/albaqueroh/be_java_hisp_w28_g08/tree/develop
https://github.com/users/albaqueroh/projects/1/views/1

## 3. Definición de requerimientos de endpoints y responsables 🗂️

A continuación, se presenta un detalle de los requerimientos implementados, junto con su responsable correspondiente.

| ID de requerimiento | Responsable          | Endpoint                                         | Descripción                                                                                                                                                                                                    |
| ------------------- | -------------------- | ------------------------------------------------ | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| US-0001             | Cristhian Santamaría | POST /users/{userId}/follow/{userIdToFollow}     | Poder realizar la acción de “Follow” (seguir) a un determinado vendedor.                                                                                                                                       |
| US-0002             | Felipe Morera        | GET /users/{userId}/followers/count              | Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor .                                                                                                                         |
| US-0003             | Leonardo Baquero     | GET /users/{userId}/followers/list               | Obtener un listado de todos los usuarios que siguen a un determinado vendedor. (¿Quién me sigue?)                                                                                                              |
| US-0004             | Daniel Franco        | GET /users/{userId}/followed/list                | Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario. (¿A quién sigo?)                                                                                                         |
| US-0005             | Nicolás Albarracín   | POST /products/post                              | Dar de alta una nueva publicación.                                                                                                                                                                             |
| US-0006             | Daniel Franco        | GET /products/followed/{userId}/list             | Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero). |
| US-0007             | Camilo Suarique      | POST /users/{userId}/unfollow/{userIdToUnfollow} | Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.                                                                                                                            |
| US-0008             | Camilo Suarique      | GET /path?order=name_asc - /path?order=name_desc | Ordenamiento alfabético ascendente y descendente. (US-0003 y US-0004)                                                                                                                                          |
| US-0009             | Nicolás Albarracín   | GET /path?order=date_asc - /path?order=date_desc | Ordenamiento por fecha ascendente y descendente. (US-0006)                                                                                                                                                     |
| US-00010            | Felipe Morera        | POST /products/promo-post                        | Llevar a cabo la publicación de un nuevo producto en promoción.                                                                                                                                                |
| US-00011            | Leonardo Baquero     | GET /products/promo-post/count?user_id={userId}  | Obtener la cantidad de productos en promoción de un determinado vendedor.                                                                                                                                      |
| US-00012            | Cristhian Santamaría | GET /products/promo-post/list?user_id={userId}   | Obtener un listado de todos los productos en promoción de un determinado vendedor.                                                                                                                             |

## 4. Definición de requerimientos de endpoints bonus 📌

### 4.1 Requerimiento US-0013

Obtener un listado de vendedores, con el valor promedio de descuento que tienen en sus publicaciones.

<center>

| Method | Sign                  |
| ------ | --------------------- |
| GET    | /users/average-promos |

| Status | Definición                   |
| ------ | ---------------------------- |
| 200    | Consulta satisfactoria       |
| 204    | No se encontraron vendedores |
| 400    | Ocurrió algún error          |

</center>

Respuesta esperada:

```json
[
  {
    "user_id": 1,
    "user_name": "vendedor1",
    "avergae_promo": 0.235
  },
  {
    "user_id": 2,
    "user_name": "vendedor2",
    "avergae_promo": 0.0
  }
]
```

### 4.2 Requerimiento US-0014

Obtener el usuario con más seguidores y sus publicaciones. (si tiene activas)

<center>

| Method | Sign                       |
| ------ | -------------------------- |
| GET    | /users/most-followed/posts |

| Status | Definición                                            |
| ------ | ----------------------------------------------------- |
| 200    | Consulta satisfactoria (si hay publicaciones)         |
| 204    | El usuario más seguido no tiene publicaciones activas |

</center>

Respuesta esperada:

```json
{
  "user_id": 123,
  "user_name": "NombreDelUsuarioMasSeguido",
  "number_of_followers": 20,
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
    }
  ]
}
```

## 5. Validaciones y testing 🧪

### 5.1 Validaciones 🏹

A continuación, se presenta la tabla la cuál describe las validaciones realizadas en los requerimientos **US-0005** y **US-0010**, ya que en estos requerimientos se recibe cómo entrada datos digitados por el usuario.

| Dato/Parámetro | ¿Obligatorio? | Validación                                                                                                                                                           | Mensaje de error                                                                                                                                                 |
| -------------- | ------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| user_id        | Si            | <ul><li>Que el campo no esté vacío.</li><li>Mayor a 0.</li></ul>                                                                                                     | <ul><li>El id no puede estar vacío.</li><li>El id debe ser mayor a 0.</li></ul>                                                                                  |
| date           | Si            | <ul><li>Que el campo no esté vacío.</li></ul>                                                                                                                        | <ul><li>La fecha no puede estar vacía.</li></ul>                                                                                                                 |
| product_id     | Si            | <ul><li>Que el campo no esté vacío.</li><li>Mayor a 0.</li></ul>                                                                                                     | <ul><li>El id no puede estar vacío.</li><li>El id debe ser mayor a 0.</li></ul>                                                                                  |
| product_name   | Si            | <ul><li>Que el campo no esté vacío.</li><li>Longitud máxima de 40 caracteres.</li><li>Que no posea caracteres especiales (%, &, $, etc), permite espacios.</li></ul> | <ul><li>El campo no puede estar vacío.</li><li>La longitud no puede superar los 40 caracteres.</li><li>El campo no puede poseer caracteres especiales.</li></ul> |
| type           | Si            | <ul><li>Que el campo no esté vacío.</li><li>Longitud máxima de 15 caracteres.</li><li>Que no posea caracteres especiales (%, &, $, etc)</li></ul>                    | <ul><li>El campo no puede estar vacío.</li><li>La longitud no puede superar los 15 caracteres.</li><li>El campo no puede poseer caracteres especiales.</li></ul> |
| brand          | Si            | <ul><li>Que el campo no esté vacío.</li><li>Longitud máxima de 25 caracteres.</li><li>Que no posea caracteres especiales (%, &, $, etc)</li></ul>                    | <ul><li>El campo no puede estar vacío.</li><li>La longitud no puede superar los 25 caracteres.</li><li>El campo no puede poseer caracteres especiales.</li></ul> |
| color          | Si            | <ul><li>Que el campo no esté vacío.</li><li>Longitud máxima de 15 caracteres.</li><li>Que no posea caracteres especiales (%, &, $, etc)</li></ul>                    | <ul><li>El campo no puede estar vacío.</li><li>La longitud no puede superar los 15 caracteres.</li><li>El campo no puede poseer caracteres especiales.</li></ul> |
| notes          | No            | <ul><li>Longitud máxima de 80 caracteres.</li><li>Que no posea caracteres especiales (%, &, $, etc)</li></ul>                                                        | <ul><li>La longitud no puede superar los 80 caracteres.</li><li>El campo no puede poseer caracteres especiales.</li></ul>                                        |
| category       | Si            | <ul><li>Que el campo no esté vacío.</li></ul>                                                                                                                        | <ul><li>El campo no puede estar vacío.</li></ul>                                                                                                                 |
| price          | Si            | <ul><li>Que el campo no esté vacío.</li><li>El precio máximo puede ser de 10.000.000.</li></ul>                                                                      | <ul><li>El id no puede estar vacío.</li><li>El precio máximo por producto es de 10.000.000.</li></ul>                                                            |

### 5.2 Definición de pruebas unitarias y responsables

A continuación, se presenta un detalle de las pruebas unitarias implementadas en los servicios, junto con su responsable correspondiente.

| ID de prueba | Situaciones de entrada                                                                                                                                               | Comportamiento esperado                                                                                                                            | Responsables                                      |
| ------------ | -------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------ |
| T-0001 ✅    | Verificar que el usuario a seguir exista (US-0001)                                                                                                                   | **Se cumple:** <br> Permite continuar con normalidad. <br> **No se cumple:** <br> Notifica la no existencia mediante una excepción.                | Cristhian Santamaría                             |
| T-0002 ✅    | Verificar que el usuario a dejar de seguir exista (US-0007)                                                                                                          | **Se cumple:** <br> Permite continuar con normalidad. <br> **No se cumple:** <br> Notifica la no existencia mediante una excepción.                | Camilo Suarique                                  |
| T-0003 ✅    | Verificar que el tipo de ordenamiento alfabético exista (US-0008)                                                                                                    | **Se cumple:** <br> Permite continuar con normalidad. <br> **No se cumple:** <br> Notifica la no existencia mediante una excepción.                | Leonardo Baquero, Camilo Suarique, Daniel Franco |
| T-0004 ✅    | Verificar el correcto ordenamiento ascendente y descendente por nombre (US-0008)                                                                                     | Devuelve la lista ordenada según el criterio solicitado.                                                                                           | Leonardo Baquero, Camilo Suarique, Daniel Franco |
| T-0005 ✅    | Verificar que el tipo de ordenamiento por fecha exista (US-0009)                                                                                                     | **Se cumple:** <br> Permite continuar con normalidad. <br> **No se cumple:** <br> Notifica la no existencia mediante una excepción.                | Nicolás Albarracín, Daniel Franco                |
| T-0006 ✅    | Verificar el correcto ordenamiento ascendente y descendente por fecha. (US-0009)                                                                                     | Verificar el correcto ordenamiento ascendente y descendente por fecha.                                                                             | Nicolás Albarracín, Daniel Franco                |
| T-0007 ✅    | Verificar que la cantidad de seguidores de un determinado usuario sea correcta. (US-0002)                                                                            | Devuelve el cálculo correcto del total de la cantidad de seguidores que posee un usuario.                                                          | Felipe Morera                                    |
| T-0008 ✅    | Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas. (US-0006) | Devuelve únicamente los datos de las publicaciones que tengan fecha de publicación dentro de las últimas dos semanas a partir del día de la fecha. | Daniel Franco                                    |

A continuación, se presenta un detalle de las pruebas unitarias implementadas en los repositorios, junto con su responsable correspondiente.

| Situaciones de entrada                     | Comportamiento esperado                                                        | Responsable     |
| ------------------------------------------ | ------------------------------------------------------------------------------ | --------------- |
| Listar todos los posts                     | Devuelve todos los posts guardados.                                            | Camilo Suarique |
| Crear un post                              | Devuelve el post guardado.                                                     | Camilo Suarique |
| Eliminar un post por id o entidad          | **Se cumple:** <br> Devuelve true. <br> **No se cumple:** <br> Devuelve false. | Camilo Suarique |
| Listar todos los usuarios                  | Devuelve todos los usuarios guardados.                                         | Camilo Suarique |
| Crear un usuario                           | Devuelve el usuario guardado.                                                  | Camilo Suarique |
| Eliminar un usuario por id o entidad       | **Se cumple:** <br> Devuelve true. <br> **No se cumple:** <br> Devuelve false. | Camilo Suarique |
| Listar todos los users followers           | Devuelve todos los users followers guardados.                                  | Camilo Suarique |
| Crear un user follower                     | Devuelve el user follower guardado.                                            | Camilo Suarique |
| Eliminar un user follower por id o entidad | **Se cumple:** <br> Devuelve true. <br> **No se cumple:** <br> Devuelve false. | Camilo Suarique |

### 5.3 Definición de pruebas unitarias bonus 🧑‍🔬

A continuación, se presenta un detalle de las pruebas unitarias cómo bonus implementadas en los servicios, junto con su responsable correspondiente.

| ID de prueba | Situaciones de entrada                                                                    | Comportamiento esperado                                                                                                                                       | Responsable          |
| ------------ | ----------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------- |
| T-0009       | Verificar que el usuario a seguir sea vendedor. (US-0001)                                 | **Se cumple:** <br> Permite continuar con normalidad. <br> **No se cumple:** <br> Notifica que el usuario no es vendedor mediante una excepción.              | Cristhian Santamaría |
| T-0010       | Verificar que un post se guarde. (US-0005)                                                | **Se cumple:** <br> Permite continuar con normalidad. <br> **No se cumple:** <br> Notifica el error en los campos digitados mediante una excepción.           | Nicolás Albarracín   |
| T-0011       | Verificar que un post en promoción se guarde. (US-0010)                                   | Devuelve un texto indicando que el post ha sido guardado exitosamente.                                                                                        | Felipe Morera        |
| T-0012       | Verificar que la cantidad de posts en promoción de un vendedor sea la correcta. (US-0011) | **Se cumple:** <br> Permite continuar con normalidad. <br> **No tiene posts:** <br> Permite continuar con normalidad.                                         | Leonardo Baquero     |
| T-0013       | Verificar que los posts retornados de un vendedor sean de promoción. (US-0012)            | **Se cumple:** <br> Permite continuar con normalidad. <br> **El usuario no es vendedor:** <br> Notifica que el usuario no es vendedor mediante una excepción. | Cristhian Santamaría |

### 5.4 Pruebas de integración 🧷

A continuación, se presenta un detalle de las pruebas de integración cómo bonus implementadas en la aplicación, junto con su responsable correspondiente.

| ID de prueba | Endpoint                                | Comportamiento esperado                                                                                                                                                     | Responsable        |
| ------------ | --------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------ |
| T-0014       | /products/post                          | <ul><li>Crear un post.</li><li>Lanzar una excepción 400 si los campos digitados por el usuario contienen errores de validación.</li></ul>                                   | Nicolás Albarracín |
| T-0015       | /products/promo-post                    | <ul><li>Crear un post en promoción.</li><li>Lanzar una excepción 400 si los campos digitados por el usuario contienen errores de validación.</li></ul>                      | Felipe Morera      |
| T-0016       | /users/{userId}/follow/{userIdToFollow} | <ul><li>Seguir al vendedor.</li><li>Lanzar una excepción 404 si el vendedor no existe.</li><li>Lanzar una excepción 400 si el usuario a seguir no es un vendedor.</li></ul> | Leonardo Baquero   |
| T-0017       | /users/{userId}/followers/count         | <ul><li>Retornar la cantidad de seguidores de un vendedor.</li><li>Lanzar una excepción 404 si el vendedor no existe.</li></ul>                                             | Felipe Morera      |
| T-0018       | /products/followed/{userId}/list        | <ul><li>Listar publicaciones sin parámetro de ordenamiento.</li><li>Listar publicaciones con parámetro de ordenamiento.</li></ul>                                           | Daniel Franco      |
| T-0019       | /users/average-promos                   | <ul><li>Listar promedio de promociones por vendedor.</li><li>Lanzar un estado 204 si no hay publicaciones.</li></ul>                                           | Nicolás Albaracín  |

### 5.5 Cobertura de código 🔒

A continuación, se presenta un detalle de la cobertura de código implementada a partir de las pruebas unitarias y las pruebas de integración implementadas.

<center>
    <img src="./src/main/resources/code-coverage.png">
</center>

## 6. Integrantes 🥇

- Andrés Camilo Suarique Méndez
- Andrés Felipe Morera Díaz
- Andrés Leonardo Baquero Hernández
- Cristhian David Santamaría León
- Daniel Alberto Franco Cabrera
- Nicolás Albarracín Piñeros

## 7. Cierre y agradecimientos

Para cerrar este sprint 2, el equipo 8 agradece a los mentores por compartir su conocimiento y experiencia de manera profesional y dinámica, permitiendo el aprendizaje continuo en lo que relata a Java y Spring Framework. Además, entre compañeros nos agradecemos por la colaboración y entusiasmo que hubo en el desarrollo de este sprint, dónde se siguieron fortaleciendo los conocimientos y lazos sociales.
