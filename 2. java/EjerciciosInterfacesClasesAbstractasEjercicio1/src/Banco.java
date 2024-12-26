public class Banco {
    public static void main(String[] args) {

        //Ejecutivo
        Ejecutivo ejecutivo = new Ejecutivo();
        System.out.println("Operaciones Ejecutivo");
        ejecutivo.realizaDeposito();
        ejecutivo.realizarTransferencia();

        // Cliente Basic
        Basic basic = new Basic();
        System.out.println("Operaciones Cliente Basic");
        basic.consultarSaldo();
        basic.pagarServicios();
        basic.retirarEfectivo();

        //Cobrador
        Cobrador cobrador = new Cobrador();
        System.out.println("Operaciones Cobrador");
        cobrador.consultarSaldo();
        cobrador.retirarEfectivo();
        cobrador.consultarSaldo();
    }
}