package tarea_6.Transaccion;

public class PagoDeServicios implements Transaccion{
  @Override
  public void transaccionOk(){
    System.out.println("Pagando servicios");
  }
  
  @Override
  public void transaccionNoOk(){
    System.out.println("Ocurrio un error al pagar los servicios, intente de nuevo");
  }
  
}
