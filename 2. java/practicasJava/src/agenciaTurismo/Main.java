package agenciaTurismo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente(1,"Juan","Pérez");
        Cliente cliente2 = new Cliente(2,"Julieta","Ramirez");

        ReservaComida reservaComida1 = new ReservaComida(1,"desayuno",10.5);
        ReservaComida reservaComida2 = new ReservaComida(2,"cena",12.6);
        ReservaTransporte reservaTransporte1 = new ReservaTransporte(1,"transporte aéreo",13.7);
        ReservaViaje reservaViaje1 = new ReservaViaje(1,"viaje a Cancún",19.7);
        ReservaHotel reservaHotel1 = new ReservaHotel(1,"Hotel equis 5 estrellas",23.1);

        List<Reserva> reservasCliente1 = List.of(reservaComida1,reservaTransporte1,reservaViaje1,reservaHotel1);

        Localizador localizador =  new Localizador();
        localizador.setCliente(cliente1);
        localizador.setReservas(reservasCliente1);

        localizador.calcularDescuento();
        System.out.println(localizador);




    }
}
