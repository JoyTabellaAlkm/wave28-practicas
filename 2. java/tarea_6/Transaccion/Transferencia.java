package tarea_6.Transaccion;

public class Transferencia implements Transaccion {
  @Override
  public void transaccionOk(){
    System.out.println("Realizando transferencia");
  }
  
  @Override
  public void transaccionNoOk(){
    System.out.println("Ocurrio un error al realizar la transferencia, intente de nuevo");
  }
}
