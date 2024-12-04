package ejercicio1Banco.clientes;

import ejercicio1Banco.transacciones.*;

public class Basic implements ICliente {
    @Override
    public void realizarTransaccion(ITransaccion transaccion){
        if (transaccion instanceof ConsultaSaldo || transaccion instanceof PagoServicio
                || transaccion instanceof RetiroEfectivo){
            transaccion.transaccionOK();
        }
        else
        {
            transaccion.transaccionNoOK();
        }
    }
}
