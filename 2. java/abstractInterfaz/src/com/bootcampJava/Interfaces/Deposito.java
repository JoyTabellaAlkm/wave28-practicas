package com.bootcampJava.Interfaces;

public class Deposito implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("El depósito fue exitoso");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al dopositar");
    }
}
