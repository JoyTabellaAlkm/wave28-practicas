package integrador_1;

public class Boleto extends Reserva{
 //Atributos propios de Boleto
  public final String nombre = "Boleto";
  Boleto(double precio){
    super(precio);
 }


 @Override
 public String toString(){
  return "Tipo de reserva: " + nombre + "Precio: " + precio;
 }
}
