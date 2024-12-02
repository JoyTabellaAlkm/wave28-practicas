public class Ejecutivo extends Cliente {
    public Ejecutivo() {
        this.cederAccion(new Deposito());
        this.cederAccion(new Transferencia());
    }
}
