public class PagoServicios implements ITransaccion{
    @Override
    public void transaccionOk(){
        System.out.println("Pago realizado");
    };

    @Override
    public void transaccionNoOk(){
        System.out.println("Pago denegado");
    };
}
