public class Main {
    public static void main(String[] args) {

        Prototipo serieIncrementalDos = new SerieCadaDos(2);

        System.out.println("***Serie con incremento en 2***");
        System.out.println("Valor actual: " + serieIncrementalDos.valorActual);
        System.out.println("Siguiente valor: " + serieIncrementalDos.valorSiguiente());
        System.out.println("Siguiente valor: " + serieIncrementalDos.valorSiguiente());
        System.out.println("Siguiente valor: " + serieIncrementalDos.valorSiguiente());

        serieIncrementalDos.establecerValorinicial(1);
        System.out.println("Reinicio de valor: " + serieIncrementalDos.valorActual);
        System.out.println("siguiente valor: " + serieIncrementalDos.valorSiguiente());
        System.out.println("Siguiente valor: " + serieIncrementalDos.valorSiguiente());
        System.out.println("Siguiente valor: " + serieIncrementalDos.valorSiguiente());


        Prototipo serieIncrementalTres = new SerieCadaTres(3);
        System.out.println("***Serie con incremento en 3***");
        System.out.println("Valor actual: " + serieIncrementalTres.valorActual);
        System.out.println("Siguiente valor: " + serieIncrementalTres.valorSiguiente());
        System.out.println("Siguiente valor: " + serieIncrementalTres.valorSiguiente());
        System.out.println("Siguiente valor: " + serieIncrementalTres.valorSiguiente());

        serieIncrementalDos.establecerValorinicial(1);
        System.out.println("Reinicio de valor: " + serieIncrementalTres.valorActual);
        System.out.println("siguiente valor: " + serieIncrementalTres.valorSiguiente());
        System.out.println("Siguiente valor: " + serieIncrementalTres.valorSiguiente());
        System.out.println("Siguiente valor: " + serieIncrementalTres.valorSiguiente());

    }
}