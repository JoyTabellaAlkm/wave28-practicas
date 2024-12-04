package ejercicio1Banco.transacciones;

public class ConsultaSaldo implements ITransaccion{
    @Override
    public void transaccionOK(){
        System.out.println("Transaccion consulta saldo realizada");
    }
    @Override
    public void transaccionNoOK()
    {
        System.out.println("Transaccion consulta saldo no realizada");
    }
}
