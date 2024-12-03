public class Main {
    public static void main(String[] args) {
        SerieInteger serieInt = new SerieInteger(0,2);
        for(int i = 0; i < 5; i++){
            System.out.println(serieInt.obtenerSiguienteValor());
        }

        SerieDouble serieDouble = new SerieDouble(1.0,4.5);
        for(int i = 0; i < 5; i++){
            System.out.println(serieDouble.obtenerSiguienteValor());
        }

    }
}
