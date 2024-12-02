package Implementations.Transacciones;

import Interfaces.ITransaccion;

public class RetiroEfectivo implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Se realizo el retiro de efectivo.");
    }
}
