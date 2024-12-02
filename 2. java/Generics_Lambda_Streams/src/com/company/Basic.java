package com.company;

public class Basic implements Transaccion{
    public Basic() {
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
    public void pagoServicio(){
        System.out.println("Pago Servicio");
    }
    public void retiroEfectivo(){
        System.out.println("Retiro Efectivo");
    }
}
