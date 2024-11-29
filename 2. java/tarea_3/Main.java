
/*
 * to compile terminal: javac Main.java
 * to run (after compile): java Main
 */

public class Main {

  public static void main(String[] args) {
    Persona persona1 = new Persona();
    Persona persona2 = new Persona("Klaus", "1022442130", 25);
    Persona persona3 = new Persona("Mariana", "000000000", 19, 50.0, 1.62);

    System.out.println("Formato: Nombre, dni, edad, peso, altura");
    System.out.print("Usuario: ");
    System.out.println(persona3.myToString());
    System.out.println("Nivel de peso: " + persona3.nivelPeso());
    System.out.println("Mayor de edad: " + persona3.esMayorDeEdad());
  }
}