package clientes;

public class Ejecutivo{
    private IDeposito deposito;
    private ITransferencia transferencia;

    public Ejecutivo(){
        this.deposito = new Deposito();
        this.transferencia = new Transferencia();
    }

    public void depositar(){
        deposito.depositar();
    }

    public void transferir(){
        transferencia.transferir();
    }
}