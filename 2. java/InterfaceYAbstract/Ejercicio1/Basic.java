public class Basic extends Cliente {
    public Basic() {
        this.cederAccion(new ConsultaSaldo());
        this.cederAccion(new PagoServicio());
        this.cederAccion(new RetiroEfectivo());
    }
}
