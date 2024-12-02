package model;

public class PagoServicio implements Transacciones {
    @Override
    public void transaccionOk() {
        System.out.println("Realizando pago servicio");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se puedo realizar pago servicio");

    }
}