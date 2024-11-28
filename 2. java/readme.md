# Ejercicios prácticos


## Ejercicio 1
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

## Ejercicio 2
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

## Ejercicio 3

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