package model;

public class Ejecutivo extends Usuario {

    @Override
    public void agregarTransaccion(Transacciones transaccion) {
        if (transaccion instanceof Deposito || transaccion instanceof Transferencia){
            transaccionesDisponibles.add(transaccion);
            transaccion.transaccionOk();
        }else{
            transaccion.transaccionNoOk();
        }
    }
}