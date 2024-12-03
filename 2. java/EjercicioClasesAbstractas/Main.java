public class Main {
    public static void main(String[] args) {
        SerieIncremento serieIncremento = new SerieIncremento<Integer>(0, 2);
        System.out.println("\n ========Serie de aumento 2 con valor inicial 0========");
        for(int i = 0; i<4; i++){
            System.out.println(serieIncremento.siguiente());
        }

        System.out.println("\n ========Serie de aumento 2 con valor inicial 1========");
        serieIncremento.establecerValorInicial(1);

        for(int i = 0; i<4; i++){
            System.out.println(serieIncremento.siguiente());
        }

        System.out.println("\n ========Serie de aumento 3 con valor inicial 1========");

        serieIncremento.reiniciar();
        serieIncremento.setIncremento(3);
        for(int i = 0; i<4; i++){
            System.out.println(serieIncremento.siguiente());
        }

    }
}