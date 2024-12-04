package ejercicio1Banco.clientes;

import ejercicio1Banco.transacciones.*;

public class Cobrador implements ICliente{
    @Override
    public void realizarTransaccion(ITransaccion transaccion){
        if (transaccion instanceof RetiroEfectivo || transaccion instanceof ConsultaSaldo){
            transaccion.transaccionOK();
        }
        else
        {
            transaccion.transaccionNoOK();
        }
    }
}
