public class ConsultaDeSaldo implements ITransaccion{
    @Override
    public void transaccionOk(){
        System.out.println("Consulta realizada");
    };

    @Override
    public void transaccionNoOk(){
        System.out.println("Consulta denegada");
    };
}
