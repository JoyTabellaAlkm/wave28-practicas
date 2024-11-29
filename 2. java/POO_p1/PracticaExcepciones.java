package com.company;

public class PracticaExcepciones {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        try {
            if (a == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            System.out.println(b/a);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
