public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public void calcularCociente() {
        try {

            if (a == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }

            int cociente = b / a;
            System.out.println("El cociente es: " + cociente);
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error: ");
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    public static void main(String[] args) {
        PracticaExcepciones practica = new PracticaExcepciones();
        practica.calcularCociente();
    }
}
