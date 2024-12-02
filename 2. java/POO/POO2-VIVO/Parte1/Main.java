public class Main {
    public static void main(String[] args) {
        try {
            PracticaExcepciones exception = new PracticaExcepciones();
            exception.calcularCociente();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Programa finalizado!");
        }
    }
}
