package modelos;

import interfaces.ITransaccion;

public class Cobrador extends Usuario{
    @Override
    public void agregarTransaccion(ITransaccion transaccion) {
        if (transaccion instanceof ConsultaSaldo || transaccion instanceof RetiroEfectivo){
            transaccionesDisponibles.add(transaccion);
            transaccion.transaccionOk();
        }else{
            transaccion.transaccionNoOk();
        }
    }

}
