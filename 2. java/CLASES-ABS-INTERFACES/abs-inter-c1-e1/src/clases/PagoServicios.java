package clases;

import interfaces.ITransaccion;

public class PagoServicios implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Pago servicios");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Fallo al pagar servicios");
    }
}
