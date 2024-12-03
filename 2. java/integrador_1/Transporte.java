package integrador_1;

public class Transporte extends Reserva{
  //Atributos propios de trasnporte
  public final String nombre = "Transporte";
  Transporte(double precio){
    super(precio);
  }
  
 @Override
 public String toString(){
  return "Tipo de reserva: " + nombre + "Precio: " + precio;
 }
}
