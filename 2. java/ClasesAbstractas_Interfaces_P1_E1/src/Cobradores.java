import transacciones.*;

public class Cobradores implements  ICliente{
    @Override
    public void realizarTransaccion(ITransaccion transaccion) {
        if(transaccion instanceof Consulta ||transaccion instanceof Retiro){
            transaccion.transaccionOk();
        }else {
            transaccion.transaccionNoOk();
        }
    }
}
