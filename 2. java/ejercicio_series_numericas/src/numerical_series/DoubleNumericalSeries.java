package numerical_series;

public class DoubleNumericalSeries extends NumericalSeries<Double> {
    public DoubleNumericalSeries(Double progress) {
        super(0.0, progress);
    }

    @Override
    public Double nextValue() {
        currentValue = currentValue + progressValue;
        return currentValue;
    }
}
