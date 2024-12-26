public class PagoServicios implements ITransaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Realizando pago de servicios: Transaccion exitosa.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago de servicios fallido: Transaccion no realizada.");
    }
}
