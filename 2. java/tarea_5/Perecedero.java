package tarea_5;

public class Perecedero extends Producto {
  private int diasPorCaducar;

  public Perecedero(String nombre, double precio, int disPorCaducar){
    super(nombre, precio);
    this.diasPorCaducar = disPorCaducar;
  }

  public int getDisPorCaducar(){
    return diasPorCaducar;
  }

  public void setDiasPorCaducar(int diasPorCaducar){
    this.diasPorCaducar = diasPorCaducar;
  }

  @Override
  public double calcular(int cantidadDeProductos){
    double respuesta = this.getPrecio();
    if( this.diasPorCaducar == 1){
      respuesta *= cantidadDeProductos * 0.25;
    }else if( this.diasPorCaducar == 2){
      respuesta *= cantidadDeProductos * 0.33;
    }else if( this.diasPorCaducar == 3){
      respuesta *= cantidadDeProductos * 0.50;
    }else if( this.diasPorCaducar > 3){
      respuesta *= cantidadDeProductos;
    }
    return respuesta;
  }

  @Override
  public String toString(){
    return "Perecedero: " + this.getNombre() + ", $" + this.getPrecio() + "\n"
    + "Dias a caducar: " + diasPorCaducar;
  }
}
