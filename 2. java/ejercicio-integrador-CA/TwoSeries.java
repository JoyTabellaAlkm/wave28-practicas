public class TwoSeries extends Prototipo {
    @Override
    public int getNextValue() {
        this.currentValue += 2;
        return this.currentValue;
    }
}
