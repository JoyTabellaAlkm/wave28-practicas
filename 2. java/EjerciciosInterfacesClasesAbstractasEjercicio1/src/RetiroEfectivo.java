public class RetiroEfectivo implements ITransaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Realizando retiro de efectivo: Transaccion exitosa.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Retiro de efectivo fallido: Transaccion no realizada.");
    }
}
