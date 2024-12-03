package ejercicio1.transacciones;

import ejercicio1.interfaces.ITransaccion;

public class Deposito implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Deposito realizado satisfactoriamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al realizar el depósito");
    }
}
