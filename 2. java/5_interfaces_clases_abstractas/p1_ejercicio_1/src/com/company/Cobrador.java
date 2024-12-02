package com.company;

public class Cobrador implements IRetirar, IConsultarSaldo{


    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo...");
    }

    @Override
    public void retirar() {
        System.out.println("Retirando ....");
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
