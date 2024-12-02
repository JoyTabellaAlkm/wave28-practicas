package practica_transacciones.src.meli.practica.models;
import practica_transacciones.src.meli.practica.ITransaccion;

public class PagoServicios implements ITransaccion {

    @Override
    public void transaccionOk() {
        System.out.println("El pago de servicios se realizo con exito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Hubo un error al realizar el pago de servicios");
    }

}
