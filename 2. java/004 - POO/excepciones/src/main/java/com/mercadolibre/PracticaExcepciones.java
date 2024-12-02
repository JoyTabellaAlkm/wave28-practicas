package com.mercadolibre;

public class PracticaExcepciones {

    private int a = 0;
    private int b = 300;

    public void calcularCociente1() {
        try {
            double cociente = b / a;
            System.out.println("El cociente es: " + cociente);
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error.");
        } finally {
            System.out.println("Programa finalizado.");
        }
    }

    public void calcularCociente2() {
        try {
            double cociente = b / a;
            System.out.println("El cociente es: " + cociente);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por cero.");
        } finally {
            System.out.println("Programa finalizado.");
        }
    }

}
