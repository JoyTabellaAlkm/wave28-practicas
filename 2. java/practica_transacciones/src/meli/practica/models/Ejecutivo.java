package practica_transacciones.src.meli.practica.models;

public class Ejecutivo{

    public void deposito(){
        Deposito deposito = new Deposito();
        deposito.transaccionOk();
    }

    public void transferencia(){
        Transferencia transferencia = new Transferencia();
        transferencia.transaccionOk();
    }

}
