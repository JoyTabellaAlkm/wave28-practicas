package transacciones;

public class Retiro implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Retiro realizado");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Retiro no realizado");
    }
}
