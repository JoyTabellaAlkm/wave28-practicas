
public class Main {
    public static void main(String[] args) {

        System.out.println("Serie de enteros");
        SerieInteger serieInteger = new SerieInteger(3);
        serieInteger.setInitialValue(1);
        System.out.println(serieInteger.nextValue());
        System.out.println(serieInteger.nextValue());
        System.out.println(serieInteger.nextValue());
        serieInteger.restart();
        System.out.println("Reinicio");
        System.out.println(serieInteger.nextValue());
        System.out.println(serieInteger.nextValue());
        System.out.println(serieInteger.nextValue());
        System.out.println(serieInteger.nextValue());

        System.out.println("\nSerie de doubles");
        SerieDouble serieDouble = new SerieDouble(5.2);
        serieDouble.setInitialValue(3.6);
        System.out.println(serieDouble.nextValue());
        System.out.println(serieDouble.nextValue());
        System.out.println(serieDouble.nextValue());
        System.out.println(serieDouble.nextValue());
        serieDouble.restart();
        System.out.println("Reinicio");
        System.out.println(serieDouble.nextValue());
        System.out.println(serieDouble.nextValue());


    }
}