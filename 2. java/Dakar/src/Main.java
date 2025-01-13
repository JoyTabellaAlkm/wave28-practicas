import model.Carrera;
import model.Vehiculo;

public class Main {
    public static void main(String[] args) {

        Carrera carrera = new Carrera(500, 10000, "Carrera Dakar", 5);

        carrera.darDeAltaAuto(200, 5, 30, "ABC123");
        carrera.darDeAltaMoto(150, 6, 20, "XYZ789");

        carrera.socorrerAuto("ABC123");
        carrera.socorrerMoto("XYZ789");

        Vehiculo ganador = carrera.determinarGanador();
        System.out.println("El ganador es: " + ganador.getPatente());
    }
}