public class Cobrador implements IRetirosEfectivo, IConsultasSaldo, ITransaccion {
    @Override
    public void retirarEfectivo(Integer monto){
        System.out.println(monto + "$ fueron retirados");
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Su saldo es de: " + Math.random()*10000);
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
