package Implementations.Clientes;

import Implementations.Transacciones.ConsultaSaldo;
import Implementations.Transacciones.RetiroEfectivo;
import Interfaces.ITransaccion;

public class Cobrador extends Cliente{
    public Cobrador(String nombre) {
        super(nombre);
    }

    @Override
    public void realizarTransaccion(ITransaccion ITransaccion) {
        if (ITransaccion instanceof RetiroEfectivo || ITransaccion instanceof ConsultaSaldo) {
            ITransaccion.transaccionOk();
        } else {
            ITransaccion.transaccionNoOk();
        }
    }
}
