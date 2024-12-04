package ejercicio1Banco.clientes;

import ejercicio1Banco.transacciones.Deposito;
import ejercicio1Banco.transacciones.ITransaccion;
import ejercicio1Banco.transacciones.Transferencia;

public class Ejecutivo implements ICliente{
    @Override
    public void realizarTransaccion(ITransaccion transaccion){
        if (transaccion instanceof Deposito || transaccion instanceof Transferencia){
            transaccion.transaccionOK();
        }
        else
        {
            transaccion.transaccionNoOK();
        }
    }
}
