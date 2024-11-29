package PooEjercicioPersona;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Martín", 39, "31469095");
        Persona persona3 = new Persona("Daniel", 20, "45000555", 47.9, 1.64);

        //Persona persona4 = new Persona("Claudio", 23);

        System.out.println(persona3.toString());

        if (persona3.esMayorDeEdad()) {
            System.out.println("La persona es mayor de edad");
        } else {
            System.out.println("La persona es menor de edad");
        }

        int imc = persona3.calcularMasaCorporal();

        switch (imc) {
            case -1:
                System.out.println("La persona está en situación de bajo peso");
                break;
            case 0:
                System.out.println("La persona está en situación de peso saludable");
                break;
            case 1:
                System.out.println("La persona está en situación de sobrepeso");
                break;
        }
    }
}
