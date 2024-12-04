

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Moto moto1= new Moto(150.0, 300.0,3.5,"PFD004");
        Moto moto2= new Moto(350.0, 150.0,32.5,"KIP557");
        Moto moto3= new Moto(450.0, 400.0,48.9,"RST879");

        Auto auto1 =new Auto(500.0,400.0,74.9, "REW234");
        Auto auto2 =new Auto(200.0,350.0,14.7, "TGV445");
        Auto auto3 =new Auto(100.0,54.0,19.3, "PLM645");
        List<Vehiculo> carrerasVehiculo = new ArrayList<>();


        Carrera carreraDackar = new Carrera(350.6, 300000.0,"Dakar 2025",10,carrerasVehiculo);

        System.out.println("------------- CARRERA CREADA -------------");

        carreraDackar.darDeAltaVehiculo(auto1);
        carreraDackar.darDeAltaVehiculo(auto2);
        carreraDackar.darDeAltaVehiculo(auto3);
        carreraDackar.darDeAltaVehiculo(moto1);
        carreraDackar.darDeAltaVehiculo(moto2);
        carreraDackar.darDeAltaVehiculo(moto3);
        System.out.println(carreraDackar);

        System.out.println("------------- SE ELIMINA VEHICULO-------------");
        carreraDackar.eliminarVehiculo(auto1);
        carreraDackar.eliminarVehiculoConPatente("TGV445");
        System.out.println(carreraDackar);

        System.out.println("------------- VEHICULO GANADOR-------------");
        carreraDackar.determinarGanador();

        System.out.println("------------- VEHICULO SOCORRISTAS -------------");
        SocorristaMoto socorristaMoto= new SocorristaMoto();
        SocorristaAuto socorristaAuto = new SocorristaAuto();

        socorristaMoto.socorrer(moto1);
        socorristaAuto.socorrer(auto2);
    }
}