package practica_transacciones.src.meli.practica.models;
import practica_transacciones.src.meli.practica.ITransaccion;

public class Deposito implements ITransaccion {

    @Override
    public void transaccionOk() {
        System.out.println("El deposito se realizo con exito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Hubo un error al realizar el deposito");
    }

}
