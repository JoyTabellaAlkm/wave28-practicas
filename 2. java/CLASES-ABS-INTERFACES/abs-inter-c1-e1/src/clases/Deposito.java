package clases;

import interfaces.ITransaccion;

public class Deposito implements ITransaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Hago un deposito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Fallo al hacer un deposito");
    }
}
