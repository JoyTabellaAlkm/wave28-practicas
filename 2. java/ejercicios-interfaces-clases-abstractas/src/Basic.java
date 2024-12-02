public class Basic implements IConsultaDeSaldo, IPagoDeServicios,IRetiroDeEfectivo{
    @Override
    public void pagoServicio() {
        System.out.println("Pagando servicio");
        transaccionOk();
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo");
        transaccionOk();
    }
}
