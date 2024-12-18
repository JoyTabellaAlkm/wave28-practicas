
# Sprint I - Java Spring Boot

## 🎯 Objetivo

Desarrollar una API para un escenario determinado de manera grupal. En el la siguiente sección se encuentra una descripción detallada del escenario y cada uno de los requerimientos solicitados.

## 📍Escenario y requerimientos iniciales

Mercado Libre sigue creciendo y para el año que viene  tiene como objetivo empezar a implementar una serie de herramientas que permitan a los compradores y vendedores tener una experiencia totalmente innovadora, en donde el lazo que los una sea mucho más cercano.

La fecha de lanzamiento se aproxima, por lo cual es necesaria la presentación de una versión Beta de lo que va a ser conocido como “SocialMeli”, en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen.

# 🤓☝🏻 Definiciones de equipo

* **Clonar el repositorio**
````
git clone https://github.com/InakiEtc/be_java_hisp_w28_g03.git
````

* **Abrir el IDE IntelliJ y ejecutar el programa**

*Nota: En caso de presentar problemas con la libreria de Lombok, seguir las siguienetes recomendaciones:*

```
-> Entrar a los Settings
-> Build, Excecution, Deployment
-> Compiler
-> Annotation Processors
-> Seleccionar el proyecto
-> Seleccionar la opción "Obtein processors from project classpath
-> Apply"
```

# 📋 Tablero de documentación y seguimiento

A continuación pueden acceder a nuestro tablero donde se presentan los tickets asignados así como la documentación.

[Tablero de GitHub con los tickets](https://github.com/users/InakiEtc/projects/1).

[Documentación completa de los endpoints en PDF](src/main/resources/DocumentacionEndpoints.pdf) (Está ubicada en la carpeta "resources")


# 🏄🏻‍♂️ Pruebas (Postman)

Una vez ejecutado el programa en el el IDE de IntelliJ, descargar de la carpeta *Resources* la colección de endpoints. Esta colección tiene las rutas y su respectivo número de US.

# 🤝🏻 Acuerdos del equipo

El equipo de desarrollo ha definido las siguientes reglas y estándares con el objetivo de mantener una estructura ordenada, evitar inconsistencias y facilitar la colaboración.

### 1️⃣ Creación de Posts
- **Productos preexistentes**:  
  Antes de crear un nuevo post, se debe asegurar de que los productos estén previamente creados en el sistema. Esto evita la duplicación y asegura la consistencia de los datos.

### 2️⃣ Estándares de Codificación
- **Uso de Camel Case**:  
  Todos los identificadores (variables, funciones, etc.) deben seguir el estándar de camel case. Ejemplos:
    - `productList`
    - `getProductDetails`

> [!NOTE]
> Para las clases e interfaces, se debe usar UpperCamelCase. Ejemplo: ```java public class Product { ... }```

- **Inyección de Dependencia con Constructores**:  
  Se debe implementar inyección de dependencias a través de constructores para garantizar un código más flexible, modular y fácilmente testeable.

### 3️⃣ Carga de Datos
- **Data recargada con JSON**:  
  Todos los datos iniciales y mock se deben cargar a través de archivos JSON. Esto permite mayor claridad en la estructura de los datos y facilita su reutilización durante el desarrollo.

### 4️⃣ Control de Versiones
- **Rama por persona**:  
  Cada miembro del equipo debe trabajar en una rama específica asociada a su nombre. Esto minimiza conflictos y mantiene el control sobre los cambios.
  Ejemplo:
    - `/baron_santiago`
    - `/bianchi_juan`

    <br>

- **Commit Convention**:  
  Las descripciones de los commits deben seguir una convención predefinida. Esto ayuda a comprender rápidamente el propósito de cada cambio. Ejemplo de prefijos:
    - `feat`: Para agregar nuevas funcionalidades.
    - `fix`: Para solucionar errores.
    - `docs`: Para cambios en documentación.
    - `style`: Para ajustes relacionados con formato o estilo del código.

### 5️⃣ Idioma
- **Uso del Inglés**:  
  Todo el código, nombres de variables, funciones, comentarios y documentación técnica deben estar en inglés. Esto asegura un estándar profesional y facilita la colaboración con equipos internacionales.

## 💻 Tecnologías usadas

    1. Java 21
    2. Spring Boot
    3. Spring boot Devtools
    4. Lombok

## 🏃🏻‍➡️ Integrantes del equipo

| Integrante   |      País      |
|----------|:-------------:|
| Lucas Bianchi |  Argentina 🇦🇷|
| Santiago Baron | Colombia 🇨🇴|
| Juan Bianchi |    Argentina 🇦🇷  |
| Gabriel Viloria | Colombia  🇨🇴|
| Julieta Noguera | Argentina 🇦🇷|
| Iñaki Etchegoyen | Argentina 🇦🇷|

## 🧲 Responsabilidades asignadas

| Código    | Historia de usuario   |      Responsable      | Revisores |
|----------|:-------------|:-------------:|:-------------:|
| US001 |  Dar follow a un determinado vendedor| Juan Bianchi | Julieta Noguera |
| US002 | Cantidad de usuarios que siguen a un determinado vendedor| Julieta Noguera | Gabriel Viloria |
| US003 |  Obtener listado de usuarios que siguen a determinado vendedor| Santiago Baron | Juan Bianchi |
| US004 |  Listado de todos los vendedores a los cuales sigue un determinado usuario| Lucas Bianchi | Iñaki Martin |
| US005 |  Dar de alta una nueva publicación | Iñaki Etchegoyen| Lucas Bianchi |
| US006 |  Listar publicaciones recientes de vendedores seguidos en las ultimas 2 semanas | Gabriel Viloria | Santiago Baron |
| US007 |  Poder realizar la acción de “Unfollow” a determino usuario | Santiago Baron | Juan Bianchi |
| US008 |  Ordenamiento alfabético ascendente y descendente | Julieta Noguera | Juan Bianchi |
| US009 |  Ordenamiento por fecha ascendente y descendente | Juan Bianchi | Gabriel Viloria |
| US0010 |  Llevar a cabo la publicación de un nuevo producto en promoción | Iñaki Etchegoyen | Julieta Noguera |
| US0011 |  Obtener la cantidad de productos en promoción de un determinado vendedor | Gabriel Viloria | Santiago Baron |
| US0012 |  Obtener un listado de todos los productos en promoción de un determinado vendedor | Lucas Bianchi | Santiago Baron |

**🎖️ Bonus (1 bonus por integrante adicional)**

| Código    | Historia de usuario   |      Responsable      | Revisores 
|----------|:-------------|:-------------:|:-------------:|
| US0013 |  Convertir un Post en un PromoPost | Iñaki Etchegoyen | Julieta Noguera |
| US0014 |  Filtrar productos por palabra clave | Santiago Baron | Lucas Bianchi |
| US0015 |  Filtrar productos por rango rango de precio | Gabriel Viloria | Lucas Bianchi |
| US0016 |  Filtrar post por rango categoria | Julieta Noguera | Iñaki Etchegoyen |
| US0017 |  Filtrar post por distintos atributos de productos | Juan Bianchi | Gabriel Viloria |
| US0018 |  Seguidores por nombre de usuario | Lucas Bianchi | Gabriel Viloria |


# 🌅 Agradecimientos

Un especial agradecimiento a nuestros instructores por su guía durante todo el proceso, así como a nuestros compañeros por llenarnos de conocimiento durante el corto tiempo que hemos compartido.

