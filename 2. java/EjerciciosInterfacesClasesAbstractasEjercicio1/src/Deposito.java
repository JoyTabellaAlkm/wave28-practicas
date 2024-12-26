public class Deposito implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Realizando deposito: Transaccion exitosa.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Deposito fallido: Transaccion no realizada.");
    }
}
