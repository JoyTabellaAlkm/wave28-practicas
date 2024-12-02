package com.company;

public class Ejecutivo implements IDepositar, ITransferir {


    @Override
    public void depositar() {
        System.out.println("Realizando el deposito...");
    }

    @Override
    public void transferir() {
        System.out.println("Realizando transferencia");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transacción OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transacción NO OK");
    }

}
