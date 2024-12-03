package meli.practicas;

public class Ejecutivo implements ITransacciones {

    public void deposito(){
        System.out.println("Ejecutivo depósito");
        transaccionOK();
    }

    public void transferencia(){
        System.out.println("Ejecutivo transferencia");
        transaccionNoOk();

    }
}