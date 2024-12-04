package org.example.model;

import org.example.Transacciones;

public class Basic extends Usuario{
    @Override
    public void agregarTransaccion(Transacciones transaccion) {
        if (transaccion instanceof ConsultaSaldo || transaccion instanceof PagoServicio  || transaccion instanceof RetiroEfectivo ){
            transaccionesDisponibles.add(transaccion);
            transaccion.transaccionOk();
        }else{
            transaccion.transaccionNoOk();
        }
    }

}
