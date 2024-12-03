public abstract class Prototipo<T extends Number> {
    protected T valorInicial;
    protected T saltoValor;
    protected T valorActual;

    public Prototipo(T valorInicial, T saltoValor) {
        this.valorInicial = valorInicial;
        this.saltoValor = saltoValor;
        this.valorActual = valorInicial;
    }

    public void setValorInicial(T valorInicial) {
        this.valorInicial = valorInicial;
    }

    public abstract T obtenerSiguienteValor();

    public void reiniciar() {
        this.valorActual = this.valorInicial;
    }
}
