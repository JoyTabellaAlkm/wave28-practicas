public class ExcepcionesV1 {
    public static void main(String[] args) {
        /*Crear una clase PracticaExcepciones que defina los atributos a = 0 y b = 300
        de tipo int.Calcular el cociente de b/a.Controlar la excepción que se lanza
        indicando el mensaje “Se ha producido un error”.Al final del programa siempre
        deberá indicar el mensaje “Programa finalizado”*/

        try {
            int a = 0, b = 300;
            int resultado = b / a;
        } catch(ArithmeticException e) {
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
