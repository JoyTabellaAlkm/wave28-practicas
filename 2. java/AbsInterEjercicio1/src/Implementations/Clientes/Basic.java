package Implementations.Clientes;

import Implementations.Transacciones.ConsultaSaldo;
import Implementations.Transacciones.PagoServicio;
import Implementations.Transacciones.RetiroEfectivo;
import Interfaces.ITransaccion;

public class Basic extends Cliente {
    public Basic(String nombre) {
        super(nombre);
    }

    @Override
    public void realizarTransaccion(ITransaccion ITransaccion) {
        if (ITransaccion instanceof ConsultaSaldo || ITransaccion instanceof PagoServicio
                || ITransaccion instanceof RetiroEfectivo) {
            ITransaccion.transaccionOk();
        } else {
            ITransaccion.transaccionNoOk();
        }
    }
}
