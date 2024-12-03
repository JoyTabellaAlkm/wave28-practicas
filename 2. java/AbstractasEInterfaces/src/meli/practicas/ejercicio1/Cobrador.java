package meli.practicas;

public class Cobrador implements ITransacciones {
    public Cobrador() {
    }

    public void retiroEfectivo(){
        System.out.println("Retirando efectivo.");
        transaccionOK();
    }
    public void consultaDeSaldo(){
        System.out.println("Saldo consultado");
        transaccionNoOk();
    }
}