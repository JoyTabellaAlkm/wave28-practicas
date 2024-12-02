package models;

import interfaces.ITransaccion;

public class PagoDeServicios implements ITransaccion {

    public void pagarServicio(String nombreServicio) {
        System.out.println("Pagando servicio: " + nombreServicio);
        this.transaccionOk();
    }
}
