package com.mercadolibre.transacciones;

public class RetiroEfectivo implements Transaccion {
    
    @Override
    public void transaccionOk() {
        System.out.println("El retiro en efectivo ha sido realizado correctamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("El retiro en efectivo no ha sido realizado correctamente.");
    }

}
