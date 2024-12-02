public class PracticaExcepciones {
    int a=0;
    int b=300;

    public void calcularCociente() {
        try {
            float resultadoCociente = b / a;
        } catch (ArithmeticException s) {
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
