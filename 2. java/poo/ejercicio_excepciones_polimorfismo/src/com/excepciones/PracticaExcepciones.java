package com.excepciones;

public class PracticaExcepciones {
    public static void main(String[] args) {
        int a = 0, b = 300;

        try {
            System.out.println(b / a);
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }

        try {
            System.out.println(b / a);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
