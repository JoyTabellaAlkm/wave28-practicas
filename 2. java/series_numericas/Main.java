public class Main {
    public static void main(String[] args) {
        SerieIncremental serieInc = new SerieIncremental(1, 2);
        System.out.println(serieInc.valorSiguiente()); 
        System.out.println(serieInc.valorSiguiente());
        serieInc.reiniciar();
        System.out.println(serieInc.valorSiguiente());

        System.out.println("serie multiplicativa ------");
        SerieMultiplicativa serieMul = new SerieMultiplicativa(65, 3);
        System.out.println(serieMul.valorSiguiente()); 
        System.out.println(serieMul.valorSiguiente()); 
        serieMul.establecerValorInicial(2);
        serieMul.reiniciar();
        System.out.println(serieMul.valorSiguiente());
    }
}
