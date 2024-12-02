package model;

public class Cobrador extends Usuario{
    @Override
    public void agregarTransaccion(Transacciones transaccion) {
        if (transaccion instanceof ConsultaSaldo || transaccion instanceof RetiroEfectivo){
            transaccionesDisponibles.add(transaccion);
            transaccion.transaccionOk();
        }else{
            transaccion.transaccionNoOk();
        }
    }

}