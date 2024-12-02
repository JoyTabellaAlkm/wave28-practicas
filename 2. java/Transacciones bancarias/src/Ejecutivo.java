public class Ejecutivo   {

    Depositar depositar;
    Transferencia transferencia;

    public Ejecutivo() {
        this.depositar = new Depositar();
        this.transferencia = new Transferencia();
    }

    public void depositar() {
        depositar.transaccionOk();
    }
    public void transferencia() {
        transferencia.transaccionNoOk();
    }


}
