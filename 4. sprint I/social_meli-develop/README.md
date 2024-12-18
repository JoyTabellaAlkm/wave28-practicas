# SocialMeli - W28 - Equipo 4

## Escenario dispuesto y descripción

MercadoLibre está buscando expandir sus funcionalidades y permitirle a los compradores y vendedores avanzar en sus interacciones. Para eso, se desarrolla una nueva aplicación donde los compradores podrán seguir a sus vendedores favoritos y estar siempre al tanto de las novedades de estos últimos.

## Requisitos y ejecución
### Requisitos
- Java 21 o superior
- Maven 3.9.9 o superior
- Postman (opcional, para probar los endpoints)

## Instrucciones para ejecutar el proyecto

### **1. Clonar el repositorio**
Clonar este proyecto en el entorno local utilizando el siguiente comando:
```bash
git clone <URL_DEL_REPOSITORIO>
cd <NOMBRE_DEL_PROYECTO>
```
### **2. Compilar y empaquetar el proyecto**
Compilar el proyecto y resolver todas las dependencias con Maven:
```bash
mvn clean install
```

### **3. Ejecutar la aplicación**
Iniciar la aplicación desde la IDE elegida (recomendamos IntelliJ IDEA) o usando el siguiente comando:
```bash
mvn spring-boot:run
```
La API estará disponible en `http://localhost:8080` de manera predeterminada.

## **Probar los endpoints**

Para probar los endpoints, se puede usar la colección de Postman proporcionada en la carpeta `src/main/resources`:

### **Importar la colección en Postman**
1. Abrir Postman.
2. Ir a File > Import.
3. Seleccionar el archivo `social_meli_postman_collection_v2.json` ubicado en la carpeta `resources`.
4. Ejecutar las solicitudes incluidas en la colección para interactuar con los endpoints de la API.

## **Notas adicionales**

- **Cambiar el puerto de la aplicación**:  
  Si se necesita cambiar el puerto por defecto, editar la propiedad `server.port` en el archivo `application.properties` ubicado en `src/main/resources`.

- **Resolver problemas de dependencias**:  
  Si se producen problemas al ejecutar la API, verificar que las dependencias se hayan instalado correctamente con Maven. Usa:
  ```bash
  mvn dependency:resolve
  ```


## Endpoints y responsables

| User Story (Requerimiento) | Responsable       | Descripción                                                                                                                                                                                                     |
|------------------|-------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| US001            | Lucas Caraballo   | Poder realizar la acción de “Follow” (seguir) a un determinado usuario.                                                                                                                                         |
| US002            | Lucas Caraballo   | Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor.                                                                                                                           |
| US003            | Jorge Calderón    | Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?).                                                                                                                |
| US004            | Jorge Calderón    | Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?).                                                                                                           |
| US005            | Francisco Muslera | Dar de alta una nueva publicación.                                                                                                                                                                              |
| US006            | Lara Ferreyra     | Obtener un listado de las publicaciones realizadas en las últimas dos semanas, por los vendedores que un usuario sigue (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero). |
| US007            | Lucas Caraballo   | Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.                                                                                                                             |
| US008            | Nicolás Dias      | Feature de filtrado por orden alfabético ascendente y descendente.                                                                                                                                              |
| US009            | Lara Ferreyra     | Feature de filtrado por fecha ascendente y descendente.                                                                                                                                                         |
| US010            | Francisco Muslera | Llevar a cabo la publicación de un nuevo producto en promoción.                                                                                                                                                 |
| US011            | Joaquín Rivero    | Obtener la cantidad de productos en promoción de un determinado vendedor.                                                                                                                                       |
| US012 (BONUS)    | Jorge Calderón    | Obtener los (cantidad) productos más publicados por los usuarios.                                                                                                                                               |
| US013 (BONUS)    | Lucas Caraballo   | Obtener los (cantidad) usuarios más seguidos.                                                                                                                                                                   |
| US014 (BONUS)    | Lucas Caraballo   | Obtener los (cantidad) usuarios con más productos publicados.                                                                                                                                                   |
| US015 (BONUS)    | Nicolás Dias      | Obtener las métricas de un usuario.                                                                                                                                                                             |

## Autores de la APP

### SM / Mentor asignado
- Ariel Jaime - ext_arjaime@mercadolibre.com

### Desarrolladores
- Francisco Muslera - francisco.muslera@mercadolibre.com
- Joaquin Rivero - joaquin.jrivero@mercadolibre.com
- Jorge Calderón - jorge.calderon@mercadolibre.com
- Lara Ferreyra - lara.ferreyra@mercadolibre.com
- Lucas Caraballo - lucas.caraballo@mercadolibre.com
- Nicolás Días - nicolasezequiel.dias@mercadolibre.com
