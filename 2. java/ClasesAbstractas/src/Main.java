public class Main {
    public static void main(String[] args) {

        SerieIncrementoFijo serie2 = new SerieIncrementoFijo(0,2);
        System.out.println("Serie de incremento fijo de 2: ");
        System.out.println(serie2.siguienteValor());
        System.out.println(serie2.siguienteValor());
        System.out.println(serie2.siguienteValor());

        serie2.reiniciar(1);

        System.out.println("Serie reiniciada con valor inicial 1:");
        System.out.println(serie2.siguienteValor());
        System.out.println(serie2.siguienteValor());
        System.out.println(serie2.siguienteValor());

        SerieMultiplicativa serie3 = new SerieMultiplicativa(1,3);
        System.out.println("Serie Multiplicativa con factor 3:");
        System.out.println(serie3.siguienteValor());
        System.out.println(serie3.siguienteValor());
        System.out.println(serie3.siguienteValor());

        serie3.reiniciar(2);
        System.out.println("Serie reiniciada con valor inicial 2:");
        System.out.println(serie3.siguienteValor());
        System.out.println(serie3.siguienteValor());
    }
}