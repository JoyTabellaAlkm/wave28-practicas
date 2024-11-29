import bootcamp.Persona;



public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona("Dario", 40, "31218999", 1.76, 78.5);
        Persona persona2 = new Persona("Tomas", 33, "2134566");
        Persona persona3 = new Persona();


        switch (persona1.calcularIMC()) {
            case 1:
                System.out.println("Sobre peso");
                break;
            case -1:
                System.out.println("Bajo peso");
                break;
            case 0:
                System.out.println("Saludable");
        }
        if (persona1.esMayorDeEdad())
            System.out.println("Es mayor de edad");
        else
            System.out.println("Es menor de edad");

    }

}
