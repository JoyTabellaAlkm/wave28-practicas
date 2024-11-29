public class PracticaExcepciones {
    int a;
    int b = 300;
    int cociente;

    public PracticaExcepciones() {
        try {
            cociente = b/a;
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");
        } finally{
            System.out.println("Programa finalizado");
        }
    }

    public PracticaExcepciones(String mensaje){
        try {
            cociente = b/a;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally{
            System.out.println("Programa finalizado");
        }
    }
}
