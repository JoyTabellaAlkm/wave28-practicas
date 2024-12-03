import Abstractas.Serie2;
import Abstractas.Serie3;

public class Main {
    public static void main(String[] args) {
        Serie2 serie2 = new Serie2();
        Serie3 serie3 = new Serie3();

        System.out.println();
        System.out.println("PRINT SERIE 2");
        serie2.establecerValorInicial(1);
        System.out.println(serie2.calcularSiguiente());
        System.out.println(serie2.calcularSiguiente());
        System.out.println(serie2.calcularSiguiente());
        serie2.reiniciarValor();
        System.out.println(serie2.getValor());

        System.out.println();
        System.out.println("PRINT SERIE 3");
        serie3.establecerValorInicial(0);
        System.out.println(serie3.calcularSiguiente());
        System.out.println(serie3.calcularSiguiente());
        System.out.println(serie3.calcularSiguiente());
        serie3.reiniciarValor();
        System.out.println(serie3.getValor());
    }
}