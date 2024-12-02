import java.util.Comparator;
import java.util.List;

public class Garaje {
    Integer id;
    List<Vehiculo> vehiculos;

    public Garaje(Integer id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public List<Vehiculo> getVehiculosMenorAMayor(){
        return this.vehiculos.stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto)).toList();
    }
    public List<Vehiculo> getVehiculosMarcaYPrecio(){
        //return this.vehiculos.stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto)).sorted((v1,v2)->v1.getMarca().compareTo(v2.getMarca())).toList();
        return this.vehiculos.stream().sorted((v1,v2)-> {
            if(!v1.getMarca().equals(v2.getMarca())){
                return v1.getMarca().compareTo(v2.getMarca());
            }
            return v1.getCosto().compareTo(v2.getCosto());
        }).toList();

    }
    public List<Vehiculo> getVehiculosMenor1000(){
        return this.vehiculos.stream().filter(v->v.getCosto()<1000).toList();
    }
    public List<Vehiculo> getVehiculosMayorIgual1000(){
        return this.vehiculos.stream().filter(v->v.getCosto()>=1000).toList();
    }
    public Double getPromedioCosto(){
        return this.vehiculos.stream().mapToDouble(Vehiculo::getCosto).average().orElse(0.0);
  //      return this.vehiculos.stream().map(Vehiculo::getCosto).reduce((acc,costo)->costo+acc).orElse(0.0)/this.vehiculos.size();
    }
 }
