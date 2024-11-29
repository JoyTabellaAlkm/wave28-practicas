package poo.p2.ejercicios_asincronicos;

public class ManejoCorrespondienteException {

    public static void main(String[] args) {

        //Mensaje final
        String mensajeFinal = "Este es el último mensaje";

        //Código que arroja excepción
        try {
            int[] numeros = new int[5];
            numeros[5] = 10;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(mensajeFinal);
        }

    }

}
