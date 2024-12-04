public abstract class Prototipo {

    private int valor;
    private int valorInicial;

    public Prototipo(int valor) {
        this.valor = valor;
        this.valorInicial = valor;
    }

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

    public abstract int valorSiguiente();

    public void reiniciarValor() {
        setValor(getValorInicial());
    }
    public void valorInicial(int n){
        setValor(n);
        setValorInicial(n);
    }
}
