package integrador_1;

public class Comida extends Reserva {
 //Atributos propios de Comida
  public final String nombre = "Comida";
 Comida(double precio){
  super(precio);
 }
 @Override
 public String toString(){
  return "Tipo de reserva: " + nombre + "Precio: " + precio;
 }
}
