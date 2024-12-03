public class Main {
    public static void main(String[] args) {
        SerieDeUno serieDeUno = new SerieDeUno(1);
        SerieDeDos serieDeDos = new SerieDeDos(0);
        SerieDeTres serieDeTres = new SerieDeTres(3);

        System.out.println("Siguiente valor serie de uno: " + serieDeUno.devolverSiguienteValor());
        System.out.println("Reinicio serie");
        serieDeUno.reiniciarSerie();
        System.out.println("Siguiente valor serie uno: " + serieDeUno.devolverSiguienteValor());
        System.out.println("Seteo nuevo valor inicial en 8");
        serieDeUno.setValorInicial(8);


        System.out.println("Siguiente valor serie de dos: " + serieDeDos.devolverSiguienteValor());
        System.out.println("Reinicio serie");
        serieDeDos.reiniciarSerie();
        System.out.println("Siguiente valor serie dos: " + serieDeDos.devolverSiguienteValor());
        System.out.println("Seteo nuevo valor inicial en 8");
        serieDeDos.setValorInicial(8);


        System.out.println("Siguiente valor serie de tres: " + serieDeTres.devolverSiguienteValor());
        System.out.println("Reinicio serie");
        serieDeTres.reiniciarSerie();
        System.out.println("Siguiente valor serie tres: " + serieDeTres.devolverSiguienteValor());
        System.out.println("Seteo nuevo valor inicial en 8");
        serieDeTres.setValorInicial(8);
    }
}