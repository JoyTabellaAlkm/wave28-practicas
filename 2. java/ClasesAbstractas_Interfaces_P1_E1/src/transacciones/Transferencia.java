package transacciones;

public class Transferencia implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia realizada");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transferencia no realizadaß");
    }
}
