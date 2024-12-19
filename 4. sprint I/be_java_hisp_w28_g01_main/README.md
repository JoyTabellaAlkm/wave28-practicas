# SocialMeli
![Logo](https://i.imgur.com/tmyP1Q6.png)


## ℹ️ Descripción
**SocialMeli** es una API Rest desarrollada para Mercado Libre que permite estrechar los lazos entre compradores y vendedores, promoviendo una experiencia innovadora. Los usuarios pueden seguir a sus vendedores favoritos, recibir actualizaciones sobre publicaciones recientes y acceder a promociones exclusivas. Esta versión beta implementa funcionalidades clave que forman parte de una futura plataforma social.




## 🛠️ Ejecución de la API
1. Clonar el repositorio:
   ```bash
   git clone https://github.com/dariogdominguez/be_java_hisp_w28_g01.git
   ```
2. Importar el proyecto en tu IDE preferido.
3. Iniciar la aplicación:
   ```bash
   spring-boot:run
   ```

### Pruebas
- La colección de Postman para realizar pruebas se encuentra alojada en `src/main/resources/SPRINT_1.postman_collection.json`.
- Importar la colección en Postman y configurar la URL base en el entorno correspondiente.

---
## 💻 Endpoints y responsables

### US 0001: Realizar la acción de "Follow" (seguir) a un determinado vendedor

```http
POST /users/{userId}/follow/{userIdToFollow}
```

| Parámetro       | Tipo     | Descripción                              |
| :------------ | :------- | :----------------------------------- |
| `userId`      | `int`    | **Requerido**. ID del usuario actual |
| `userIdToFollow` | `int`    | **Requerido**. ID del usuario a seguir |

#### Responsable: **Dario Dominguez**

---

### US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor

```http
GET /users/{userId}/followers/count
```

| Parámetro       | Tipo     | Descripción                          |
| :------------ | :------- | :--------------------------------- |
| `userId`      | `int`    | **Requerido**. ID del usuario |

#### Ejemplo de Respuesta
```json
{
  "user_id": 234,
  "user_name": "vendedor1",
  "followers_count": 35
}
```

#### Responsable: **Melanie Márquez C.**


---

### US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)

```http
GET /users/{userId}/followers/list
```

| Parámetro       | Tipo     | Descripción                          |
| :------------ | :------- | :--------------------------------- |
| `userId`      | `int`    | **Requerido**. ID del usuario |

#### Ejemplo de Respuesta
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
    }
  ]
}
```

#### Responsable: **Dario Dominguez**


---

### US 0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)

```http
GET /users/{userId}/followed/list
```

| Parámetro       | Tipo     | Descripción                          |
| :------------ | :------- | :--------------------------------- |
| `userId`      | `int`    | **Requerido**. ID del usuario |

#### Ejemplo de Respuesta
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
    }
  ]
}
```

#### Responsable: **Paloma Sosa Morales**


---

### US 0005: Crear una nueva publicación

```http
POST /products/post
```

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

#### Responsable: **Melania Simes**


---

### US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas

```http
GET /products/followed/{userId}/list
```

| Parámetro       | Tipo     | Descripción                          |
| :------------ | :------- | :--------------------------------- |
| `userId`      | `int`    | **Requerido**. ID del usuario |

#### Ejemplo de Respuesta
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
    }
  ]
}
```

#### Responsable: **Facundo Delavalle**


---

### US 0007: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor

```http
POST /users/{userId}/unfollow/{userIdToUnfollow}
```

| Parámetro       | Tipo     | Descripción                              |
| :------------ | :------- | :----------------------------------- |
| `userId`      | `int`    | **Requerido**. ID del usuario actual |
| `userIdToUnfollow` | `int`    | **Requerido**. ID del usuario a dejar de seguir |

#### Responsable: **Melanie Márquez C.**


---

### US 0008: Ordenamiento alfabético ascendente y descendente (aplica para US-003 y US-004)

```http
GET /users/{UserID}/followers/list?order=name_asc
    /users/{UserID}/followers/list?order=name_desc
    /users/{UserID}/followed/list?order=name_asc
    /users/{UserID}/followed/list?order=name_desc
```

| Parámetro       | Tipo     | Descripción                          |
| :------------ | :------- | :--------------------------------- |
| `name_asc`      | `String`    | **Requerido**. Alfabético ascendente. |
| `name_desc`      | `String`    | **Requerido**. Alfabético descendente. |

#### Responsable: **Dario Dominguez**


---

### US 0009: Ordenamiento por fecha ascendente y descendente (aplica para la US-006)

```http
GET /products/followed/{userId}/list?order=date_asc
    /products/followed/{userId}/list?order=date_desc
```

| Parámetro       | Tipo     | Descripción                          |
| :------------ | :------- | :--------------------------------- |
| `date_asc`      | `String`    | **Requerido**. Fecha ascendente (de más antigua a más nueva) |
| `date_desc`      | `String`    | **Requerido**. Fecha descendente (de más nueva a más antigua) |

#### Responsable: **Melania Simes**


---

### US 0010: Llevar a cabo la publicación de un nuevo producto en promoción

```http
POST /products/promo-post
```

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

#### Responsable: **Mateo Ferradans**


---

### US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor

```http
GET /products/promo-post/count?user_id={userId}
```

| Parámetro       | Tipo     | Descripción                          |
| :------------ | :------- | :--------------------------------- |
| `userId`      | `int`    | **Requerido**. ID del usuario |

#### Ejemplo de Respuesta
```json
{
    "user_id" : 234,
    "user_name": "vendedor1",
    "promo_products_count": 23
}
```

#### Responsable: **Paloma Sosa Morales**

---

## Endpoint Bonus

### US 0012: Obtener las publicaciones según el tipo de producto

```http
GET /products/type/{productType}
```

| Parámetro       | Tipo     | Descripción                          |
| :------------ | :------- | :--------------------------------- |
| `productType`      | `String`    | **Requerido**. Tipo de categoría |

#### Responsable: **Mateo Ferradans**

---
## 📑 Documentación

[Diagrama de clases: Lucidchart](https://lucid.app/lucidchart/fa13249b-4a17-4ca0-8332-e38ad023e012/edit?invitationId=inv_6cd69469-5a0e-41d8-ac89-7499d57c5d11)

[Tablero de tareas: Trello](https://trello.com/invite/b/675b2750a9c795769adfc231/ATTIc9933c0a6b1fd3d60472202d8b42e6d466E5EC42/social-meli)


## 👨‍💻👩‍💻 Autores

- Paloma Sosa Morales | [@palomasosa](https://github.com/palomasosa)
- Dario Dominguez | [@dariogdominguez](https://github.com/dariogdominguez)
- Melanie Márquez C. | [@MeliMarquez](https://github.com/MeliMarquez)
- Melania Simes | [@melasim](https://github.com/melasim)
- Facundo Delavalle | [@fdelavalle](https://github.com/fdelavalle)
- Mateo Ferradans | [@mferradans](https://github.com/mferradans)

---

## 🏁 Cierre y Agradecimientos
Gracias por revisar nuestro proyecto. Esperamos que disfruten explorando **SocialMeli** tanto como nosotros disfrutamos desarrollándolo.
