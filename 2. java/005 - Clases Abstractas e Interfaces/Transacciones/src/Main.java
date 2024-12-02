import Clases.Cliente.Basic;
import Clases.Cliente.Cliente;
import Clases.Cliente.Cobrador;
import Clases.Cliente.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        Basic basic = new Basic("Basic");
        Ejecutivo ejecutivo = new Ejecutivo("Cliente");
        Cobrador cobrador = new Cobrador("Cobrador");
        basic.realizarTransaccion();
        ejecutivo.realizarTransaccion();
        cobrador.realizarTransaccion();
    }
}
