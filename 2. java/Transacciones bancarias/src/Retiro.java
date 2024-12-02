public class Retiro implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Retiro, transaccion OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Retiro, transaccion No OK");
    }
}
