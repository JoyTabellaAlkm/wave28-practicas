package ClasesAbsInt;

public class BancoMain {
    public static void main(String[] args) {
        Transaccion deposito = new Deposito();
        Transaccion pagoServicios = new PagoServicios();
        Transaccion transferencia = new Transferencia();

        Cliente ejecutivo = new Ejecutivo("Ejecutivo");

        ejecutivo.realizarTransaccion(deposito);
        ejecutivo.realizarTransaccion(pagoServicios);
        ejecutivo.realizarTransaccion(transferencia);
    }
}
