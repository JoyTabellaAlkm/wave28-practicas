import clients.Basic;
import clients.Cobradores;
import clients.Ejecutivos;

public class Main {
    public static void main(String[] args) {
        Basic cliente1 = new Basic();
        cliente1.consultarSaldo();

        Cobradores cliente2 = new Cobradores();
        cliente2.retirar();

        Ejecutivos cliente3 = new Ejecutivos();
        cliente3.enviarDinero();
    }
}
