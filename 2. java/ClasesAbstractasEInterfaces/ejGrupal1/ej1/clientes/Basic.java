package clasesAbstractas.ejGrupal1.ej1.clientes;

import clasesAbstractas.ejGrupal1.ej1.clientes.transacciones.ConsultaSaldo;
import clasesAbstractas.ejGrupal1.ej1.clientes.transacciones.PagoServicio;
import clasesAbstractas.ejGrupal1.ej1.clientes.transacciones.RetiroEfectivo;

public class Basic {
    private ConsultaSaldo consultaSaldo;
    private PagoServicio pagoServicio;
    private RetiroEfectivo retiroEfectivo;

    public Basic(ConsultaSaldo consultaSaldo, PagoServicio pagoServicio, RetiroEfectivo retiroEfectivo) {
        this.consultaSaldo = consultaSaldo;
        this.pagoServicio = pagoServicio;
        this.retiroEfectivo = retiroEfectivo;
    }

    public ConsultaSaldo getConsultaSaldo() {
        return consultaSaldo;
    }

    public void setConsultaSaldo(ConsultaSaldo consultaSaldo) {
        this.consultaSaldo = consultaSaldo;
    }

    public PagoServicio getPagoServicio() {
        return pagoServicio;
    }

    public void setPagoServicio(PagoServicio pagoServicio) {
        this.pagoServicio = pagoServicio;
    }

    public RetiroEfectivo getRetiroEfectivo() {
        return retiroEfectivo;
    }

    public void setRetiroEfectivo(RetiroEfectivo retiroEfectivo) {
        this.retiroEfectivo = retiroEfectivo;
    }
}
