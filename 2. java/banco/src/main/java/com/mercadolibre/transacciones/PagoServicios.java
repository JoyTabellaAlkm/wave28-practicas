package com.mercadolibre.transacciones;

public class PagoServicios implements Transaccion {

    @Override
    public void transaccionOk() {
        System.out.println("El pago de los servicios ha sido realizado correctamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("El pago de los servicios no ha sido realizado correctamente.");
    }

}
