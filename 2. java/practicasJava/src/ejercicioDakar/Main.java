package ejercicioDakar;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vehiculo vehiculo1 = new Auto(240, 80, 45, "FED430");
        Vehiculo moto1 = new Moto(60, 50, 60, "LNQ750");

        ArrayList<Vehiculo> vehiculoList = new ArrayList<>();
        vehiculoList.add(vehiculo1);
        vehiculoList.add(moto1);

        Carrera carrera = new Carrera(10.5, 1000.4,
                "nivel intermedio", 3, vehiculoList);

        carrera.darDeAltaMoto(16.5, 2.5, 2.5, "LNQ750");
        carrera.darDeAltaAuto(12.5, 13.5, 2.5, "LNQ760");

        carrera.calcularGanador();

    }
}
