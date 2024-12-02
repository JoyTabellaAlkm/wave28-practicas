public class Main {
    public static void main(String[] args) {
        PracticaExcepciones practica = new PracticaExcepciones();

        // region caso 1
        try {
            System.out.println(practica.cociente());
        }
        catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");
        }
        finally {
            System.out.println("Programa finalizado");

        }

        //endregion

        // region caso 2
        try {
            System.out.println(practica.cociente());
        }
        catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        //endregion


    }
}