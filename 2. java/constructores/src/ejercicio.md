# Ejercicios prácticos
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