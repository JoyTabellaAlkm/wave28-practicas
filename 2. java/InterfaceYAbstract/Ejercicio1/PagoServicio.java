public class PagoServicio implements Transaccion {

    @Override
    public void transaccionOk() {
        System.out.println("El pago de servicio se realizo exitosamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Hubo un error al realizar el pago de servicio");
    }
}
