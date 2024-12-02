package tarea_6.Transaccion;

public class RetiroEfectivo implements Transaccion{
  @Override
  public void transaccionOk(){
    System.out.println("Retirando Efectivo");
  }
  
  @Override
  public void transaccionNoOk(){
    System.out.println("Ocurrio un error al retirar efectivo, intente de nuevo");
  }
  
}
