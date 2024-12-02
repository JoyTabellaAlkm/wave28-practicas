public class Cobradores implements IRetiroDeEfectivo, IConsultaDeSaldo{
    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo");
        transaccionOk();
    }
}
