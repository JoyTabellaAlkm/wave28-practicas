package com.bootcampJava.Interfaces;

public class PagoServicios implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicio exitoso");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al pagar el servicio");
    }
}
