package Clases;

public class Main {
    public static void main(String[] args) {
        Cobrador cobrador = new Cobrador();
        Ejecutivo ejecutivo = new Ejecutivo();
        Basic basic =  new Basic();

        /*
         * Ejecutivos: Realizan Depósitos y Transferencias.
         * Basic: Realizan consultas de saldo, pagos de servicios y retiro de efectivo.
         * Cobradores: Realizan retiro de efectivo y consulta de saldos.
         */

         basic.RealizarConsulta();
         basic.RealizarPago();
         basic.RealizarRetiro();

         ejecutivo.RealizarDeposito();
         ejecutivo.RealizarTransferencia();

         cobrador.RealizarConsulta();
         cobrador.RealizarRetiro();
    }
}
