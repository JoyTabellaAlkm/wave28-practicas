package meli.practicas;

public class Basic implements ITransacciones {

    public void realizaConsultaSaldo(){
        System.out.println("consultar saldo");
        transaccionNoOk();
    }

    public void pagoServicios(){
        System.out.println("pago de servicios");
        transaccionNoOk();
    }

    public void retiroEfectivo() {
        System.out.println("Retirar efectivo");
        transaccionOK();
    }
}