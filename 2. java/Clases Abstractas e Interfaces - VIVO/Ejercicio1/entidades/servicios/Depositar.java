package practicaClasesAbstractasInterfaces.transaccionesBancarias.entidades.servicios;

import practicaClasesAbstractasInterfaces.transaccionesBancarias.entidades.ITransaccion;

public class Depositar implements ITransaccion {
    @Override
    public void transaccionOK() {
        System.out.println("Deposito, transaccion OK");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("Deposito, transaccion No OK");
    }
}