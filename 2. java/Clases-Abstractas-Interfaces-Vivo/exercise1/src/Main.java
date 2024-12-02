import models.Basic;
import models.Cobrador;
import models.Ejecutivo;

public class Main {
    public static void main(String[] args) {

        Basic basic = new Basic();
        basic.consultarSaldo();
        basic.retirarEfectivo(1300);
        basic.pagarServicio("Luz");

        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.transferir(2000);
        ejecutivo.depositar(3000);

        Cobrador cobrador = new Cobrador();
        cobrador.consultarSaldo();
        cobrador.retirarEnEfectivo(1000);
    }
}