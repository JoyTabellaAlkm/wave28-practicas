public class ConsultaSaldo implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Realizando consulta del saldo: Transaccion exitosa.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta de saldo fallido: Transacion no realizada.");
    }
}
