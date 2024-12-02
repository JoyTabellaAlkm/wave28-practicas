package com.mercadolibre.transacciones;

public class ConsultaSaldo implements Transaccion {

    @Override
    public void transaccionOk() {
        System.out.println("La consulta del saldo ha sido realizada correctamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La consulta del saldo no ha sido realizada correctamente.");
    }

}
