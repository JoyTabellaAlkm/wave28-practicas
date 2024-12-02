import java.util.ArrayList;

public class Ejecutivo implements IDeposito, ITransferencia{


    @Override
    public void depositar() {
        System.out.println("Realizando deposito");
        transaccionOk();
    }

    @Override
    public void transferir() {
        System.out.println("Realizando transferencia");
        transaccionOk();
    }
}
