package integrador_1;

public class Hotel extends Reserva{
  //Atributos propios de hotel
  public final String nombre = "Hotel";
  Hotel(double precio){
    super(precio);
  }
  
 @Override
 public String toString(){
  return "Tipo de reserva: " + nombre + "Precio: " + precio;
 }
}
