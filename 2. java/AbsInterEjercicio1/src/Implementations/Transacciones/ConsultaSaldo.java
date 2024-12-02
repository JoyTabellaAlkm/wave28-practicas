package Implementations.Transacciones;

import Interfaces.ITransaccion;

public class ConsultaSaldo implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("El saldo es: $1234");
    }
}
