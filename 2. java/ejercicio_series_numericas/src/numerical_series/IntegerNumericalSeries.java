package numerical_series;

public class IntegerNumericalSeries extends NumericalSeries<Integer> {
    public IntegerNumericalSeries(Integer progress) {
        super(0, progress);
    }

    @Override
    public Integer nextValue() {
        currentValue = currentValue + progressValue;
        return currentValue;
    }
}
