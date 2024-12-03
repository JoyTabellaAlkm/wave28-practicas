package ej2;

public class Serie2 extends Prototipo {

    public Serie2() {
        reiniciar();
    }

    @Override
    public Number siguiente() {
        this.valor = valor.doubleValue() + 2;
        return this.valor;
    }

    @Override
    public void reiniciar() {
        this.valor = 0;
    }

}
