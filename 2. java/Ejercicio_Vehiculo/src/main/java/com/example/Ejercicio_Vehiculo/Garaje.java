package com.example.Ejercicio_Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Garaje {
    private Integer id;
    private List<Vehiculo> vehiculoList;

    public Garaje(Integer id, List<Vehiculo> vehiculoList) {
        this.id = id;
        this.vehiculoList = vehiculoList;
    }
    public Garaje(Integer id) {
        this.id = id;
        this.vehiculoList = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }
}
