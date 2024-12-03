public abstract class Prototipo {
    protected Integer valorInicial;
    protected Integer valorActual;

    public  Prototipo(Integer valorInicial){
        this.valorInicial = valorInicial;
        this.valorActual = valorInicial;
    }

    public abstract Integer devolverSiguienteValor();

    public void reiniciarSerie() {
        this.valorActual = this.valorInicial;
    }

    public void setValorInicial(Integer valorInicial){
        this.valorInicial = valorInicial;
    }

}
