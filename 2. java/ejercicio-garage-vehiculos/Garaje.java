import java.util.List;

public class Garaje {
    private int id;
    private List<Vehiculo> listaVehiculos;

    public Garaje(int id, List<Vehiculo> listaVehiculos) {
        this.id = id;
        this.listaVehiculos = listaVehiculos;
    }

    public int getId() {
        return id;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }
}