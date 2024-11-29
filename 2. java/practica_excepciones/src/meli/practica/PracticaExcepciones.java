package practica_excepciones.src.meli.practica;

public class PracticaExcepciones {
    public static void main(String[] args) {

        int a = 0;
        int b = 300;

        try {
            if (a == 0)
                throw new IllegalArgumentException("No se puede dividir por 0.");

            double resultado = b / a;
            System.out.println("El resultado es: " + resultado);

        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}