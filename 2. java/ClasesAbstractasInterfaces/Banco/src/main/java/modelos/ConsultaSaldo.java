package modelos;

import interfaces.ITransaccion;

public class ConsultaSaldo implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Realizando consulta de saldo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se puedo realizar la consulta de saldo");

    }
}