public class Transferencia implements ITransaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Realizando transferencia: Trasaccion exitosa.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Tranferencia fallida: Transaccion no realizada.");
    }
}
