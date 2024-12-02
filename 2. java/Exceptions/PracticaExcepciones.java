public class PracticaExcepciones {
    int a = 0;
    int b = 300;

    public double dividirAB (){
        double result = 0;
        try {
            result = b/a;
        } catch (Exception e) {
            //System.out.println("Se ha producido un error");
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
        return result;
    }

}
