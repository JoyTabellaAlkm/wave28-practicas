package tarea_6.Transaccion;

public class Deposito implements Transaccion{
  @Override
  public void transaccionOk(){
    System.out.println("Depositando");
  }
  
  @Override
  public void transaccionNoOk(){
    System.out.println("Ocurrio un error al depositar, intente de nuevo");
  }
}
