public class Transferencia implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Se realizó la transferencia exitosamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo realizar la transferencia");
    }
}
