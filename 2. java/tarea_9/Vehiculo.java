
public class Vehiculo {
  private String modelo;
  private String marca;
  private int costo;

  Vehiculo(String modelo, String marca, int costo){
    this.modelo = modelo;
    this.marca = marca;
    this.costo = costo;
  }

  public void setModelo(String modelo){
    this.modelo = modelo;
  }
  public void setMarca(String marca){
    this.marca = marca;
  }
  public void setCost(int cost){
    this.costo = costo;
  }

  public String getModelo(){
    return modelo;
  }
  public String getMarca(){
    return marca;
  }
  public int getCosto(){
    return costo;
  }

  @Override
  public String toString(){
    return "Modelo: " + modelo + ", Marca: " + marca + ", Costo: " + costo;
  }
}
