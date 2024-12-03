package ej2;

public abstract class Prototipo {

    protected Number valor;

    public abstract Number siguiente();

    public abstract void reiniciar();

    public void setValorInicial(Number v) {
        valor = v;
    }

}
