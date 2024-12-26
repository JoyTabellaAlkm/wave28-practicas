//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class PracticaExcepciones {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        try {
            if (a == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero.");
            }

            int resultado = b / a;
            System.out.println("El resultado es: " + resultado);
        } catch (IllegalArgumentException e) {
            System.out.println("El error es: " + e.getMessage());
        } finally {
            System.out.println("Mensaje finalizado");
        }

    }
}
