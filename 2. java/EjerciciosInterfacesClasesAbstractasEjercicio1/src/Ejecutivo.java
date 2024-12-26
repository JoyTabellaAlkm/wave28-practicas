public class Ejecutivo {
    void realizaDeposito(){
        Deposito deposito = new Deposito();
        deposito.transaccionOk();
    }
    void realizarTransferencia(){
        Transferencia transferencia = new Transferencia();
        transferencia.transaccionOk();
    }
}
