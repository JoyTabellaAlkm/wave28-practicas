package ej1;

public class PagoServicio implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Pago realizado correctamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al efectuar el pago");
    }
}
