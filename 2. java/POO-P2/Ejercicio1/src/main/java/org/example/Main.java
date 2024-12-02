package org.example;

public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        //1
//        try {
//            int resultado = b / a;
//            System.out.println("El resultado es: " + resultado);
//        } catch (Exception e) {
//            // Capturar y manejar la excepción personalizada
//            System.out.println("Se ha producido un error" + e.getMessage());
//        } finally {
//            // Mensaje final siempre se ejecuta
//            System.out.println("Programa finalizado");
//        }

        //2
        try {
            int resultado = b / a;
            System.out.println("El resultado es: " + resultado);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            // Mensaje final siempre se ejecuta
            System.out.println("Programa finalizado");
        }
    }
}