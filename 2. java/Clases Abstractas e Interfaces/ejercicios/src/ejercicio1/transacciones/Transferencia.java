package ejercicio1.transacciones;

import ejercicio1.interfaces.ITransaccion;

public class Transferencia implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia realizada con éxito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al realizar la transferencia");
    }
}
