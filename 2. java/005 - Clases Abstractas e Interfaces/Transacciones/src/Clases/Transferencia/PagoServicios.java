package Clases.Transferencia;

import Interfaces.ITransaccion;

public class PagoServicios implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Se realiza el pago de servicios");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se realiza el pago de servicios");
    }
}
