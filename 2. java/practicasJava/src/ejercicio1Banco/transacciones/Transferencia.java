package ejercicio1Banco.transacciones;

public class Transferencia implements ITransaccion{
    @Override
    public void transaccionOK(){
        System.out.println("Transaccion transaferencia realizada");
    }
    @Override
    public void transaccionNoOK()
    {
        System.out.println("Transaccion transferencia no realizada");
    }
}
