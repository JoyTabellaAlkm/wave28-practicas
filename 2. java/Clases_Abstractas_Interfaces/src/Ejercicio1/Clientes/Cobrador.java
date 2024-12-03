package clientes;

public class Cobrador{
    private IConsultaDeSaldo colsultaDeSaldo;
    private IRetiroDeEfectivo retiroDeEfectivo;

    public Cobrador(){
        this.consultarSaldo = new ConsultaDeSaldo();
        this.retiroDeEfectivo = new RetiroDeEfectivo();
    }

    public void consultarSaldo(){
        colsultaDeSaldo.consultarSaldo();
    }

    public void retirarEfectivo(){
        retiroDeEfectivo.retirarEfectivo();
    }
}