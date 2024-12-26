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

## Integrantes
- Mariano Chun
- Camila Lopez
- Azucena Panez
- Nuria Robledo
- Carolina Schwab
- Joaquin Seita

