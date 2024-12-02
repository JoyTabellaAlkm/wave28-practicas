package ejercicio1.clases;

import ejercicio1.interfaces.ITransaccion;

public class PagoDeServicios implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("El pago del servicio fue exitoso");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("El pago del servicio no fue exitoso");
    }

}
