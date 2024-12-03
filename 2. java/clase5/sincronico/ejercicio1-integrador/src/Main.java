import Clases.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Paloma","Sosa","1234567",new ArrayList<Localizador>());
        ReservaComida reservaComida = new ReservaComida(new Date(),new Date(),1200,true,false,false);
        ReservaTransporte reservaTransporte = new ReservaTransporte(new Date(),new Date(),1500,"Transfer");
        ReservaHotel reservaHotel = new ReservaHotel(new Date(),new Date(),2300,"Holiday Inn");
        ReservaBoletosViaje reservaBoletosViaje = new ReservaBoletosViaje("Aerolineas",123,new Date(), new Date(), 1400);

        List<Reserva> reservas = new ArrayList<>(List.of(reservaTransporte,reservaComida,reservaHotel,reservaBoletosViaje));

        Localizador localizador = new Localizador(cliente,reservas);

        System.out.println(localizador);
    }
}
