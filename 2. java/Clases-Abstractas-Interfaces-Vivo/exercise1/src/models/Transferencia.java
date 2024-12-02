package models;

import interfaces.ITransaccion;

public class Transferencia implements ITransaccion {

    public void transferir(double valor) {
        System.out.println("Transfiriendo $" + valor);
        this.transaccionOk();
    }
}
