package clases;

public class Ejecutivo {
    Deposito deposito = new Deposito();
    Transferencia transferencia = new Transferencia();

    public void depositar(double monto) {
        if (monto > 0) {
            this.deposito.transaccionOk();
        } else {
            this.deposito.transaccionNoOk();
        }
    }

    public void transferir(double monto) {
        if (monto > 0) {
            this.transferencia.transaccionOk();
        } else {
            this.transferencia.transaccionNoOk();
        }
    }
}
