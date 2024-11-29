# Índice de Contenidos

1. [Introducción a Java - P1 - Ejercicio 1](#introducción-a-java---p1---ejercicio-1)
2. [Introducción a Java - P1 - Ejercicio 2](#introducción-a-java---p1---ejercicio-2)
3. [Introducción a Java - P1 - VIVO Ejercicio 1](#introducción-a-java---p1---vivo-ejercicio-1)
4. [Introducción a Java - P2 - Ejercicio 1](#introducción-a-java---p2---ejercicio-1)
5. [Introducción a Java - P2 - Ejercicio 2](#introducción-a-java---p2---ejercicio-2)
6. [Introducción a Java - P2 - VIVO - Ejercicio 1](#introducción-a-java---p2---vivo---ejercicio-1)
7. [POO - P1 - Ejercicio 1](#poo---p1---ejercicio-1)


# Ejercicios prácticos


## Introducción a Java - P1 - Ejercicio 1
Un estudiante de programación intentó realizar declaraciones de variables con sus respectivos tipos en Java pero tuvo varias dudas mientras lo hacía. A partir de esto, nos brindó su código y pidió la ayuda de un desarrollador experimentado que pueda darle una mano. ¿Podrías verificar su código y realizar las correcciones necesarias?


Pistas: 

Recordá que en Java cada línea de código tiene una forma particular de cerrarse.
Recordá que Java es un lenguaje FUERTEMENTE TIPADO, por lo que el correcto tipo de dato es muy importante en la declaración de cada variable

```java
public class Main {
    String apellido = "Gomez";
    int edad = 35;
    boolean bool = false;
    double sueldo = 45857.90;
    String nombre = "Julián";
    public static void main(String[] args) {
        System.out.println("Todo good");
    }
}
```

## Introducción a Java - P1 - Ejercicio 2
```java
String 1nombre;  // mal, inicia con un numero
int edad; // bien, cumple con las reglas.
double $ueldo; // mal, usa caracteres especiales.
String @pellido; //mal, usa caracter especial.
String direccion; //bien, cumple con las reglas.
boolean licencia_de_conducir; //bien, cumple con las reglas.
double estatura de la persona; //mal, porque contiene espacios.
int cantidad-de-hijos; //mal, contiene caracter especial "-"
```

## Introducción a Java - P1 - VIVO Ejercicio 1

```java
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Pablo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperaturas = {
                {-2,33},
                {-3,32},
                {-8,27},
                {4,37},
                {6,42},
                {5,43},
                {0,39},
                {-7,26},
                {-1,31},
                {-10,35},
        };
        int valMin, valMax, indexMin = 0, indexMax = 0;
        valMin = temperaturas[0][0];
        valMax = temperaturas[0][1];
        for(int c = 0; c < 10; c++){
            if (temperaturas[c][0] < valMin){
                valMin = temperaturas[c][0];
                indexMin = c;
            }
            if (temperaturas[c][1] > valMax){
                valMax = temperaturas[c][1];
                indexMax = c;
            }
        }
        System.out.println("La menor temperatura la tuvo " + ciudades[indexMin] + ", "+ valMin + "º C.");
        System.out.println("La mayor temperatura la tuvo " + ciudades[indexMax] + ", " + valMax + "º C.");
    }
}
```

## Introducción a Java - P2 - Ejercicio 1

Una empresa de paquetería desea realizar una actualización de los sueldos de sus empleados. Para ello, desean la creación de un programa que al asignar un dni y un monto determine si al empleado en cuestión le corresponde o no un aumento. Para ello tiene en cuenta las siguientes condiciones:

a) Si el sueldo es menor o igual a $20.000 le corresponde un 20% de aumento.

b) Si el sueldo es mayor a $20.000 pero menor o igual a $45.000 le corresponde un 10% de aumento.

c) Si el sueldo es mayor a $45.000 le corresponde un 5% de aumento.

Un programador comenzó con el planteo, pero necesita un poco de ayuda para determinar las condiciones para cada uno de los casos y qué acciones deberían hacerse... ¿Podrías ayudarlo a terminar?

```java
double sueldoBase = 21000; //monto de ejemplo
String dni = "12345678"; //dni de ejemplo
double sueldoConAumento;

if (sueldoBase <= 20000) {
    sueldoConAumento = sueldoBase + (sueldoBase * 0.2);
}
else {
  if (sueldoBase > 20000 && sueldoBase <= 45000){
      sueldoConAumento = sueldoBase + (sueldoBase * 0.1);
  }
  else {
      sueldoConAumento = sueldoBase + (sueldoBase * 0.05);
  }
}

System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);
```

## Introducción a Java - P2 - Ejercicio 2
Una empresa de servicios de seguridad tiene 7 clientes que todos los meses abonan la cuota de dos posibles tipos de servicio:

Servicio 1: Seguridad con cámaras - Precio Fijo de $1500 al mes

Servicio 2: Seguridad con cámaras + patrullaje - Precio de $1500 + $700 por el servicio de patrullaje

Dependiendo del tipo de servicio, se desea poder calcular el monto final de la factura para cada uno de los clientes. Tener en cuenta, que existe un vector en donde se almacena el tipo de servicio que cada cliente adquirió.

```java
        int[] serviciosCli = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios
        double totalFactura;

        for (int i = 0; i < serviciosCli.length; i++) {
            if (serviciosCli[i] == 1) {
                totalFactura = 15000;
                System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println ("El monto de la factura es de: " + totalFactura);
            }
            else {
                totalFactura = 15700;
                System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println ("El monto de la factura es de: " + totalFactura);
            }
        }
```
## Introducción a Java - P2 - VIVO - Ejercicio 1

Todos los años en la provincia de Misiones, al norte de Argentina se lleva a cabo un evento conocido como “Carrera de la Selva”. El mismo se trata de una competición donde los mejores maratonistas y corredores de Latinoamérica se reúnen para desafiar sus habilidades deportivas.

La competencia cuenta con 3 categorías dependiendo de su dificultad y de ellas se guarda una id, el nombre y una breve descripción:

Circuito chico: 2 km por selva y arroyos.
Circuito medio: 5 km por selva, arroyos y barro.
Circuito avanzado: 10 km por selva, arroyos, barro y escalada en piedra.
Para poder conocer en qué categoría competirá cada participante se manejarán inscripciones. Cada inscripción debe contar con un número de inscripción, una categoría, un participante y el monto a abonar por el participante.


Cada participante puede inscribirse únicamente a una categoría y necesita, para dicha inscripción, proporcionar los siguientes datos: número de participante, dni, nombre, apellido, edad, celular, número de emergencia y grupo sanguíneo.


Para concluir con la inscripción, se debe calcular el monto a abonar por cada participante. Para ello se tienen en cuenta los siguientes valores:


- Inscripción Circuito chico: Menores de 18 años $1300. Mayores de 18 años $1500.

- Inscripción Circuito medio: Menores de 18 años $2000. Mayores de 18 años $2300.

- Inscripción Circuito Avanzado: No se permite inscripciones a menores de 18 años. Mayores de 18 años $2800


A partir de estos datos brindados, los organizadores de la carrera manifestaron que necesitan de una aplicación que sea capaz de:


Crear 3 objetos de tipo categoría (uno por cada categoría) con sus respectivos datos.
Crear un nuevo participante e inscribirlo en una categoría. Calcular el monto de inscripción que deberá abon
ar (Por ejemplo: si el participante se inscribe a la categoría Circuito chico y tiene 21 años, el monto a abonar es de $1500).
Inscribir al azar algunos participantes en diferentes categorías (al menos uno en cada una).
Mostrar por pantalla todos los inscriptos a una determinada categoría con sus correspondientes datos y número de inscripción.
Desinscribir a un participante. Mostrar como queda la lista de inscriptos en la categoría donde se encontraba.
Calcular el monto total recaudado por cada categoría y el total de toda la carrera incluyendo todas las categorías.

## POO - P1 - Ejercicio 1

Al momento de crear la clase Automovil se han cometido algunos errores en su diseño. ¿Puedes identificarlos y corregirlos siguiendo lo que has aprendido acerca de ellas?

```java
public class Automovil {

    String marca;
    String color;
    double kilometros;

    public Automovil() {

    }

    public Automovil(String marca, String color, double kilometros) {
        this.marca = marca;
        this.color = color;
        this.kilometros = kilometros;
    }

    public String mostrarMarcaYColor() {
        String marcaYColor = "La marca del auto es: " + this.marca + ". El color del auto es: " + this.color;
        return marcaYColor;

    }
}
```