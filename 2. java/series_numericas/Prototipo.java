public abstract class Prototipo<T extends Number> {
    protected T valorInicial;
    protected T valorActual; 

    public Prototipo(T valorInicial) {
        this.valorInicial = valorInicial;
        this.valorActual = valorInicial;
    }
    protected abstract T valorSiguiente();
    protected void establecerValorInicial(T valor) {
        this.valorInicial = valor;
        this.valorActual = valor;
    }
    protected void reiniciar() {
        this.valorActual = valorInicial;
    }
}
