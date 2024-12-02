public class ConsultaSaldos implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldos, transaccion OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta de saldos, no se puede realizar la transaccion");
    }
}