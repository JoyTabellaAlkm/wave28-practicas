package ejercicio1.clases;

public class Basic {
    private ConsultaDeSaldo consultaDeSaldo;
    private PagoDeServicios pagoDeServicios;
    private RetiroDeEfectivo retiroDeEfectivo;

    public Basic() {
        this.consultaDeSaldo = new ConsultaDeSaldo();
        this.pagoDeServicios = new PagoDeServicios();
        this.retiroDeEfectivo = new RetiroDeEfectivo();
    }

    public void consultaDeSaldo() {
        System.out.print("Consulta de saldo cliente Basic: ");
        consultaDeSaldo.transaccionOk();
    }

    public void pagoDeServicios() {
        System.out.print("Pago de servicio cliente Basic: ");
        pagoDeServicios.transaccionNoOk();
    }

    public void retiroDeEfectivo() {
        System.out.print("Retiro de efectivo cliente Basic: ");
        retiroDeEfectivo.transaccionOk();
    }
}
