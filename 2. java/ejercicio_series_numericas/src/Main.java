import numerical_series.DoubleNumericalSeries;
import numerical_series.IntegerNumericalSeries;
import numerical_series.NumericalSeries;

public class Main {
    public static void main(String[] args) {
        NumericalSeries<Integer> integerSeries = new IntegerNumericalSeries(2);
        System.out.println(integerSeries.nextValue());
        System.out.println(integerSeries.nextValue());
        System.out.println(integerSeries.nextValue());
        System.out.println(integerSeries.nextValue());
        integerSeries.resetSeries();
        System.out.println(integerSeries.nextValue());
        integerSeries.setInitialValue(1);
        System.out.println(integerSeries.nextValue());
        System.out.println(integerSeries.nextValue());

        NumericalSeries<Double> doubleNumericalSeries = new DoubleNumericalSeries(2.0);
        System.out.println(doubleNumericalSeries.nextValue());
        System.out.println(doubleNumericalSeries.nextValue());
        System.out.println(doubleNumericalSeries.nextValue());
        System.out.println(doubleNumericalSeries.nextValue());
        doubleNumericalSeries.resetSeries();
        System.out.println(doubleNumericalSeries.nextValue());
        doubleNumericalSeries.setInitialValue(1.0);
        System.out.println(doubleNumericalSeries.nextValue());
        System.out.println(doubleNumericalSeries.nextValue());
    }
}