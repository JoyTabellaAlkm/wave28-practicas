package org.example;

import org.example.modelos.Auto;
import org.example.modelos.Carrera;
import org.example.modelos.Moto;
import org.example.modelos.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Auto auto = new Auto(230.00,100.00,90.00,"RWW939");
        Auto auto1 = new Auto(200.00,120.00,90.00,"DJW222");
        Auto auto2 = new Auto(110.00,130.00,90.00,"SVP928");

        Moto moto = new Moto(300.00,10.00,90.00,"RWW939");

        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(auto);
        vehiculos.add(auto1);
        vehiculos.add(moto);
        Carrera carrera = new Carrera(3000.00,1500.00,"Carrera falsa", 10,vehiculos);

        carrera.eliminarVehiculo(auto);
        carrera.eliminarVehiculoConPatente("DJW222");
        System.out.println(carrera.getVehiculos().size());
        carrera.darDeAltaAuto(110.00,130.00,90.00,"SVP928");

    }
}