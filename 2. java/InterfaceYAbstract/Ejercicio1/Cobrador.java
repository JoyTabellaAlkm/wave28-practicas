public class Cobrador extends Cliente {
    public Cobrador() {
        this.cederAccion(new RetiroEfectivo());
        this.cederAccion(new ConsultaSaldo());
    }
}
