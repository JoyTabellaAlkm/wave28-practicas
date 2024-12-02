package com.bootcampJava.Interfaces;

public class RetiroEfectivo implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Retiro de efectivo exitoso");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al retirar dinero");
    }
}
