package numerical_series;

public abstract class NumericalSeries<T extends Number> {
    protected T initialValue;
    protected T progressValue;
    protected T currentValue;

    public NumericalSeries(T initialValue, T progressValue) {
        this.initialValue = initialValue;
        this.progressValue = progressValue;
        this.currentValue = initialValue;
    }

    public void setInitialValue(T initialValue) {
        this.initialValue = initialValue;
        this.currentValue = initialValue;
    }

    public void resetSeries() {
        currentValue = initialValue;
    }

    abstract public T nextValue();
}
