package EjercicioClase2;

public class PracticaExcepciones {

    private int a=0 ;
    private int b =300;
    private int cociente;


    public static void main(String[] args) {

        PracticaExcepciones pe = new PracticaExcepciones();

        try {
            pe.cociente = pe.b / pe.a;
            System.out.println(pe.cociente);
        } //catch (Exception e) {
          //  System.out.println("Se ha producido un error");
        catch (IllegalArgumentException e) {
            System.out.println("No se puede dividir por cero:"
                     + e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
