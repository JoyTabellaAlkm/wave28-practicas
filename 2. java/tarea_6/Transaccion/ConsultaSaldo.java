package tarea_6.Transaccion;

public class ConsultaSaldo implements Transaccion{

  @Override
  public void transaccionOk(){
    System.out.println("Consultando saldo");
  }
  
  @Override
  public void transaccionNoOk(){
    System.out.println("Ocurrio un error al consultar el saldo, intente de nuevo");
  }
}
