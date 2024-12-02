package Clientes;

public abstract class Cliente {
    private Double saldoActual=1000.0;

    public Double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(Double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public void verSaldoActual() {
        System.out.println("Su saldo actual es: " + this.saldoActual);

    }

    public abstract  void realizarTransaccion(String operacion);


}
