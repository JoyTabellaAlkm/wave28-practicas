import bootcamp.Persona;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        System.out.println("La primera persona: ");
        System.out.println(persona1.mostrarPersona());

        Persona persona2 = new Persona("Valen Sierra", 17, "1000133672");
        System.out.println("La segunda persona: ");
        System.out.println(persona2.mostrarPersona());

        Persona persona3 = new Persona("Daniel Romero", 29, "1032478349", 78.0, 1.78);
        System.out.println("La tercera persona: ");
        System.out.println(persona3.mostrarPersona());
        //Persona persona4 = new Persona("Karina");
        //Persona persona4 = new Persona(30);

        switch (persona3.calcularImc()) {
            case -1:
                System.out.println("La persona " + persona3.nombre + " tiene bajo peso");
                break;
            case 0:
                System.out.println("La persona " + persona3.nombre + " tiene bajo peso adecuado");
                break;
            default:
                System.out.println("La persona " + persona3.nombre + " tiene sobrepeso");
                break;
        }
        System.out.println(persona3.toString());
        System.out.println(persona2.nombre + " " + (persona2.esMayorDeEdad() ? "es mayor de edad" : "es menor de edad"));
    }
}







