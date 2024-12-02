package com.bootcampJava.Interfaces;

public class Transferencia implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia exitosa");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al transferir");
    }
}
