package ej1;

public class Deposito implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Deposito realizado correctamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se ha podido realizar el deposito");
    }
}
