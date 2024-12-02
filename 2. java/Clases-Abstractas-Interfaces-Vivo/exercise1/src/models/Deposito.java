package models;

import interfaces.ITransaccion;

public class Deposito implements ITransaccion {

    public void depositar(double valor) {
        System.out.println("Realizandose deposito de $" + valor);
        this.transaccionOk();
    }
}
