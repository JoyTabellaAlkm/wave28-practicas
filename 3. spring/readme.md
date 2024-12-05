# Arquitectura Multicapa

## Estructura de carpetas
![carpetas](/docs/estructura_carpetas.png "Estructura de carpetas")

## Controller

Se encarga de manejar las request y response junto con los datos que contienen(comunicación con el cliente), 
además tiene control sobre los endpoints, y necesita comunicarse con el **Service** 
para seguir con el funcionamiento de la API.

* Se usa la anotación **@RestController**
* Solo debería conocer Objetos **DTOs**

## Service

Tiene que tener la mayor cantidad de lógica de negocio(cálculos, excepciones, etc), es la parte central de la API, 
recibe los datos del **Controller** para trabajar y según sea necesario puede comunicarse con el **Repository**.

* Se usa la anotación **@Service**
* Puede llegar a conocer todos los objetos **Models**, **DTOs** y **Entities**.
* Debido a que trabaja con distintos objetos
  - Suele tener alguna forma de *convertir un objeto en otro* 
  - Puede usar un *objeto para crear otro*
  - También se puede usar alguna librería como [Model Mapper](http://modelmapper.org/getting-started/)

## Repository

Su objetivo es controlar y persistir los **datos** de la API, se encarga de las operaciones de CRUD 
(Create, Read, Update, Delete) además puede llegar a devolver los datos *ordenados* y/o *filtrados* 
según sea necesario.

* Se usa la anotación **@Repository**
* Solo debería conocer Objetos **Entities**
* Pueden usar Objetos **Optional< T >**, donde T sería la entidad, pueden consultar este [blog de Baeldung](https://www.baeldung.com/java-optional)
* Disclaimer: vamos a trabajarlo como un listado de objetos en esta primera parte
* En un futuro usaremos algún ORM

# Tarea: completar las siguientes secciones

## DTO

## Entity

## 1. Introducción a Spring - P1 - VIVO 

## 2. Introducción a Spring - P2 - PG


### Números Romanos
#### Objetivo
  El objetivo de esta guía es poder aanzar y profundizar los conceptos de creación de APIS
  con Spring Boot. Para ello se plantean una serie de ejercicios simples que permiten repasar
  los temas que se trabajaron en la clase. ¿Are you ready?
#### Consigna
Los romanos eran un grupo inteligente. Conquistaron la mayor parte de Europa y la
gobernaron durante cientos de años. Inventaron carreteras de hormigón y rectas e incluso
bikinis. Sin embargo, una cosa que nunca descubrieron fue el número cero. Esto hizo que
escribir y fechar historias extensas de sus hazañas fuera un poco más desaante, pero el
sistema de números que se les ocurrió todavía está en uso hoy. Por ejemplo, la BBC usa
números romanos para fechar sus programas.
Los romanos escribieron números usando letras: I, V, X, L, C, D, M. (observe que estas letras
tienen muchas líneas rectas y, por lo tanto, son fáciles de cortar en tabletas de piedra).
1. En este contexto se requiere desarrollar una API para convertir un número decimal a
un número romano. Algunos casos de prueba:
  - 1 → I
  - 2 → II
  - 3 → III
  - 4 → IV
  - 5 → V
  - 7 → VII
  - 10 → X
  - 13 → XIII
  - 50 → L
  - 100 → C
  - 500 → D
  - 1000 → M
