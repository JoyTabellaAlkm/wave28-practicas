package clasesAbstractas.ejGrupal1.ej1.clientes.transacciones;

public class Transferencia implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Transaccion realizada");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no realizada");
    }
}
