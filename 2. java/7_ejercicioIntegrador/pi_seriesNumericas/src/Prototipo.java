public abstract class Prototipo<T extends Number> {

    protected T valorInicial;
    protected T incremento;
    protected T valorAcumulado;

    public Prototipo(T valorInicial, T incremento) {
        this.valorInicial = valorInicial;
        this.incremento = incremento;
    }

    public abstract T siguienteValor();

    public void reiniciarValor(){
        this.valorAcumulado = this.valorInicial;
    }
    public void definirValor(T valor){
        this.valorInicial = valor;
        this.incremento = valor;
    }
}
