import Modelo.Auto;
import Modelo.Carrera;
import Modelo.Moto;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(10.00,1000,"Carrera falsa",5,new ArrayList<>());
        Auto auto1 = new Auto(50.0,10.0,23.0,"Auto1");
        Auto auto2 = new Auto(70.0,12.0,26.0,"Auto2");
        Moto moto1 = new Moto(40.0,80.0,20.0,"Moto1");
        Moto moto2 = new Moto(60.0,60.0,18.0,"Moto2");
        Moto moto3 = new Moto(55.0,70.0,15.0,"Moto3");

        carrera.darDealtaAuto(50.0,10.0,23.0,"Auto1");
        carrera.darDealtaAuto(70.0,12.0,26.0,"Auto2");
        carrera.darDealtaMoto(40.0,80.0,20.0,"Moto1");
        carrera.darDealtaMoto(60.0,60.0,18.0,"Moto2");
        carrera.darDealtaMoto(55.0,70.0,15.0,"Moto3");
        carrera.darDealtaMoto(55.0,70.0,15.0,"Moto4");

        carrera.socurrerMoto("Moto1");
        carrera.socurrerAuto("Auto1");

        //carrera.eliminarVehiculo(carrera.getVehiculos().get(2));
        //carrera.eliminarVehiculoConPatente(carrera.getVehiculos().get(1).getPatente());

        carrera.definirGanador();
    }
}
