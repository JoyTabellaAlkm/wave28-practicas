package models;

import interfaces.ITransaccion;

public class RetiroEnEfectivo implements ITransaccion {

    public void retirarEnEfectivo(double valor) {
        System.out.println("Retirando en efectivo $" + valor);
        this.transaccionOk();
    }
}
