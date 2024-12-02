package recapitulando_java.ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Garaje {
    private Integer id;
    private List<Vehiculo> listaVehiculos;

    public Garaje(Integer id) {
        this.id = id;
        this.listaVehiculos = new ArrayList<>();
    }

    public Garaje(Integer id, List<Vehiculo> listaVehiculos) {
        this.id = id;
        this.listaVehiculos = listaVehiculos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }



    @Override
    public String toString() {
        return "Garaje{" +
                "id=" + id +
                ", listaVehiculos=" + listaVehiculos +
                '}';
    }
}
