## SocialMeli

## Descripción

Mercado Libre sigue creciendo y para el próximo año tiene como objetivo implementar herramientas que permitan a los compradores y vendedores tener una experiencia innovadora, en donde el lazo que los une sea mucho más cercano.

La versión Beta de **“SocialMeli”** permitirá a los compradores seguir a sus vendedores favoritos y estar al tanto de todas las novedades que publiquen. Este proyecto se desarrolla en equipo bajo una serie de requerimientos funcionales que se detallan a continuación.

## Requisitos

- **JDK:** 21
- **Versión de Java:** Compatible con JDK 21


### Ejecución de la API  

1. Clonar este repositorio.  
2. Asegurarse de tener instalada la **versión de JDK 21** para ejecutar el proyecto.  
3. En caso de presentar problemas relacionados con anotaciones, asegurarse de tener configurado **Lombok** siguiendo estos pasos:  
   - Ir a **Settings** (Configuración) de tu IDE (IntellJ Idea).  
   - Buscar la sección **Annotation Processors**.  
   - Habilitar la opción **"Obtain processors from project classpath"** para cada uno.  

### Pruebas  

1. La colección de Postman para probar los endpoints se encuentra alojada en el directorio `resources`.  
2. ¿Cómo importar la colección? Puedes seguir los pasos en este [enlace tutorial](https://www.youtube.com/watch?v=-4CNWIPJDgo).  

---

## Endpoints y Responsables

#### Todo el equipo estuvo trabajando en las diferentes funcionalidades; Sin embargo, se asignaron responsables específicos para cada una de ellas. A continuación, se detallan las asignaciones: ---

| **#**  | **Descripción**                                                             | **Ruta**                                         | **Responsable**                          |  
|--------|-----------------------------------------------------------------------------|-------------------------------------------------|------------------------------------------|  
| **1**  | Realizar la acción de "Follow" (seguir) a un vendedor.                      | `/users/{userId}/follow/{userIdToFollow}`       | Ariana Luz Manusovich                    |  
| **2**  | Obtener la cantidad de usuarios que siguen a un vendedor.                  | `/users/{userId}/followers/count`               | Maria Silva                              |  
| **3**  | Obtener un listado de usuarios que siguen a un vendedor.                   | `/users/{userId}/followers/list`                | Maria Silva                              |  
| **4**  | Obtener un listado de vendedores que sigue un usuario.                     | `/users/{userId}/followed/list`                 | Ariana Luz Manusovich                    |  
| **5**  | Publicar un nuevo producto.                                                | `/products/post`                                | Luciana Soledad Cerro Aragón             |  
| **6**  | Listar publicaciones de vendedores seguidos en las últimas dos semanas.    | `/products/followed/{userId}/list`             | Hugo Nicolás Peykovich                   |  
| **7**  | Realizar la acción de "Unfollow" (dejar de seguir) a un vendedor.          | `/users/{userId}/unfollow/{userIdToUnfollow}`  | Luciana Soledad Cerro Aragón             |  
| **8**  | Ordenamiento alfabético ascendente y descendente.                          | `/users/{userId}/followers/list?order=name_asc`<br>`/users/{userId}/followed/list?order=name_desc` | David Armando Moreno Porras             |  
| **9**  | Ordenamiento por fecha ascendente y descendente.                           | `/products/followed/{userId}/list?order=date_asc`<br>`/products/followed/{userId}/list?order=date_desc` | David Armando Moreno Porras             |  
| **10** | Publicar un nuevo producto en promoción.                                   | `/products/promo-post`                          | David Alexander Arias Parra              |  
| **11** | Obtener la cantidad de productos en promoción de un vendedor.             | `/products/promo-post/count?user_id={userId}`  | Hugo Nicolás Peykovich                   |  



### Funcionalidad Bonus: Recompensas y Metas  

Para fomentar la interacción entre vendedores y compradores y aumentar el número de seguidores, se ha desarrollado un sistema de **metas y recompensas**. Este sistema permitirá a los vendedores:  

1. **Establecer objetivos de seguidores:** Los vendedores pueden definir metas para incrementar su base de seguidores.  
2. **Ofrecer recompensas:** Al alcanzar las metas, se asignan automáticamente recompensas a los seguidores.  

**En este primer entregable, se implementará únicamente la funcionalidad de metas, mientras que la funcionalidad de recompensas será desarrollada en un segundo entregable de ser posible.**  

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

## Integrantes - Equipo 2

- Ariana Luz Manusovich
- David Alexander Arias Parra
- David Armando Moreno Porras
- Hugo Nicolás Peykovich
- Luciana Soledad Cerro Aragón
- María Silva Toyo

## Cierre y Agradecimientos

Queremos agradecer a todo el equipo de mentores durante esta etapa. Han sido pilares claves para llevar a cabo este proyecto, brindando enseñanzas y disposición. Agradecemos también a Mercado Libre por brindarnos herramientas valiosas para crecer.

---