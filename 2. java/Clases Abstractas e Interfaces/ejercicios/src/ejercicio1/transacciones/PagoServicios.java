package ejercicio1.transacciones;

import ejercicio1.interfaces.ITransaccion;

public class PagoServicios implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicios realizado satisfactoriamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al pagar los servicios");
    }
}
