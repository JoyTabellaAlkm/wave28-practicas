
import java.util.*;

public class Garaje {
  private int id;
  private List<Vehiculo> lista; 

  Garaje(int id){
    this.id = id;
    lista = new ArrayList<>();
  }

  void agregarVehiculo(Vehiculo carrito){
    lista.add(carrito);
  }

  public List<Vehiculo> getVehiculos(){
    return lista;
  }
}
