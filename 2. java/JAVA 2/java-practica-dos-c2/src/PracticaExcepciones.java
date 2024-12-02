public class PracticaExcepciones {

    private int a = 0;
    private int b = 300;

    public void calculoCociente() {
        try {
            if (a == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            double division = b / a;
        } catch (IllegalArgumentException exception ) {
            exception.printStackTrace();
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
