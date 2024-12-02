package models;

public class Cobrador {

    private RetiroEnEfectivo retiroEnEfectivo;
    private ConsultaDeSaldo consultaDeSaldo;

    public Cobrador() {
        this.consultaDeSaldo = new ConsultaDeSaldo();
        this.retiroEnEfectivo = new RetiroEnEfectivo();
    }

    public void consultarSaldo() {
        this.consultaDeSaldo.consultarSaldo();
    }

    public void retirarEnEfectivo(double valor) {
        this.retiroEnEfectivo.retirarEnEfectivo(valor);
    }
}
