public class SerieInteger extends Prototype<Integer>{

    public SerieInteger(Integer increment) {
        super(increment, 0);
    }

    @Override
    public Integer nextValue() {
        setValue(getValue() + getIncrement());
        return getValue();
    }

    @Override
    public void restart() {
        setValue(getInitialValue());
    }

}
