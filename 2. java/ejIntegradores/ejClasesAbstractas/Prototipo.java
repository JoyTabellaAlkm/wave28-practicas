package ejIntegradores.ejClasesAbstractas;

public abstract class Prototipo {

    protected int valorInicial;
    protected int valorActual;

    public Prototipo(int valorInicial, int valorActual) {
        this.valorInicial = valorInicial;
        this.valorActual = valorActual;
    }

    public abstract void obtenerSiguiente();

    public void setValorInicial(int i) {
        this.valorInicial = i;
        System.out.println("Se seteó el valor inicial a: " + i);
    }

    public void resetearSerie() {
        this.valorActual = valorInicial;
        System.out.println("Se reseteó la serie");
    }
}
