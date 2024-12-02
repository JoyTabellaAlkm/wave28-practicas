public class Cobrador implements ICliente{

    @Override
    public void realizarTransaccion(ITransaccion transaccion){
        if(transaccion instanceof ConsultaDeSaldo || transaccion instanceof RetiroDeEfectivo){
            transaccion.transaccionOk();
        } else {
            transaccion.transaccionNoOk();
        }
    }
}
