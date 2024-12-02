package ej1;

public class Ejecutivo {
    public void depositar(int monto) {
        Transaccion t = new Deposito();
        t.transaccionOk();
    }

    public void transferir(int monto) {
        Transaccion t = new Transferencia();
        t.transaccionNoOk();
    }
}
