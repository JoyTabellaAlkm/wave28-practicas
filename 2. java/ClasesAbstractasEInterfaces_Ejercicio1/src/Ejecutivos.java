
public class Ejecutivos implements IDepositos, ITransferencias, ITransaccion {

    @Override
    public void depositarDinero() {
        System.out.println("Depositando dinero");
    }

    @Override
    public void TransferirDinero() {
        System.out.println("El dinero fue transferido");

    }

    @Override
    public void transaccionOK(String tipo) {
        System.out.println(tipo + " realizado correctamente");
    }

    @Override
    public void transaccionNoOk(String tipo) {
        System.out.println(tipo + ": hubo un error en su transaccion");
    }


}
