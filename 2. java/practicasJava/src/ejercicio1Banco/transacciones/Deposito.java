package ejercicio1Banco.transacciones;

public class Deposito implements ITransaccion{
    @Override
    public void transaccionOK(){
        System.out.println("Transaccion deposito realizada");
    }
    @Override
    public void transaccionNoOK()
    {
        System.out.println("Transaccion deposito no realizada");
    }
}
