package ejercicio1Banco.transacciones;

public class PagoServicio implements ITransaccion{
    @Override
    public void transaccionOK(){
        System.out.println("Transaccion pago de servicio realizada");
    }
    @Override
    public void transaccionNoOK()
    {
        System.out.println("Transaccion pago de servicio no realizada");
    }
}
