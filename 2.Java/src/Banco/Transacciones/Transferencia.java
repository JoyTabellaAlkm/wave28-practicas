package Banco.Transacciones;

public class Transferencia extends Operacion {
    public Transferencia() {}
     @Override
    public  void transaccionOk(){System.out.println("La transferencia fue realizada con éxito");}
    @Override
    public  void transaccionNoOk(){System.out.println("No se pudo realizar la trasnferencia");}
}
