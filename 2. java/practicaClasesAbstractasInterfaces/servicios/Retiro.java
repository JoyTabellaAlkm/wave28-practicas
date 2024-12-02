package practicaClasesAbstractasInterfaces.servicios;

import practicaClasesAbstractasInterfaces.ITransaccion;

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
