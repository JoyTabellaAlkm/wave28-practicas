package ejercicio1.transacciones;

import ejercicio1.interfaces.ITransaccion;

public class ConsultaSaldo implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Saldo Consultado");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al consultar saldo");
    }
}
