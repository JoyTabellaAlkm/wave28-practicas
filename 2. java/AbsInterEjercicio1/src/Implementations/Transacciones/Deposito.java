package Implementations.Transacciones;

import Interfaces.ITransaccion;

public class Deposito implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Se realizo el deposito.");
    }
}
