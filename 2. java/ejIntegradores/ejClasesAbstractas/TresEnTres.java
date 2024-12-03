package ejIntegradores.ejClasesAbstractas;

public class TresEnTres extends Prototipo {

    public TresEnTres(int valorInicial, int valorActual) {
        super(valorInicial, valorActual);
    }

    @Override
    public void obtenerSiguiente() {
        this.valorActual += 3;
        System.out.println("Valor actual: " + this.valorActual);
    }
}
