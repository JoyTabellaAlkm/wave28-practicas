package tarea_5;

public class NoPerecedero extends Producto {
  private String tipo;

  public NoPerecedero(String nombre, double precio, String tipo){
    super(nombre, precio);
    this.tipo = tipo;
  }

  public String getTipo(){
    return tipo;
  }

  public void setTipo(){
    this.tipo = tipo;
  }

  @Override
  public String toString(){
    return "No Perecedero: " + this.getNombre() + ", $" + this.getPrecio() + "\n"
    + "Tipo: " + tipo;
  }
  
}
