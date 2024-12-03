import Modelo.*;

import java.awt.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        RepositorioLocalizador repositorioLocalizador = new RepositorioLocalizador();

        ReservaHotel reservaHotel = new ReservaHotel("Hotel en Mexico",2000.00,"Hotel falso");
        ReservaHotel reservaHotel1 = new ReservaHotel("Hotel en Republica Dominicana",1500.00,"Hotel verdadero");
        ReservaComida reservaComida = new ReservaComida("Comida tipica mexicana",200.00,10);
        ReservaComida reservaComida1 = new ReservaComida("Comida tipica española",100.00,8);
        ReservaViaje reservaViaje = new ReservaViaje("Viaje sin escalas", 500.00,"Avion");
        ReservaViaje reservaViaje1 = new ReservaViaje("Viaje en crucero", 700.00,"Crucero");
        ReservaTransporte reservaTransporte = new ReservaTransporte("Viajes ilimitados en metro",300.00,"Metro");


        Cliente cliente = new Cliente("12345","Pablo",25);
        Cliente cliente1 = new Cliente("98765","Cesar",28);

        repositorioLocalizador.addLocalizador(List.of(reservaTransporte,reservaViaje,reservaHotel,reservaComida),cliente,true);
        repositorioLocalizador.addLocalizador(List.of(reservaViaje1,reservaViaje,reservaHotel,reservaHotel1),cliente,false);
        repositorioLocalizador.addLocalizador(List.of(reservaComida1),cliente,false);

        System.out.println("Cantidad Localizadores: " + repositorioLocalizador.cantidadLocalizadoresVendido());
        System.out.println("Total Ventas: " + repositorioLocalizador.totalVentas());
        System.out.println("Promedio Ventas: " + repositorioLocalizador.promedioVentas());

    }
}
