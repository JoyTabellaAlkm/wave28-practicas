package com.company;

public class Cobrador implements Transaccion{
    public Cobrador() {
    }

    @Override
    public void transaccionOk() {
        System.out.println("todo ok");
    }

    @Override
    public void transaccionesNoOk() {
        System.out.println("todo no ok");
    }

    public void consultaSaldo(){
        System.out.println("Consulta Saldo");
    }
    public void retiroEfectivo(){
        System.out.println("Retiro Efectivo");
    }
}
