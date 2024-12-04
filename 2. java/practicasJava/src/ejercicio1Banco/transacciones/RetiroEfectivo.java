package ejercicio1Banco.transacciones;

public class RetiroEfectivo implements ITransaccion{
    @Override
    public void transaccionOK(){
        System.out.println("Transaccion retiro efectivo realizada");
    }
    @Override
    public void transaccionNoOK()
    {
        System.out.println("Transaccion retiro efectivo no realizada");
    }
}
