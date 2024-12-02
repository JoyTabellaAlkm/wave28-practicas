public class PracticaExcepciones {

    private int a = 0;
    private int b = 300;

    public double dividir() {
        // 1.
        try {
            return a/b;
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }
        return 0;
    }

    public double dividir2() {
        // 2.
        try {
            return a/b;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    public static void main(String[] args) {
        PracticaExcepciones practica = new PracticaExcepciones();
        practica.dividir();
        practica.dividir2();
    }
}
