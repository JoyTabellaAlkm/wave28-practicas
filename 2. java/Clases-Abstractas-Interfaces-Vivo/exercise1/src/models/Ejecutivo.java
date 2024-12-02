package models;

public class Ejecutivo {

    private Deposito deposito;
    private Transferencia transferencia;

    public Ejecutivo() {
        this.deposito = new Deposito();
        this.transferencia = new Transferencia();
    }

    public void depositar(double valor) {
        this.deposito.depositar(valor);
    }

    public void transferir(double valor) {
        this.transferencia.transferir(valor);
    }
}
