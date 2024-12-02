import transacciones.*;

public class Basic implements  ICliente{
    @Override
    public void realizarTransaccion(ITransaccion transaccion) {
        if(transaccion instanceof Consulta ||transaccion instanceof PagoServicios||transaccion instanceof Retiro){
            transaccion.transaccionOk();
        }else {
            transaccion.transaccionNoOk();
        }
    }
}
