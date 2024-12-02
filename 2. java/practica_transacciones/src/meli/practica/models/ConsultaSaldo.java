package practica_transacciones.src.meli.practica.models;

import practica_transacciones.src.meli.practica.ITransaccion;

public class ConsultaSaldo implements ITransaccion {

    @Override
    public void transaccionOk() {
        System.out.println("La consulta de saldo se realizo con exito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Hubo un error al realizar la consulta de saldo");
    }

}
