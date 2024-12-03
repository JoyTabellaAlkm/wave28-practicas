package LambdasGenericsWrappers;

import java.util.ArrayList;

public class Garaje {

    Integer id;
    ArrayList<Vehiculo> vehiculos;

    public Garaje() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
