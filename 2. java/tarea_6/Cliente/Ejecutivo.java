package tarea_6.Cliente;

import tarea_6.Transaccion.*;

public class Ejecutivo extends Cliente {

  Ejecutivo(String nombre, String dni){
    super(nombre, dni);
  }

  public void Deposito(){
    Deposito ob = new Deposito();
    try{
      ob.transaccionOk();
    } catch (Exception e){
      ob.transaccionNoOk();
    }
  }

  public void Transferencia(){
    Transferencia ob = new Transferencia();
    try{
      ob.transaccionOk();
    } catch (Exception e){
      ob.transaccionNoOk();
    }
  }
}
