public class Main {
    public static void main(String[] args) {
        PracticaExcepciones practica = new PracticaExcepciones();
        try {
            practica.calcularCociente();
        } catch (Exception e) {
            System.out.println("Se ha producido un error.");
        } finally {
            System.out.println("Programa finalizado.");
        }

        try{
            practica.calcularCociente();
        }
        catch (Exception e) {
            throw new IllegalArgumentException("No se puede dividir por cero.");
        }

    }
}
