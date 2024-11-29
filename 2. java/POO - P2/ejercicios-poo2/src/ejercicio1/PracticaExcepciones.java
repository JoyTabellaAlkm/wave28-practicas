package ejercicio1;

public class PracticaExcepciones {

    static int a = 0, b = 300;

    public static void main(String[] args) {
        try {
            int cociente = b / a;
        }catch (Exception e) {
            System.out.println("Se ha producido un error");
        }finally {
            System.out.println("Programa finalizado");
        }

        try {
            int cociente = b / a;
        }catch (Exception e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }

    }
}
