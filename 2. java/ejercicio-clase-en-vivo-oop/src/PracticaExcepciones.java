public class PracticaExcepciones {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;
        try {
            int cociente = b / a;
        }
        catch (ArithmeticException e) {
            // Ejercicio 1.1
            //System.out.println("Se ha producido un error");
            // Ejercicio 1.2
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }


}
