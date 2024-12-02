package ejercicio1.clases;

public class Ejecutivo {

    private Deposito deposito;
    private Transferencia transferencia;

    public Ejecutivo() {
        this.deposito = new Deposito();
        this.transferencia = new Transferencia();
    }

    public void deposito() {
        System.out.print("Deposito cliente ejecutivo: ");
        deposito.transaccionOk();
    }


    public void transferencia() {
        System.out.print("Transferencia cliente Ejecutivo: ");
        transferencia.transaccionNoOk();
    }

}
