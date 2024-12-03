package SeriesNumericas;

public abstract class Prototipo {

    protected Number number;

    public abstract Number siguiente();

    public abstract Number reiniciar();

    public void setValorInicial(Number number) {
        this.number = number;
    }
}
