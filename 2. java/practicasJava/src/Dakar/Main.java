package Dakar;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(10.5,1000.4,"nivel intermedio",2,new ArrayList<Vehiculo>());
        Vehiculo vehiculo1 = new Vehiculo(12.5,13.5,2.5,"LNQ750");
        Moto moto1 = new Moto(12.5,13.5,2.5,"LNQ750");
        carrera.darDeAltaMoto(12.5,13.5,2.5,"LNQ750");
        carrera.darDeAltaAuto(12.5,13.5,2.5,"LNQ760");
        carrera.calcularGanador();

    }
}
