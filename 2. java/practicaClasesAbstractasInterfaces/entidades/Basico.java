package practicaClasesAbstractasInterfaces.entidades;

import practicaClasesAbstractasInterfaces.servicios.ConsultaSaldos;
import practicaClasesAbstractasInterfaces.servicios.Depositar;
import practicaClasesAbstractasInterfaces.servicios.PagoServicio;

public class Basico {
    ConsultaSaldos consultaSaldos;
    PagoServicio pagoServicio;
    Depositar depositar;

    public Basico() {
        this.consultaSaldos = new ConsultaSaldos();
        this.pagoServicio = new PagoServicio();
        this.depositar = new Depositar();
    }

    public void getConsultaSaldos() {
        consultaSaldos.transaccionOK();
    }
    public void getPagoServicio() {
        pagoServicio.transaccionNoOK();
    }
    public void getDepositar() {
        depositar.transaccionOK();
    }
}
