package com.company;

public class Basic implements IConsultarSaldo, IPagoServicio, IRetirar {

    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo...");
    }

    @Override
    public void pagarServicio() {
        System.out.println("Realizando pago...");
    }

    @Override
    public void retirar() {
        System.out.println("Realizando retiro...");
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
