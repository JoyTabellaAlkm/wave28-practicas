package transacciones;

public class Deposito implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Deposito realizado");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Deposito no realizado");
    }
}
