package SeriesNumericas;

public class Serie3 extends Prototipo{

    public Serie3() {
        reiniciar();
    }

    @Override
    public Number siguiente() {
        number = number.doubleValue() + 3;
        return number;
    }

    @Override
    public Number reiniciar() {
        number = 0;
        return number;
    }
}
