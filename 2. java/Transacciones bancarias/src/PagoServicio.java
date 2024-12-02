public class PagoServicio implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicio, transaccion OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago de servicio, transaccion No OK");
    }
}
