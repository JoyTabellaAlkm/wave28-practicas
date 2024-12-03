public abstract class Prototipo <T extends Number>{
    protected int valorActual;
    protected int valorInicial;
    protected int valorIncremental;

    public Prototipo(int valorInicial, int valorIncremental) {
        this.valorActual = valorInicial;
        this.valorInicial = valorInicial;
        this.valorIncremental = valorIncremental;
    }

    public abstract T valorSiguiente();

    public void reiniciarSerie(){
        this.valorActual = valorInicial;
    }

    public void establecerValorinicial(int nuevoValorInicial){
        this.valorActual = nuevoValorInicial;
        this.valorInicial = nuevoValorInicial;
    }
}
