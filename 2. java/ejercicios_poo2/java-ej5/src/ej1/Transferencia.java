package ej1;

public class Transferencia implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia realizada correctamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al realizar la Transferencia");
    }
}
