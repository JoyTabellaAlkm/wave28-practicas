public interface IPagoDeServicios extends ITransaccion{
    @Override
    default void transaccionOk() {
        ITransaccion.super.transaccionOk();
        System.out.println("Pagando servicio");
    }

    @Override
    default void transaccionNoOk() {
        ITransaccion.super.transaccionNoOk();
    }

}
