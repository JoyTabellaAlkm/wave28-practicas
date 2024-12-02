public class Basic implements IConsultasSaldo, IPagoServicios, IRetirosEfectivo, ITransaccion {
    @Override
    public void retirarEfectivo(Integer monto){
        System.out.println(monto + "$ fueron retirados");
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Retiro: " + Math.random()*10000);
    }

    @Override
    public void transaccionOK(String tipo) {
        System.out.println(tipo + " realizado correctamente");
    }

    @Override
    public void transaccionNoOk(String tipo) {
        System.out.println(tipo + ": hubo un error en su transaccion");
    }

    @Override
    public void pagarServicios(){
        System.out.println("servicios pagados");

    }
}
