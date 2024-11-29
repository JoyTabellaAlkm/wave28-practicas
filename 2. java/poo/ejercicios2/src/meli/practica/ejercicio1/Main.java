package meli.practica.ejercicio1;

public class Main {
    public static void main(String[] args) {
        /*Ejercicio 1*/
        PracticasExcepciones practicasExcepciones = new PracticasExcepciones(300, 0);

        try {
            practicasExcepciones.calcularCociente();
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por 0.");
        } finally {
            System.out.println("Programa finalizado");
        }


        /*Ejercicio 2*/




    }
}