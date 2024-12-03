package ej2;

public class Serie3 extends Prototipo{

    public Serie3() {
        reiniciar();
    }

    @Override
    public Number siguiente() {
        this.valor = valor.doubleValue() + 3;
        return this.valor;
    }

    @Override
    public void reiniciar() {
        this.valor = 0;
    }

}
