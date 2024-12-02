import transacciones.Deposito;
import transacciones.ITransaccion;
import transacciones.Transferencia;

public class Ejecutivo implements  ICliente{
    @Override
    public void realizarTransaccion(ITransaccion transaccion) {
        if(transaccion instanceof Deposito||transaccion instanceof Transferencia){
            transaccion.transaccionOk();
        }else {
            transaccion.transaccionNoOk();
        }
    }
}
