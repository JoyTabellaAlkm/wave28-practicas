package Implementations.Transacciones;

import Interfaces.ITransaccion;

public class PagoServicio implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Se realizo el pago del servicio.");
    }
}
