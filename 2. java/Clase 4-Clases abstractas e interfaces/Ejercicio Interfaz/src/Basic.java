public class Basic implements ICliente{
    @Override
    public void realizarTransaccion(ITransaccion transaccion){
        if(transaccion instanceof ConsultaDeSaldo || transaccion instanceof PagoServicios || transaccion instanceof RetiroDeEfectivo){
            transaccion.transaccionOk();
        } else {
            transaccion.transaccionNoOk();
        }
    }
}