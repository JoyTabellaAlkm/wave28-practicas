package tarea_6.Cliente;

import tarea_6.Transaccion.ConsultaSaldo;
import tarea_6.Transaccion.PagoDeServicios;
import tarea_6.Transaccion.RetiroEfectivo;

public class Cobrador extends Cliente {
  Cobrador(String nombre, String dni){
    super(nombre, dni);
  }

  public void getSaldo(){
    ConsultaSaldo ob = new ConsultaSaldo();
    try{
      ob.transaccionOk();
    } catch (Exception e){
      ob.transaccionNoOk();
    }
  }
  
  public void PagoServicio(){
    PagoDeServicios ob = new PagoDeServicios();
    try{
      ob.transaccionOk();
    } catch (Exception e){
      ob.transaccionNoOk();
    }
  }

  public void Retiro(){
    RetiroEfectivo ob = new RetiroEfectivo();
    try{
      ob.transaccionOk();
    } catch (Exception e){
      ob.transaccionNoOk();
    }
  }
}
