public class Depositar implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Deposito, transaccion OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Deposito, transaccion No OK");
    }
}