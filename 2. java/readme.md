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

## POO - P1 - VIVO - Ejercicio 1

Creá una clase Persona, la cual tendrá los siguientes atributos: nombre, edad, dni (en este caso vamos a representarlo como una cadena de caracteres), peso y altura ¿Qué tipo de dato le asignarías a las variables de instancia? ¿Cómo sería la estructura básica de tu clase?


```java


public class Persona {

    String nombre;
    int edad;
    String dni;
    double peso;
    int altura; // en cm

}

```

## POO - P1 - VIVO - Ejercicio 2

Vamos a crear diferentes constructores en la clase Persona, uno sin parámetros, el segundo debe recibir como parámetro nombre, edad y dni; por último creamos un tercero que reciba todos los atributos de la clase como parámetro.

```java
public class Persona {

    String nombre;
    int edad;
    String dni;
    double peso;
    int altura; // en cm

    public Persona() {

    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, int altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }
}

```


## POO - P1 - VIVO - Ejercicio 3

Creá una clase nueva llamada Main, donde declares un método main como te enseñamos anteriormente. Esto nos permitirá ejecutar nuestra aplicación.

En la clase Main que acabamos de crear, dentro del método main() te pedimos que crees un objeto de tipo Persona por cada constructor que hayamos definido en la clase, recuerda poner un nombre significativo a las variables donde vas a asignar cada objeto. ¿Cómo lo harías? A continuación vamos a crear otro objeto de tipo persona y vamos a construirlo pasando solamente un valor para el nombre y otro para la edad en el constructor. ¿Es esto posible? ¿Qué sucede si tratamos de hacer esto?

```java
public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Pedro", 22, "abc123");
        Persona persona3 = new Persona("Susana", 24, "abc1234", 50.5, 163);

        //Persona persona4 = new Persona("Pedro", 25);  No se puede porque no existe un constructor con ese tipo de parametros.
    }
}
```

## POO - P1 - VIVO - Ejercicio 4

En la clase Persona implementaremos los siguientes métodos: cacularIMC(), la fórmula para calcularlo es: peso/(altura^2) - (peso expresado en kg y altura en mts), si este cálculo devuelve un valor menor que 20, la función debe retornar -1, si devuelve un número entre 20 y 25 inclusive para los dos valores, el método debe retornar un 0, por último, si devuelve un número mayor que 25 debe retornar un 1. Una vez creado el método anterior, agreguemos el método esMayorDeEdad() el cual debe retornar una valor booleano, teniendo en cuenta que la mayoría de edad será considerada en este caso, a partir de los 18 años. Finalmente agregar un método toString() que va a devolver toda la información de la persona.

¡Recuerda! Puedes ayudarte de los métodos de la clase java.lang.Math para calcular la potencia.

```java


public class Persona {

    String nombre;
    int edad;
    String dni;
    double peso;
    int altura; // en cm

    public Persona() {

    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, int altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        double alturaMts = this.altura / 100.0;
        double imc = this.peso / (alturaMts * alturaMts);

        if (imc < 20) {
            return -1;
        } else if (imc >= 20 && imc <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        return (this.edad >= 18);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}

```

## POO - P1 - VIVO - Ejercicio 5

Desde la clase Main vamos a calcular el IMC de la última persona que creamos (la que creamos correctamente mediante el constructor que recibe todos los atributos como parámetro). También vamos a averiguar si es mayor de edad o no; ten en cuenta que en ambos casos, dependiendo de los resultados retornados por los métodos, debes imprimir un mensaje acorde para el usuario. Finalmente queremos mostrar todos los datos de esa persona imprimiendo dicha información por consola. El formato en que vas a mostrar los datos y los mensajes quedan a tu criterio, pero debe ser legible y descriptivo para quien ve la salida del programa.

```java
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Pedro", 22, "abc123");
        Persona persona3 = new Persona("Susana", 24, "abc1234", 55.5, 163);


        System.out.println(persona3.toString());
        System.out.println("Es mayor de edad: " + persona3.esMayorDeEdad());
        System.out.println("IMC -->" + persona3.calcularIMC());
        int imcPersona3 = persona3.calcularIMC();
        switch (imcPersona3) {
            case -1:
                System.out.println("Bajo peso");
                break;
            case 0:
                System.out.println("Peso saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;
        }

        //Persona persona4 = new Persona("Pedro", 25);  No se puede porque no existe un constructor con ese tipo de parametros.
    }
}
```

## POO - P2 - Ejercicio 1

La operación realizada en el siguiente programa lanzará una excepción, necesitamos que realices el manejo correspondiente para lograr el siguiente comportamiento:

Permitir la ejecución del código y capturar la excepción lanzada
Imprimir por consola el mensaje de error de la misma al realizar la captura
Imprimir por consola el texto de la variable mensaje Final, de modo tal que se muestre siempre (es decir, se lance o no una excepción)
Pistas:

Recuerda que para acceder al mensaje de error de la excepción utilizamos el método .getMessage()

```java
public class Main {
    public static void main(String[] args) {

        try{
            int[] numeros = new int[5];
            numeros[5] = 10;
        }catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Este es el ultimo mensaje");
        }
    }

}
```


## POO - P2 - VIVO - Ejercicio 1

1. Crear una clase PracticaExcepciones que defina los atributos a = 0 y b = 300 de tipo int. Calcular el cociente de b/a. Controlar la excepción que se lanza indicando el mensaje “Se ha producido un error”. Al final del programa siempre deberá indicar el mensaje “Programa finalizado”

```java
public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public Double dividir() {
       double resultado = 0;
        try{
            resultado = b/a;
        } catch (ArithmeticException e){
            System.out.println("Se ha producido un error.");
            return Double.NaN;
        } finally {
            System.out.println("Programa finalizado.");
        }
        return resultado;
    }
}

```

2. Modificar el programa anterior para que, al producirse el error, en vez de imprimir por consola el mensaje “Se ha producido un error”, lo lance como una excepción de tipo IllegalArgumentException con el mensaje “No se puede dividir por cero”

```java
public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public Double dividir() {
       double resultado = 0;
        try{
            resultado = b/a;
        } catch (ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado.");
        }
        return resultado;
    }
}

```