package modelos;

import interfaces.ITransaccion;

public class Basic extends Usuario{
    @Override
    public void agregarTransaccion(ITransaccion transaccion) {
        if (transaccion instanceof ConsultaSaldo || transaccion instanceof PagoServicio  || transaccion instanceof RetiroEfectivo ){
            transaccionesDisponibles.add(transaccion);
            transaccion.transaccionOk();
        }else{
            transaccion.transaccionNoOk();
        }
    }

}