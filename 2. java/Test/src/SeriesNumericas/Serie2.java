package SeriesNumericas;

public class Serie2 extends Prototipo{

    public Serie2() {
        reiniciar();
    }

    @Override
    public Number siguiente() {
        number = number.doubleValue() + 2;
        return number;
    }

    @Override
    public Number reiniciar() {
        number = 0;
        return number;
    }
}
