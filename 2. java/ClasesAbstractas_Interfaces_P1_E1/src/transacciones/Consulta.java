package transacciones;

public class Consulta implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Consulta de Saldo realizada");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta de Saldo no realizada");
    }
}
