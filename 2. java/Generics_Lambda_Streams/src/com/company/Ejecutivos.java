package com.company;

public class Ejecutivos implements Transaccion{
    public Ejecutivos() {
    }

    @Override
    public void transaccionOk() {
        System.out.println("todo ok");
    }

    @Override
    public void transaccionesNoOk() {
        System.out.println("todo no ok");
    }

    public void depositos(){
        System.out.println("Deposito");
    }
    public void transferencias(){
        System.out.println("Realiza transferencia");
    }

}
