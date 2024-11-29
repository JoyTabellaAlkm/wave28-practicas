package practica_ejercio_poo_parte1.src.meli.practica;

import practica_ejercio_poo_parte1.src.meli.practica.models.Persona;

public class Main {

    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Juan", 25, "123456789");
        Persona persona3 = new Persona("Santiago", 30, "7338287387", 80.0, 1.80);

        System.out.println("------------------------------------------");
        System.out.println("Resultados");
        System.out.println("------------------------------------------");

        System.out.println(persona3.esMayorDeEdad() ? "Es mayor de edad" : "No es mayor de edad");
        System.out.print("Resultado IMC: ");

        int resultado = persona3.calcularIMC();

        switch (resultado) {
            case -1:
                System.out.println("Bajo peso");
                break;
            case 0:
                System.out.println("Peso saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;
            default:
                break;
        }

        System.out.println("------------------------------------------");
        System.out.println("Información de la persona");
        System.out.println("------------------------------------------");

        System.out.println(persona3);
    }

}
