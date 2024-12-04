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

## POO - P2 - VIVO - Ejercicio 2

Debemos entregar un trabajo para una distribuidora de productos, por lo que vamos a generar un programa que realice diferentes operaciones. Tendremos dos categorías de productos diferentes: Perecederos y No Perecederos.


1. Crear una clase Producto que cuente con los siguientes atributos: String nombre y double precio, la misma debe definir los métodos getters y setters para sus atributos, un constructor que reciba todos sus atributos como parámetro y el método toString(). Crear el método calcular() al cual vamos a pasarle un parámetro de tipo int llamado cantidadDeProductos; este método tiene que multiplicar el precio por la cantidad de productos pasados.

2. Crear la clase Perecedero, que va a tener un atributo llamado diasPorCaducar de tipo int, al igual que para el producto, definir setters, getters, constructor que reciba todos los atributos por parámetro y el método toString(). Esta clase debe heredar de Producto y sobreescribir el método calcular(), el cual tiene que hacer lo mismo que la clase Producto (multiplicar el precio por la cantidad de productos) y adicionalmente, reducir el precio según los diasPorCaducar:
Si le resta un día (1) para caducar, se reducirá 4 veces el precio final.
Si le restan dos días (2) para caducar, se reducirá 3 veces el precio final.
Si le restan 3 días (3) para caducar, se reducirá la mitad de su precio final.

3. Crear la clase NoPerecedero, la misma va a tener un atributo llamado tipo, el mismo va a ser un String, crear setters, getters, constructor y método toString(); en esta clase el método calcular() va a hacer exactamente lo mismo que en la clase Producto.

4. Crear una clase ejecutable llamada Distribuidora donde van a crear un array de productos, imprimir el precio total al vender 5 productos de cada tipo. Crear los elementos del array con los datos que quieras.

## Clases Abstractas e Interfaces - VIVO - Ejercicio 1

Un banco tiene diferentes tipos de transacciones que puede llevar a cabo, entre ellas se encuentran: Depósito, Transferencia, Retiro de Efectivo, Consulta de Saldo, Pago de Servicios. Todas las transacciones tienen dos métodos en común, que son transaccionOk() y transaccionNoOk().

A partir de esto existen diferentes tipos de clientes que pueden interactuar con el banco:


Ejecutivos: Realizan Depósitos y Transferencias.
Basic: Realizan consultas de saldo, pagos de servicios y retiro de efectivo.
Cobradores: Realizan retiro de efectivo y consulta de saldos.

Implementar el escenario según corresponda para permitir a los clientes mencionados con anterioridad, el acceso a los diferentes métodos según la operación que deseen realizar.


Notas a tener en cuenta:

No es necesario implementar cálculos o funciones matemáticas. Los métodos pueden ser implementaciones de mensajes mediante System.out.println. Por ejemplo, al hacer un depósito, que aparezca el mensaje “Realizándose depósito”.
Basic, Cobrador y Ejecutivos pueden ser tratados como clases.
Transacción puede ser tratada como una Interfaz. Tener en cuenta que existen diferentes tipos de transacciones que implementarán esta interfaz principal.

## Clases Abstractas e Interfaces - VIVO - Ejercicio 2

Se plantea desarrollar un programa que permita mediante una interfaz imprimir diferentes tipos de documentos.

Entre los tipos de documentos se encuentran:


Curriculums: incluye a una persona con todos sus atributos más una lista de sus habilidades.
Libros en PDF: Incluyen atributos como cantidad de páginas, nombre del autor, título y género.
Informes: Incluyen un texto de n longitud, cantidad de páginas, autor, y revisor.
Representar un escenario donde se creen cada uno de estos objetos y que, por medio de un método estático de una interfaz imprimible, se pueda pasar cualquier tipo de documento y sea impreso el contenido. 

## Clases Abstractas e Interfaces - VIVO - Ejercicio 3

Se solicita la creación de una clase abstracta denominada Animal, de la cual deriven 3 animales: Perro, Gato y Vaca. Los 3 animales son capaces de “emitir sonidos”, para ello será necesario implementar un método que permita mostrar por pantalla el sonido que emite cada animal. Por ejemplo, en el caso del perro “guau”, el gato “miau” y la vaca “muuu”.

A partir de esto, teniendo en cuenta los gustos alimenticios de cada animal (gato y perro son considerados carnívoros y la vaca un hervíboro), incluir las interfaces necesarias para contemplar los métodos comerCarne o comerHierba.

Una vez realizado lo mencionado, llevar a cabo en el Main la creación de diferentes animales y la invocación de sus respectivas implementaciones de métodos.


Como propuesta extra se sugiere llamar a un método comerAnimal donde a partir del pasaje de un objeto de cualquier tipo de animal como parámetro, invoque al método para comer según corresponda a dicho animal.

## Ejercicio Integrador - Parte I 🚀

### Supermercado “El económico”

Un supermercado desea implementar un sistema, que le permita almacenar los datos de sus clientes y distintas facturas de las compras que los mencionados realicen. Para esto,  necesita poder realizar operaciones de creación, consulta, eliminación o actualización de datos de  todos los clientes y sus respectivas facturas asociadas.

De cada cliente se registran: dni, nombre y apellido. Por otro lado, las facturas que se generan cuando un cliente hace una compra contienen a un cliente, una lista de ítems y el total de la compra. De cada item o producto se guarda el código, nombre, cantidad comprada y costo unitario. 

Dada la complejidad que posee el sistema, el Project Manager que dirige el proyecto ha decidido realizarlo en dos sprints, donde cada uno de ellos tendrá como objetivo una entrega final de una serie de requerimientos.

#### Parte I

Se necesita:

- Crear el modelo de clases clases que conforman, una factura, los cuales son: Cliente, Item, Factura.
- Crear 3 clientes y guardarlos en una collection.
Recorrer la collection de clientes y mostrar por pantalla los datos de cada uno de ellos. 
- Eliminar uno de los clientes de la lista y volver a consultar e imprimir todos los clientes restantes.
- Solicitar por teclado un número de dni de un cliente para buscarlo. En caso de que el cliente se encuentre en la lista, mostrar sus datos, caso contrario, mostrar un mensaje que informe dicha situación.

## Ejercicios Integradores - P1 - VIVO

### Agencia de turismo

Una agencia de viajes premia a sus viajeros con descuentos cuando desean adquirir algún paquete turístico, el cual consiste en reservas de hotel, comida, boletos de viajes y transporte. Las reservas son almacenadas en localizadores, los cuales contienen los datos del cliente, el total y la reserva o varias reservas dependiendo del producto adquirido. Por tanto los descuentos se aplicarán cuando:

Si un cliente anteriormente adquirió al menos 2 localizadores, se le descontará un 5% del total para futuras compras.
Si un cliente adquiere un paquete completo que consiste en reserva de hotel, comida, boletos de viajes, transporte, recibirá un descuento del 10% del total de la factura.
Si un cliente adquiere 2 reservas de hotel o 2 boletos de viaje, se aplicará un descuento de 5% en esas reservas.
Al momento de generar el localizador se debe almacenar en una clase repositorio y se imprimirá el mismo con los detalles de la compra.

Se requiere crear un repositorio cliente, para así poder buscar las reservas anteriores del cliente y aplicar descuentos; en caso de no existir el cliente poder agregarlo al repositorio cliente.


1. Parte I 

    Presentar un escenario donde:

    - Crear un localizador con un paquete completo para un cliente, almacenar e imprimir el resultado.
    - Crear un localizador con 2 reservas de hotel y 2 de boletos para el mismo cliente anterior, almacenar e imprimir el resultado.
    - Crear un localizador con una sola reserva para el mismo cliente.
    - Verificar que los descuentos fueron aplicados.


2. Parte II (Opcional)

    Agregar una clase que permita realizar las siguientes consultas sobre los localizadores vendidos, empleando diferentes métodos que muestren:


    - Cantidad de localizadores vendidos.
    - Cantidad total de reservas.
    - Obtener un diccionario de todas las reservas clasificados por tipo (hotel, boleto,comida,transporte).
    - Total de ventas.
    - Promedio de todas las ventas.

## Ejercicio Integrador - Parte II 🚀

### Supermercado

Luego de la primera entrega satisfactoria, el Project Manager en conjunto con un analista funcional recabaron nuevos requerimientos para llevar a cabo una segunda parte de desarrollo en un nuevo sprint. Éstos se citan a continuación:


#### Parte II

- Crear una nueva factura.
- Antes de querer agregar una factura a una collection de facturas tener en cuenta que:
    - Será necesario validar si el cliente asociado a la factura se encuentra registrado en la collection de clientes. En caso de que no, el mismo deberá ser creado.
    - Será necesario crear una lista de items y asociarla a la factura creada.
    - El campo total de la factura es un campo calculado, por lo cual, para poder asignar este valor deberemos recorrer la lista de items y realizar las operaciones matemáticas necesarias para obtener el total.

#### Bonus

- Con la finalidad de optimizar el código, se requiere la creación de una interfaz “CRUD” que sea capaz de contener, mediante genéricos, todos los métodos necesarios para realizar altas, bajas, modificaciones y consultas.
- Crear o utilizar las correspondientes clases que sean capaz de implementar los métodos de la interfaz creada en el punto anterior.
- Modificar el método main para que, en lugar de realizar todo el código de manera secuencial, se pueda modularizar mediante el llamado de métodos.

## Ejercicios Integradores - P2 - VIVO

### DAKAR

Hacer punto por punto ordenadamente, sin saltear.

Realizar los diagramas de clase correspondientes en cada paso y aplicar los cambios a medida que vamos resolviendo los distintos puntos.


- Crear la clase vehículo que tenga los siguientes atributos:
    - Velocidad
    - Aceleración
    - AnguloDeGiro
    - Patente
    - Peso
    - Ruedas

- Modelar la clase Carrera que tiene los siguientes atributos:
    - Distancia
    - PremioEnDolares
    - Nombre
    - CantidadDeVehiculosPermitidos
    - Lista de Vehiculos

- Se quiere agregar dos nuevas categorías de Vehiculos:
    - Autos
    - Motos.

    Los autos pesan 1.000 kilos y las motos 300 kilos, los autos tienen 4 ruedas y las motos 2.


- Una carrera además tiene un conjunto de vehículos que participarán de la misma. Entonces, ahora la carrera va a tener la responsabilidad de poder agregar a un vehículo, por lo que debemos definir los siguientes métodos:
    ```java 
    public void darDeAltaAuto(velocidad,aceleracion,AnguloDeGiro,patente);

    public void darDeAltaMoto(velocidad,aceleracion,AnguloDeGiro,patente); 
    ```

    Ambos métodos agregan un vehículo siempre y cuando haya cupo.


    También vamos a tener la posibilidad de eliminar a un vehículo mediante dos métodos:
    ```java
    public void eliminarVehiculo(vehículo);

    public void eliminarVehiculoConPatente String unaPatente);
    ```
- Queremos poder definir el ganador de una carrera:

    El ganador será aquel que tenga el máximo valor determinado por la siguiente fórmula:
    ```
    Velocidad * ½ Aceleracion / (AnguloDeGiro*(Peso-Cantidad de Ruedas * 100)
    ```

- Las carreras también cuentan con vehículos socorristas que ante alguna emergencia van y reparan a un vehículo. Como los autos son muy diferentes a las motos, existen dos clases distintas de vehículos socorristas. Uno de estos solo sabe socorrer autos y otro solo sabe socorrer motos.

    Agregar las clases
            SocorristaAuto

            SocorristaMoto

    Agregar los métodos:
                    SocorristaAuto → public void socorrer(Auto unAuto)

            SocorristaMoto → public void socorrer(Moto unaMoto)


    Cuando un socorrista se acerca a un auto imprime por pantalla “Socorriendo auto” y el número de patente, cuando socorre a una moto este imprime por pantalla “Socorriendo moto” y el número de patente.


    Agregar a la clase carrera un socorrista de autos y uno de motos,.
    Agregar a la carrera la responsabilidad de socorrer una moto y un auto:
            

    public void socorrerAuto(String patente);

            public void socorrerMoto(String patente);