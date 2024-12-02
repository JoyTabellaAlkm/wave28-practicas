package ejercicio1;

public class RetiroDeEfectivo implements ITransaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Retiro de efectivo exitoso");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Retiro de efectivo fallido");
    }
}
