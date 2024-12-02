package practica_transacciones.src.meli.practica.models;
import practica_transacciones.src.meli.practica.ITransaccion;

public class Transferencia implements ITransaccion {

    @Override
    public void transaccionOk() {
        System.out.println("La transferencia se realizo con exito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Hubo un error al realizar la transferencia");
    }

}
