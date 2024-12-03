package ejIntegradores.ejClasesAbstractas;

public class DosEnDos extends Prototipo{

    public DosEnDos(int valorInicial, int valorActual) {
        super(valorInicial, valorActual);
    }

    @Override
    public void obtenerSiguiente() {
        this.valorActual += 2;
        System.out.println("Valor actual: " + this.valorActual);
    }
}
