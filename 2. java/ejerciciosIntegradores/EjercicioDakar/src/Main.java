import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] strings){
        Moto moto = new Moto(100, 20, 12, "FCG-ASA", 300, 2 );
        Moto moto1 = new Moto(90, 10, 11, "MMM-ASA", 300, 2 );
        Moto moto2 = new Moto(120, 110, 10, "FCG-ASA", 300, 2 );

        Auto auto = new Auto(80, 20, 12, "CDG-ASA", 1000, 4 );
        Auto auto1 = new Auto(10, 10, 14, "ASA-ASA", 1000, 4 );

        List<Vehiculo> listVehiculo = new ArrayList<>(List.of(auto1, auto, moto, moto1, moto2 ));
        Carrera carrera = new Carrera(100, 2000, "Carrera por la paz", 2, listVehiculo);

        carrera.socorrerAuto(auto);
        carrera.socorrerMoto(moto);

        Vehiculo ganador = carrera.obtenerGanador();
        System.out.println("Datos del ganador " + ganador);







    }
}
