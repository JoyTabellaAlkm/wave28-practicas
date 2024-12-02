public class ExcepcionesV2 {
    /*Modificar el programa anterior para que, al producirse el error, en vez de imprimir
        por consola el mensaje “Se ha producido un error”, lo lance como una excepción de tipo
        IllegalArgumentException con el mensaje “No se puede dividir por cero”*/
    public static void main(String[] args) {
        try {
            int a = 0, b = 300;
            int resultado = b / a;
        } catch(ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
