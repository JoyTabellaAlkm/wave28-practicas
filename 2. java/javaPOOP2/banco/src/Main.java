import Transacciones.Basic;
import Transacciones.Cobrador;
import Transacciones.Ejecutivo;

public class Main {
    public static void main(String[] args) {

            Cobrador cobrador = new Cobrador();
            cobrador.consultarSaldo();
            cobrador.retirarEfectivo();

            Ejecutivo ejecutivo = new Ejecutivo();
            ejecutivo.hacerDeposito();
            ejecutivo.hacerTrasnferencia();

            Basic basico = new Basic();
            basico.consultarSaldo();
            basico.pagarServicios();
            basico.retirarEfectivo();
    }
}