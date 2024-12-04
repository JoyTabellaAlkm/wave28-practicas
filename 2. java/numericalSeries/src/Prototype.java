public abstract class Prototype <T extends Number>{

    private T value;
    private T initialValue;
    private T increment;

    public Prototype(T increment, T initialValue) {
        this.increment = increment;
        this.initialValue = initialValue;
        this.value = initialValue;
    }

    public T getIncrement() {
        return increment;
    }

    public void setIncrement(T increment) {
        this.increment = increment;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    public T getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(T initialValue) {
        this.initialValue = initialValue;
        value = initialValue;
    }

    protected abstract T nextValue();
    protected abstract void restart();



}
