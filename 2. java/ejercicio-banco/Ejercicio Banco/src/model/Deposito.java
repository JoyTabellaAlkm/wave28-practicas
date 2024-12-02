package model;

public class Deposito implements Transacciones {

    @Override
    public void transaccionOk() {
        System.out.println("Realizando deposito ");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo realizar deposito ");

    }
}
