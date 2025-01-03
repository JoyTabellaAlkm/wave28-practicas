## SocialMeli

## Descripción

Mercado Libre sigue creciendo y para el próximo año tiene como objetivo implementar herramientas que permitan a los
compradores y vendedores tener una experiencia innovadora, en donde el lazo que los une sea mucho más cercano.

La versión Beta de **“SocialMeli”** permitirá a los compradores seguir a sus vendedores favoritos y estar al tanto de
todas las novedades que publiquen. Este proyecto se desarrolla en equipo bajo una serie de requerimientos funcionales
que se detallan a continuación.

## Requisitos

- **JDK:** 21
- **Versión de Java:** Compatible con JDK 21

### Ejecución de la API

1. Clonar este repositorio.
2. Asegurarse de tener instalada la **versión de JDK 21** para ejecutar el proyecto.
3. En caso de presentar problemas relacionados con anotaciones, asegurarse de tener configurado **Lombok** siguiendo
   estos pasos:
    - Ir a **Settings** (Configuración) de tu IDE (IntellJ Idea).
    - Buscar la sección **Annotation Processors**.
    - Habilitar la opción **"Obtain processors from project classpath"** para cada uno.

### Pruebas

1. La colección de Postman para probar los endpoints se encuentra alojada en el directorio `resources`.
2. ¿Cómo importar la colección? Puedes seguir los pasos en
   este [enlace tutorial](https://www.youtube.com/watch?v=-4CNWIPJDgo).

---

## Endpoints y Responsables

#### Todo el equipo estuvo trabajando en las diferentes funcionalidades; Sin embargo, se asignaron responsables específicos para cada una de ellas. A continuación, se detallan las asignaciones:

| **#**  | **Descripción**                                                         | **Ruta**                                                                                                | **Responsable**              |  
|--------|-------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------|------------------------------|  
| **1**  | Realizar la acción de "Follow" (seguir) a un vendedor.                  | `/users/{userId}/follow/{userIdToFollow}`                                                               | Ariana Luz Manusovich        |  
| **2**  | Obtener la cantidad de usuarios que siguen a un vendedor.               | `/users/{userId}/followers/count`                                                                       | Maria Silva                  |  
| **3**  | Obtener un listado de usuarios que siguen a un vendedor.                | `/users/{userId}/followers/list`                                                                        | Maria Silva                  |  
| **4**  | Obtener un listado de vendedores que sigue un usuario.                  | `/users/{userId}/followed/list`                                                                         | Ariana Luz Manusovich        |  
| **5**  | Publicar un nuevo producto.                                             | `/products/post`                                                                                        | Luciana Soledad Cerro Aragón |  
| **6**  | Listar publicaciones de vendedores seguidos en las últimas dos semanas. | `/products/followed/{userId}/list`                                                                      | Hugo Nicolás Peykovich       |  
| **7**  | Realizar la acción de "Unfollow" (dejar de seguir) a un vendedor.       | `/users/{userId}/unfollow/{userIdToUnfollow}`                                                           | Luciana Soledad Cerro Aragón |  
| **8**  | Ordenamiento alfabético ascendente y descendente.                       | `/users/{userId}/followers/list?order=name_asc`<br>`/users/{userId}/followed/list?order=name_desc`      | David Armando Moreno Porras  |  
| **9**  | Ordenamiento por fecha ascendente y descendente.                        | `/products/followed/{userId}/list?order=date_asc`<br>`/products/followed/{userId}/list?order=date_desc` | David Armando Moreno Porras  |  
| **10** | Publicar un nuevo producto en promoción.                                | `/products/promo-post`                                                                                  | David Alexander Arias Parra  |  
| **11** | Obtener la cantidad de productos en promoción de un vendedor.           | `/products/promo-post/count?user_id={userId}`                                                           | Hugo Nicolás Peykovich       |  

### Funcionalidad Bonus: Recompensas y Metas

Para fomentar la interacción entre vendedores y compradores y aumentar el número de seguidores, se ha desarrollado un
sistema de **metas y recompensas**. Este sistema permitirá a los vendedores:

1. **Establecer objetivos de seguidores:** Los vendedores pueden definir metas para incrementar su base de seguidores.
2. **Ofrecer recompensas:** Al alcanzar las metas, se asignan automáticamente recompensas a los seguidores.

**En este primer entregable, se implementará únicamente la funcionalidad de metas, mientras que la funcionalidad de
recompensas será desarrollada en un segundo entregable de ser posible.**

#### Requerimientos Funcionales

1. **Crear una meta:** Permitir a los vendedores definir una meta de seguidores.
    - **Endpoint:** `POST /user/{userId}/goals`
    - **Ejemplo:** Crear una meta de "500 seguidores".

2. **Ver el progreso de metas:** Obtener información sobre el estado de cumplimiento de las metas creadas.
    - **Endpoint:** `GET /user/{userId}/goals`
    - **Ejemplo:** Mostrar el porcentaje de progreso de la meta actual.

#### Flujo General

1. El vendedor crea una meta, por ejemplo: "500 seguidores".
2. El vendedor define una recompensa (para el segundo entregable):
    - **Nombre:** "10% de descuento".
    - **Descripción:** "Cupón de descuento al alcanzar la meta".
3. El sistema verifica el progreso de la meta.
4. (Para el segundo entregable) Al alcanzar la meta, el sistema asigna automáticamente la recompensa a los seguidores.

#### Documentación Técnica

Para más detalles sobre los requerimientos técnicos y funcionales, puedes consultar el siguiente documento:  
[Requerimientos Técnicos y Funcionales](https://drive.google.com/file/d/1IW6ry7LNaGpxDm2zQ8aEeuAkhVOo5eio/view?usp=sharing)

## Social Meli: Segunda Fase del Proyecto

La implementación "Social Meli" de MercadoLibre por el equipo "Bootcamp" ha tenido un gran éxito. Con los altos
estándares de calidad que MercadoLibre mantiene para sus productos de software, se definieron una serie de validaciones
y pruebas unitarias para garantizar el funcionamiento adecuado de todas las funcionalidades incluidas.

Este proyecto se basa en el desarrollo grupal del Sprint Nº 1, y se debe continuar con las validaciones y pruebas
unitarias correspondientes. Además, se sugiere implementar al menos un test de integración para cada User Story de la
primera versión para alcanzar una mayor cobertura de código.

Para referencia, un analista funcional ha proporcionado documentación específica con los requerimientos técnicos y
funcionales, puedes consultar el siguiente documento:  
[Requerimientos Técnicos y Funcionales]https://docs.google.com/document/d/1ghX51PzAs0k3HCOhIgl3uFKNBUx9PT8Z/edit

## Validaciones, Test y Responsabilidades

#### Todo el equipo estuvo trabajando en las validaciones siguientes:

| Dato/Parámetro  | Tipo      | Longitud   | Descripción                                         |
|-----------------|-----------|------------|-----------------------------------------------------|
| user_id         | Integer   | -          | Número que identifica al usuario actual             |
| user_name       | String    | 15         | Nombre de usuario asociado                          |
| followers_count | Integer   | -          | Cantidad de seguidores                              |
| id_post         | Integer   | -          | Número identificatorio de cada publicación          |
| date            | LocalDate | -          | Fecha de la publicación (formato dd-MM-yyyy)        |
| product_id      | Integer   | -          | Número identificatorio de cada producto             |
| product_name    | String    | 40         | Nombre del producto                                 |
| type            | String    | 15         | Tipo de producto                                    |
| brand           | String    | 25         | Marca del producto                                  |
| color           | String    | 15         | Color del producto                                  |
| notes           | String    | 80         | Notas u observaciones del producto                  |
| category        | Integer   | -          | Identificador de la categoría del producto          |
| price           | Double    | 10,000,000 | Precio del producto                                 |
| order           | String    | -          | Criterios: name_asc, name_desc, date_asc, date_desc |

#### Se asignaron responsables específicos para cada una de los test unitarios solicitados. A continuación, se detallan las asignaciones:

| Test uni   | Situaciones de entrada                                 | Comportamiento Esperado                        | Responsable                  |
|------------|--------------------------------------------------------|------------------------------------------------|------------------------------|
| **T-0001** | Verificar que el usuario a seguir exista. (US-0001)    | Continuar o notificar no existencia.           | Ariana Luz Manusovich        |
| **T-0002** | Verificar que el usuario a dejar de seguir exista.     | Continuar o notificar no existencia.           | Luciana Soledad Cerro Aragón |
| **T-0003** | Verificar el tipo de ordenamiento alfabético (US-0008) | Continuar o notificar no existencia.           | Ariana Luz Manusovich        |
| **T-0004** | Ordenamiento ascendente y descendente por nombre.      | Lista ordenada correctamente.                  | Luciana Soledad Cerro Aragón |
| **T-0005** | Verificar el tipo de ordenamiento por fecha (US-0009)  | Continuar o notificar no existencia.           | David Alexander Arias Parra  |
| **T-0006** | Ordenamiento ascendente y descendente por fecha.       | Lista ordenada correctamente.                  | David Armando Moreno Porras  |
| **T-0007** | Verificar la cantidad de seguidores correctos.         | Cantidad de seguidores correcta.               | Maria Silva                  |
| **T-0008** | Publicaciones de las últimas dos semanas correcta.     | Solo publicaciones de las últimas dos semanas. | Hugo Nicolás Peykovich       |
| **T-0009** | Verificar que una meta se crea correctamente           | Continuar o notificar que ya existe.           | Maria Silva                  |
| **T-0010** | Verificar que una meta se visualiza correctamente      | Mostrar meta o notificar no existencia.        | David Armando Moreno Porras  |

Se agregaron otros tests unitarios extras para aumentar el coverage.

#### Se asignaron responsables específicos para cada una de los test integrales solicitados. A continuación, se detallan las asignaciones:

| **#**  | **Ruta**                                                                                                | **Responsable**              |
|--------|---------------------------------------------------------------------------------------------------------|------------------------------|
| **1**  | `/users/{userId}/follow/{userIdToFollow}`                                                               | Ariana Luz Manusovich        |
| **2**  | `/users/{userId}/followers/count`                                                                       | Maria Silva                  |
| **3**  | `/users/{userId}/followers/list`                                                                        | Maria Silva                  |
| **4**  | `/users/{userId}/followed/list`                                                                         | Ariana Luz Manusovich        |
| **5**  | `/products/post`                                                                                        | Luciana Soledad Cerro Aragón |
| **6**  | `/products/followed/{userId}/list`                                                                      | Hugo Nicolás Peykovich       |
| **7**  | `/users/{userId}/unfollow/{userIdToUnfollow}`                                                           | Luciana Soledad Cerro Aragón |
| **8**  | `/users/{userId}/followers/list?order=name_asc`<br>`/users/{userId}/followed/list?order=name_desc`      | David Armando Moreno Porras  |
| **9**  | `/products/followed/{userId}/list?order=date_asc`<br>`/products/followed/{userId}/list?order=date_desc` | David Armando Moreno Porras  |
| **10** | `/products/promo-post`                                                                                  | David Alexander Arias Parra  |
| **11** | `/products/promo-post/count?user_id={userId}`                                                           | Hugo Nicolás Peykovich       |

#### El Proyecto alcanzó un coverage total del 100% en las metricas de Class y Method, un 99% en Line, y un 96% en Branch. Este coverage garantiza que el proyecto cumple con altos estandares de calidad.

## Integrantes - Equipo 2

- Ariana Luz Manusovich
- David Alexander Arias Parra
- David Armando Moreno Porras
- Hugo Nicolás Peykovich
- Luciana Soledad Cerro Aragón
- María Silva Toyo

## Cierre y Agradecimientos

Queremos agradecer a todo el equipo de mentores durante esta etapa. Han sido pilares claves para llevar a cabo este
proyecto, brindando enseñanzas y disposición. Agradecemos también a Mercado Libre por brindarnos herramientas valiosas
para crecer.

---
