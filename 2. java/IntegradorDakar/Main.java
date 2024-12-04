import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Auto auto = new Auto(110.00,130.00,90.00,"SVP928");
        Moto moto = new Moto(320.00,29.00,60.00,"LPE123");

        SocorristaAuto socorristaAuto = new SocorristaAuto();
        SocorristaMoto socorristaMoto = new SocorristaMoto();

        Carrera carrera = new Carrera(3000.00,1500.00,"Carrera falsa", 10,new ArrayList<>(),socorristaAuto,socorristaMoto);

        carrera.darDeAltaAuto(230.00,100.00,90.00,"RWW939");
        carrera.darDeAltaMoto(300.00,10.00,90.00,"KGV666");
        carrera.altaAuto(auto);
        carrera.altaMoto(moto);


        System.out.println();
        System.out.println(carrera.getVehiculos());
        System.out.println();

        //carrera.eliminarVehiculo(auto);
        //carrera.eliminarVehiculoConPatente("RWW939");
        System.out.println(carrera.getVehiculos());
        carrera.darDeAltaAuto(320.00,29.00,60.00,"LPE123");
        System.out.println();

        System.out.println("El vehiculo ganador es: ");
        System.out.println(carrera.calcularGanador());

        System.out.println();
        carrera.getSocorristaAuto().Socorrer("SVP928",carrera.getVehiculos());
        carrera.getSocorristaMoto().Socorrer("LPE123",carrera.getVehiculos());

    }
}