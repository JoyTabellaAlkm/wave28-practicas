package ejercicio1.transacciones;

import ejercicio1.interfaces.ITransaccion;

public class RetiroEfectivo implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Retiro realizado con éxito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al realizar el retiro");
    }
}
