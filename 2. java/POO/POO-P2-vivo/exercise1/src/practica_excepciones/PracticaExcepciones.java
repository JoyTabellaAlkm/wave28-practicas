package practica_excepciones;

public class PracticaExcepciones {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        /** First part */
        /*
        try{
            double cociente = b/a;
        }
        catch (ArithmeticException exception) {
            System.out.println("Se ha producido un error");
        }
        finally {
            System.out.println("Programa finalizado");
        }
        */

        try{
            double cociente = b/a;
        }
        catch (ArithmeticException exception) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        finally {
            System.out.println("Programa finalizado");
        }
    }
}
