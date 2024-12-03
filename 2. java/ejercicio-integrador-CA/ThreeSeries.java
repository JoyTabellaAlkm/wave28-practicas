public class ThreeSeries extends Prototipo {

    @Override
    public int getNextValue() {
        this.currentValue += 3;
        return this.currentValue;
    }
}
