public class SerieDouble extends Prototype<Double>{

    public SerieDouble(Double increment) {
        super(increment, 0.0);
    }

    @Override
    public Double nextValue() {
        setValue(getValue() + getIncrement());
        return getValue();
    }

    @Override
    public void restart() {
        setValue(getInitialValue());
    }
}
