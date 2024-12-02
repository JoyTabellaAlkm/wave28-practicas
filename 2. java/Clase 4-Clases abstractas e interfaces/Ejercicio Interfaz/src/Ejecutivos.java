public class Ejecutivos implements ICliente{

    @Override
    public void realizarTransaccion(ITransaccion transaccion){
        if(transaccion instanceof Transferencia || transaccion instanceof Deposito){
            transaccion.transaccionOk();
        } else {
            transaccion.transaccionNoOk();
        }
    }
}
