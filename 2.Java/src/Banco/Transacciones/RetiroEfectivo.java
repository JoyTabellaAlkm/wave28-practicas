package Banco.Transacciones;

public class RetiroEfectivo extends Operacion {
    public RetiroEfectivo() {}
    @Override
    public  void transaccionOk(){System.out.println("Retiro de efectivo realizado con éxito");}
    @Override
    public  void transaccionNoOk(){System.out.println("No se pudo realizar el retiro");}
}
