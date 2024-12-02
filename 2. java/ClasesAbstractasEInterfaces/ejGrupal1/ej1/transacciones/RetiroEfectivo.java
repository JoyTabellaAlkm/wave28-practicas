package clasesAbstractas.ejGrupal1.ej1.clientes.transacciones;

public class RetiroEfectivo implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Retiro de efectivo realizado");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Retiro de efectivo no realizado");
    }
}
