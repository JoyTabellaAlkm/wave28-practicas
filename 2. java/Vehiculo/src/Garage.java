import java.util.ArrayList;
import java.util.List;

public class Garage {
    private int id;
    private List<Vehiculo> listaVehiculos;

    public Garage(int id) {
        this.id = id;
        this.listaVehiculos = new ArrayList<Vehiculo>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }
}
