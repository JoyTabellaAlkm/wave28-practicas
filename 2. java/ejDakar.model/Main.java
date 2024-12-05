
import dakar.model.*;
import ejIntegradores.ejIntegrador.model.Cliente;
import ejIntegradores.ejIntegrador.model.Factura;
import ejIntegradores.ejIntegrador.repository.ClienteRepository;
import ejIntegradores.ejIntegrador.repository.FacturaRepository;
import ejIntegradores.ejIntegrador.model.Item;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Auto auto = new Auto(230.00,100.00,90.00,"RWW939");
        Auto auto1 = new Auto(200.00,120.00,90.00,"DJW222");
        Auto auto2 = new Auto(110.00,130.00,90.00,"SVP928");
        SocorristaMoto socorristaMoto = new SocorristaMoto();
        SocorristaAuto socorristaAuto = new SocorristaAuto();

        Moto moto = new Moto(300.00,10.00,90.00,"RWW939");

        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(auto);
        vehiculos.add(auto1);
        vehiculos.add(moto);
        Carrera carrera = new Carrera(3000.00,1500.00,"Carrera falsa", 10,socorristaAuto, socorristaMoto,vehiculos);

        carrera.eliminarVehiculo(auto);
        carrera.eliminarVehiculoConPatente("DJW222");
        carrera.darDeAltaAuto(110.00,130.00,90.00,"SVP928");

        System.out.println("El ganador de la carrera es: " + carrera.encontrarGanador().toString());

        carrera.socorrerAuto(auto2.getPatente());
        carrera.socorrerMoto(auto2.getPatente());



    }
}