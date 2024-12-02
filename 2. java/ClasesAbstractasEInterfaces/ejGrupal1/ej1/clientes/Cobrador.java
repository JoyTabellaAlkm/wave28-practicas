package clasesAbstractas.ejGrupal1.ej1.clientes;

import clasesAbstractas.ejGrupal1.ej1.clientes.transacciones.ConsultaSaldo;
import clasesAbstractas.ejGrupal1.ej1.clientes.transacciones.RetiroEfectivo;

public class Cobrador {
    private RetiroEfectivo retiroEfectivo;
    private ConsultaSaldo consultaSaldo;

    public Cobrador(RetiroEfectivo retiroEfectivo, ConsultaSaldo consultaSaldo) {
        this.retiroEfectivo = retiroEfectivo;
        this.consultaSaldo = consultaSaldo;
    }

    public RetiroEfectivo getRetiroEfectivo() {
        return retiroEfectivo;
    }

    public void setRetiroEfectivo(RetiroEfectivo retiroEfectivo) {
        this.retiroEfectivo = retiroEfectivo;
    }

    public ConsultaSaldo getConsultaSaldo() {
        return consultaSaldo;
    }

    public void setConsultaSaldo(ConsultaSaldo consultaSaldo) {
        this.consultaSaldo = consultaSaldo;
    }
}
