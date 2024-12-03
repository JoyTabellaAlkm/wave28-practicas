package Abstractas;

public abstract class Prototipo<T extends Number> {
    private T valor;

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public abstract T calcularSiguiente();

    public abstract void reiniciarValor();

    public abstract void establecerValorInicial(T valor);
}
