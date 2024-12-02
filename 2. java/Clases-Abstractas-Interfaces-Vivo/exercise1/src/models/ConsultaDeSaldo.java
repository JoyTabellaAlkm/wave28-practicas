package models;

import interfaces.ITransaccion;

public class ConsultaDeSaldo implements ITransaccion {

    public void consultarSaldo() {
        System.out.println("Consultando saldo");
        this.transaccionOk();
    }
}
