package Implementations.Clientes;

import Implementations.Transacciones.Deposito;
import Implementations.Transacciones.Transferencia;
import Interfaces.ITransaccion;

public class Ejecutivo extends Cliente {
    public Ejecutivo(String nombre) {
        super(nombre);
    }

    @Override
    public void realizarTransaccion(ITransaccion ITransaccion) {
        if (ITransaccion instanceof Deposito || ITransaccion instanceof Transferencia) {
            ITransaccion.transaccionOk();
        } else {
            ITransaccion.transaccionNoOk();
        }
    }
}
