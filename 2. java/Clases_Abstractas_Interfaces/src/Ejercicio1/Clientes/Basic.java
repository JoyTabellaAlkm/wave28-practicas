package clientes;

public class Basic{
    private IConsultaDeSaldo colsultaDeSaldo;
    private IPagoDeServicios pagoDeServicios;
    private IRetiroDeEfectivo retiroDeEfectivo;

    public Basic(){
        this.consultarSaldo = new ConsultaDeSaldo();
        this.pagoDeServicios = new PagoDeServicios();
        this.retiroDeEfectivo = new retiroDeEfectivo();
    }

    public void consultarSaldo(){
        colsultaDeSaldo.consultarSaldo();
    }

    public void pagarServicios(){
        pagoDeServicios.pagarServicios();
    }

    public void retirarEfectivo(){
        retiroDeEfectivo.retirarEfectivo();
    }
}