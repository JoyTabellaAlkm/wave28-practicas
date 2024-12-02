package clientes;

import transacciones.ConsultaSaldo;
import transacciones.RetiroEfectivo;

public class Cobradores extends Cliente {

    public Cobradores() {
        super("Cobradores");
        transacciones.add(new RetiroEfectivo());
        transacciones.add(new ConsultaSaldo());
    }

}
