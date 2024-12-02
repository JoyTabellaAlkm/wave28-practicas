package clasesAbstractas.ejGrupal1.ej1.clientes.transacciones;

public class ConsultaSaldo implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo realizada");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta de saldo no realizada");
    }
}
