
import ejIntegradores.ejClasesAbstractas.DosEnDos;

public class Main {

    public static void main(String[] args) {

        DosEnDos serieDosEnDos = new DosEnDos(0,0);
        serieDosEnDos.obtenerSiguiente();
        serieDosEnDos.obtenerSiguiente();
        serieDosEnDos.obtenerSiguiente();
        serieDosEnDos.setValorInicial(3);
        serieDosEnDos.resetearSerie();
        serieDosEnDos.obtenerSiguiente();
        serieDosEnDos.obtenerSiguiente();
        serieDosEnDos.obtenerSiguiente();
    }
}