package Implementations.Transacciones;

import Interfaces.ITransaccion;

public class Transferencia implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Se realizo la transferencia");
    }
}
