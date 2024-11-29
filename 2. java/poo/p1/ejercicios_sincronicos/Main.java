package poo.p1.ejercicios_sincronicos;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Leandro Brey", 21, "44235945");
        Persona persona3 = new Persona("Camila Giudi", 28, "40395234", 65.5, 1.63);

        persona3.imprimirResultadoIMC();
        System.out.println("¿Es mayor de edad? " + persona3.esMayorDeEdad());
        System.out.println("Datos de la persona:");
        System.out.println(persona3);
    }
}
