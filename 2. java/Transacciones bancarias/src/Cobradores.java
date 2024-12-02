public class Cobradores {
    ConsultaSaldos consultaSaldos;
    Retiro retiro;

    public void consultaSaldos() {
        consultaSaldos.transaccionNoOk();
    }

    public void retiro() {
        retiro.transaccionOk();
    }

    public Cobradores() {
        this.consultaSaldos = new ConsultaSaldos();
        this.retiro = new Retiro();
    }
}
