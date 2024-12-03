public abstract class Prototipo {

    protected int currentValue;

    public void setStartingValue(int value) {
        this.currentValue = value;
    }

    public void restartSeries() {
        this.currentValue = 0;
    }

    public abstract int getNextValue();
}
