package practicaClasesAbstractasInterfaces.transaccionesBancarias.entidades.servicios;

import practicaClasesAbstractasInterfaces.transaccionesBancarias.entidades.ITransaccion;

public class Retiro implements ITransaccion {
    @Override
    public void transaccionOK() {
        System.out.println("Retiro OK");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("Retiro No OK");
    }
}
