public abstract class Prototipo<T extends Number> {
    protected T valorInicial;
    protected T valorActual;

    public abstract T siguiente();

    public void reiniciar(){
        valorActual = valorInicial;
    }

    public void establecerValorInicial( T valorInicial){
        this.valorInicial = valorInicial;
        this.valorActual = valorInicial;
    }
    
}