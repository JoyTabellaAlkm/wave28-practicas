# Proyecto de API de Publicaciones
## Descripción
Este proyecto es una API RESTful para la gestión de un sistema de publicaciones que permite la interacción entre compradores y vendedores. Los compradores pueden seguir a los vendedores para ver sus publicaciones, y los vendedores pueden crear publicaciones para promocionar sus productos.

## Estructura del Proyecto
La API está construida en Java y sigue los principios de diseño REST. Cada integrante del equipo ha asumido la responsabilidad de uno o más endpoints, asegurando modularidad y una distribución equitativa de tareas.

### Endpoint Documentación
A continuación se presenta una breve descripción de los endpoints desarrollados por cada integrante del equipo. Todos los endpoints han sido probados usando [Postman](https://www.postman.com/).

#### Endpoints
1. **US 0001 - Follow User**
   - POST /users/{userId}/follow/{userIdToFollow}: Acción para seguir a un nuevo vendedor.
     **Responsable**: [Nuria Robledo]
2. **US 0002 - Followers count**
   - GET /users/{userId}/followers/count: Cantidad de usuarios que siguen a un vendedor.
     **Responsable**: [Carolina Schwab]
3. **US 0003 - Followers list**
   - `GET /users/{userId}/followers/list: Listar todos los seguidores de un vendedor.
     **Responsable**: [Mariano Chun]
4. **US 0004 - Followed list**
   - GET /users/{userId}/followed/list: Listado de vendedores que sigue un usuario ¿A quién sigo?.
     **Responsable**: [Mariano Chun]
5. **US 0005 - Create post**
   - POST /products/post: Agregar una nueva publicación, esta publicación también creará un producto.
     **Responsable**: [Azucena Panez]
6. **US 0006 - Posts by Followed Users**
   - GET /products/followed/{userId}/list: Lista de publicaciones de un vendedor que un usuario sigue en las últimas dos semanas, se ordena por fecha y publicaciones más recientes.
     **Responsable**: [Joaquin Seita]
7. **US 0007 - Unfollow user**
   - POST /users/{userId}/unfollow/{userIdToUnfollow}: Dejar de seguir a un vendedor.
     **Responsable**: [Camila Lopez]
8. **US 0008 - Followers list and Followed list (with order)**
   - GET /users/{userId}/followers/list?order=name_asc: Lista de seguidores de un vendedor en order alfabético ascendente.
   - GET /users/{userId}/followers/list?order=name_desc: Lista de seguidores de un vendedor en order alfabético descendente.
   - GET /users/{userId}/followed/list?order=name_asc:  Listado de vendedores que sigue un usuario en order ascendente.
   - GET /users/{userId}/followed/list?order=name_desc:  Listado de vendedores que sigue un usuario en order descendente.
     **Responsable**: [Mariano Chun]
9. **US 0009 - Posts by Followed Users (with order)**
   - GET /products/followed/{userId}/list?order=date_asc: Ordenamiento por fecha ascendente.
   - GET /products/followed/{userId}/list?order=date_desc: Ordenamiento por fecha y descendente.
     **Responsable**: [Joaquin Seita]
10. **US 0010 - Create Post Promo**
   - POST /products/promo-post: Llevar a cabo la publicación de un nuevo producto en promoción.
     **Responsable**: [Carolina Schwab]
11. **US 0011 - Posts with promo by user count**
   - GET /products/promo-post/count?user_id={userId}: Obtener la cantidad de productos en promoción de un determinado vendedor.
     **Responsable**: [Nuria Robledo]

## ENDPOINTS BONUS
12. **US 0012 - Get all post**
   - GET /products/all: Obtener una lista de todos los productos.
     **Responsable**: [Carolina Schwab]
13. **US 0013 - Posts with the best promo**
   - GET /products/best/promo-post: Listar las 10 publicaciones con mayor descuento, por defecto se obtiene las 10 de todas las categorías.
   - GET /products/best/promo-post?category=1: Tenemos la posibilidad de pasarle por parámetro una categoría específica para poder obtener las 10 publicaciones de dicha categoría.
     **Responsable**: [Camila Lopez]
14. **US 0014 - Add,remove and get favourite post**
   - POST /users/{userId}/favourite-post/{postId}/add : Agregar a favoritos una publicación.
   - DELETE /users/{userId}/favourite-post/{postId}/remove  : Eliminar una publicación de la lista de favoritos.
   - GET /users/{userId}/favourite-post: Listar todas las publicaciones favoritas de un usuario.
     **Responsable**: [Mariano Chun]
15. **US 0015 - Patch de precio**
   - PATCH /products/post/update-price/{id}/{price}: Actualizar el precio de una determinada publicación.
     **Responsable**: [Nuria Robledo]
16. **US 0016 - Patch promo post**
   - PATCH /products/update-promo/{id}/{discount}: Actualizar el descuento de una determinada publicación que esté en promoción.
     **Responsable**: [Carolina Schwab]

## Cómo Probar los Endpoints con Postman
1. **Descarga e instala** [Postman](https://www.postman.com/downloads/).
2. Importa la colección de endpoints de nuestro proyecto en Postman:
   - [SocialMeli.postman_collection.json]
3. Ajusta las variables de entorno si es necesario para autenticarte o para cualquier otro parámetro de configuración.
4. Realiza las pruebas de los endpoints definidos.

## Requisitos Previos
- Java 17 o superior
- Maven
- Archivos .json para obtener la información (se encuentran dentro del proyecto en la carpeta RESOURCES).

## Instalación
1. Clona el repositorio:
   git clone https://github.com/Caroschwab97/meliSocial.git
2. Branch master

## Validaciones
| Dato/Parametro| Validación |
|---------------|---------------|
| user_id | Que el campo no esté vacío. Mayor 0 |
| date | Que el campo no esté vacío|
| product_id | Que el campo no esté vacío. Mayor 0 |
| product_name | Que el campo no esté vacío. Longitud máxima de 40 caracteres.Que no posea caracteres especiales (%, &, $, etc), permite espacios. |
| type | Que el campo no esté vacío. Longitud máxima de 15 caracteres. Que no posea caracteres especiales (%, &, $, etc)|
| brand| Que el campo no esté vacío. Longitud máxima de 25 caracteres. Que no posea caracteres especiales (%, &, $, etc) |
| color | Que el campo no esté vacío. Longitud máxima de 15 caracteres. Que no posea caracteres especiales (%, &, $, etc)|
| notes | Longitud máxima de 80 caracteres. Que no posea caracteres especiales (%, &, $, etc), permite espacios. |
| category | Que el campo no esté vacío.|
| price | Que el campo no esté vacío. El precio máximo puede ser 10.000.000.|

## Pruebas
Este proyecto incluye pruebas unitarias e integraciones para asegurar la funcionalidad y estabilidad de los endpoints de la API.

### Tipos de Pruebas
  **Pruebas Unitarias**
   - Se han creado pruebas unitarias para verificar la lógica de negocio de cada uno de los componentes del sistema. Estas pruebas aseguran que las funciones individuales se comporten como se espera.
   1. **T0001 - Verificar que el usuario exista - US0001**
    - Se cumple:
      Permite continuar con normalidad.
    - No se cumple:
      Notifica la no existencia del usuario a seguir mediante una excepción NotFoundException.
      Notifica la no existencia del usuario seguidor mediante una excepción NotFoundException.
      Notifica si el usuario a seguir no es un vendedor mediante una excepción BadRequestException.
      Notifica si el usuario a seguir es el mismo mediante una excepción BadRequestException.
      **Responsable**: [Azucena Panez]

   2. **T0002 - Verificar que el usuario a dejar de seguir exista - US0007**
    - Se cumple:
      Permite continuar con normalidad.
    - No se cumple:
      Notifica la no existencia del usuario a dejar de seguir mediante una excepción NotFoundException.
      Notifica la no existencia del usuario seguidor mediante una excepción NotFoundException.
      Notifica si el usuario no contiene ningun seguido para dejar de seguir mediante una excepción NotFoundException.
      Notifica si el usuario no contiene usuario para dejar de seguir como seguido mediante una excepción NotFoundException.
      **Responsable**: [Mariano Chun]

   3. **T0003 - Verificar que el tipo de ordenamiento alfabetico exista - US0008**
    - Se cumple:
      Permite continuar con normalidad el correcto ordenamiento alfabetico para una lista de seguidores de un vendedor.
      Permite continuar con normalidad el correcto ordenamiento alfabetico para una lista de seguidos de un usuario.
    - No se cumple:
      Notificar si pasa un parametro de order invalido para listar los seguidores de un vendedor mediante una excepción BadRequestException.
      Notificar si pasa un parametro de order invalido para listar a los que sigue un usuario mediante una excepción BadRequestException.
      **Responsable**: [Camila Lopez]
   4. **T0004 - Verificar el correcto ordenamiento ascendente y descendente por nombre - US0008**
    - Se cumple:
      Permite continuar con normalidad.
      **Responsable**: [Carolina Schwab]

   5. **T0005 - Verificar que el tipo de ordenamiento por fecha exista - US0009**
    - Se cumple:
      Permite continuar con normalidad.
      Notificar si el usuario no tiene publicaciones.
    - No se cumple:
      Notificar si el usuario es invalido mediante una excepción BadRequestException.
      Notificar si el parametro de order es invalido mediante una excepción BadRequestException.
      **Responsable**: [Joaquin Seita]

   6. **T0006 - Verificar el correcto ordenamiento ascendente y descendente por fecha - US0009**
   - Se cumple:
      Permite continuar con normalidad.
      **Responsable**: [Nuria Robledo]
   
   7. **T0007 - Verificar que la cantidad de seguidores de un determinado usuario sea - US0002**
   - Se cumple:
      Permite continuar con normalidad.
    - No se cumple:
      Notificar si se pasa un usuario invalido mediante una excepción NotFoundException.
      **Responsable**: [Carolina Schwab]

   8. **T0008 - Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas - US0006**
    - Se cumple:
      Permite continuar con normalidad al consultar por publicaciones en las últimas dos semanas.
      **Responsable**: [Mariano Chun]


2. **Pruebas de Integración**
   - Las pruebas de integración se han implementado para evaluar cómo los diferentes módulos de la API interactúan entre sí. Estas pruebas validan que los endpoints funcionen correctamente cuando se invocan en conjunto.
   1. **IT 0001 - Follow User**
      **Responsable**: [Camila Lopez]
   2. **IT 0002 - Followers count**
      **Responsable**: [Camila Lopez]
   3. **IT 0003 - Followers list**
      **Responsable**: [Nuria Robledo]
   4. **IT 0004 - Followed list**
      **Responsable**: [Carolina Schwab]
   5. **IT 0005 - Create post**
      **Responsable**: [Joaquin Seita]
   6. **IT 0006 - Posts by Followed Users**
      **Responsable**: [Mariano Chun]
   7. **IT 0007 - Unfollow user**
      **Responsable**: [Azucena Panez]
   8. **IT 0008 - Followers list and Followed list (with order)** 
      Se testea al probar 3 y 4
   9. **IT 0009 - Posts by Followed Users (with order)**
      Se testea al probar el 6
   10. **IT 0010 - Create Post Promo**
      **Responsable**: [Joaquin Seita]
   11. **IT 0011 - Posts with promo by user count**
      **Responsable**: [Nuria Robledo]

## Coverage
 Coverage final del 87%

## Integrantes
- Mariano Chun
- Camila Lopez
- Azucena Panez
- Nuria Robledo
- Carolina Schwab
- Joaquin Seita
