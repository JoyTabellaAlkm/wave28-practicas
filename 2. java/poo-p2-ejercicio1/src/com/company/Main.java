package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        PracticaExcepciones p1 = new PracticaExcepciones("hola");
    }
}
class PracticaExcepciones {
    int a;
    int b = 300;

    PracticaExcepciones() {
        try {
            double cociente = b / a;
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }


    }

    PracticaExcepciones(String mensaje) {
        try {
            double cociente = b / a;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }


    }

}