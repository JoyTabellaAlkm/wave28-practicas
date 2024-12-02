package models;

public class Basic {

    private ConsultaDeSaldo consultaDeSaldo;
    private RetiroEnEfectivo retiroEnEfectivo;
    private PagoDeServicios pagoDeServicios;

    public Basic() {
        this.consultaDeSaldo = new ConsultaDeSaldo();
        this.retiroEnEfectivo = new RetiroEnEfectivo();
        this.pagoDeServicios = new PagoDeServicios();
    }

    public void consultarSaldo() {
        this.consultaDeSaldo.consultarSaldo();
    }

    public void retirarEfectivo(double valor) {
        this.retiroEnEfectivo.retirarEnEfectivo(valor);
    }

    public void pagarServicio(String nombreServicio) {
        this.pagoDeServicios.pagarServicio(nombreServicio);
    }
}
