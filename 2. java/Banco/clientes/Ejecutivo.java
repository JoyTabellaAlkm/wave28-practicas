package clientes;

import transacciones.Deposito;
import transacciones.Transferencia;

public class Ejecutivo extends Cliente {

    public Ejecutivo() {
        super("Ejecutivo");
        transacciones.add(new Deposito());
        transacciones.add(new Transferencia());
    }

}
