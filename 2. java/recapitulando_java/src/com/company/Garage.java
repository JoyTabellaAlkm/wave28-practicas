package com.company;


import java.util.ArrayList;
import java.util.List;

public class Garage {
    private int id;
    private List<Vehiculo> vehiculos;

    public Garage(int id) {
        this.id = id;
        this.vehiculos = new ArrayList<Vehiculo>();
    }

    public int getId() {
        return id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }


}
