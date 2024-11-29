package meli.practicas;

public class Main {

    public static void main(String[] args) {

        Persona persona1 = new Persona();
        System.out.println(persona1.mostrarPersona());
        System.out.println("La primera persona: ");

        Persona persona2 = new Persona("Valen Sierra", 17, "1000133672");
        System.out.println(persona2.mostrarPersona());
        System.out.println("La segunda persona: ");

        Persona persona3 = new Persona("Daniel Romero", 29, "1032478349", 78.0, 1.78);
        System.out.println(persona3.mostrarPersona());
        System.out.println("La tercera persona: ");

        //Persona persona4 = new Persona("Karina");
        //System.out.println(persona4.mostrarPersona());
        //System.out.println("La primera persona: ");
        switch (persona3.calcularImc()) {
            case -1:
                System.out.println(persona3.nombre + " : " + "La persona tiene bajo peso");
                break;
            case 0:
            System.out.println(persona3.nombre + " : " + "La persona tiene peso saludable");
                break;        
            default:
            System.out.println(persona3.nombre + " : " + "La persona tiene sobrepeso");
                break;
            
        }
        System.out.println(persona3.toString());
        System.out.print(persona2.nombre + " ");
        System.out.println(persona2.esMayorDeEdad() ? "es mayor de edad" : "es menor de edad");
    }
}
