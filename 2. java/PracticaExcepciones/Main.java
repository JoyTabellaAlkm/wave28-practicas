package PracticaExcepciones;

public class Main {
    public static void main(String[] args) {
        int a = 0, b = 300;
        try {
            System.out.println(b / a);
        } catch (Exception e) {
            // System.out.println("Se ha producido un error");
            throw new IllegalArgumentException("No se puede dividir por 0");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
