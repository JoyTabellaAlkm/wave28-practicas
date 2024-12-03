public class Main {
    public static void main(String[] args) {

        Prototipo two = new TwoSeries();
        two.setStartingValue(0);
        System.out.println(two.getNextValue());
        System.out.println(two.getNextValue());
        two.restartSeries();
        System.out.println(two.getNextValue());


        Prototipo three = new ThreeSeries();
        three.setStartingValue(0);
        System.out.println(three.getNextValue());
        System.out.println(three.getNextValue());
        three.restartSeries();
        System.out.println(three.getNextValue());

    }
}