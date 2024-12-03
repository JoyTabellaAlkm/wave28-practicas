package modelos;

import interfaces.ITransaccion;

public class Ejecutivo extends Usuario {

    @Override
    public void agregarTransaccion(ITransaccion transaccion) {
        if (transaccion instanceof Deposito || transaccion instanceof Transferencia) {
            transaccionesDisponibles.add(transaccion);
            transaccion.transaccionOk();
        } else {
            transaccion.transaccionNoOk();
        }
    }


}