import java.util.List;

public class Garaje {

    //id o identificador único y una lista de vehículos.
    private Integer id;
    private List<Vehiculo> vehiculos;
    
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

    @Override
    public String toString() {
        return "Garaje [id=" + id + ", vehiculos=" + vehiculos + "]";
    }

    
}