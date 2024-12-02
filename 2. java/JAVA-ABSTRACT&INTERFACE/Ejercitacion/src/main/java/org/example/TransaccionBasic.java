package org.example;

public class TransaccionBasic implements Transaccion {
    @Override
    public boolean transaccionOk() {
        return true;
    }

    @Override
    public boolean transaccionNoOk() {
        return false;
    }


    public void consultaSaldo(){
        System.out.println("Consulta saldo");
    }
    public void pagoServicios(){
        System.out.println("Pago servicios");
    }
    public void retiroEfectivo(){
        System.out.println("Retiro efectivo");
    }
}
