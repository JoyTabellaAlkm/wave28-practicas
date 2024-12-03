public abstract class Prototipo {
    private int valorInicial = 0;
    private int valor = 0;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(int valorInicial) {
        this.valorInicial = valorInicial;

    }

    public void cambiarValorInicial(int valorInicial) {
        this.valorInicial = valorInicial;
        this.valor = valorInicial;
        System.out.println("Nuevo valor inicial: " + valorInicial);
    }

    public void reiniciar() {
        this.valor = valorInicial;
        System.out.println("Reinicio: " + valor);
    }

    abstract void siguenteValor();
}
