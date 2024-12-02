package clases;

import interfaces.ITransaccion;

public class Transferencia implements ITransaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Hago una transferencia");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Fallo al hacer una transferencia");

    }
}
