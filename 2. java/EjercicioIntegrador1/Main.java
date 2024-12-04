import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Localizador> localizadores =  new ArrayList<>();
        Reserva reservaHotel = new Reserva(1200, "HOTEL");        
        Reserva reservaViaje = new Reserva(1500, "VIAJE");        
        Reserva reservaTransporte = new Reserva(800, "TRANSPORTE");        
        Reserva reservaComida = new Reserva(900, "COMIDA");  
        
        List<Reserva> paqueteCompleto = new ArrayList(List.of(reservaComida,reservaHotel,reservaTransporte,reservaViaje));


        Cliente cliente1 = new Cliente("juan", "perez", "1234567");
        Localizador localizador1 = new Localizador(1, cliente1,paqueteCompleto);
        localizadores.add(localizador1);

        System.out.println("\n====== PAQUETE COMPLETO ======");

        System.out.println(localizadores);

        System.out.println("\n====== DOS RESERVAS HOTEL Y VIAJE ======");

        Localizador localizador2 = new Localizador(2, cliente1,new ArrayList<>(List.of(reservaHotel,reservaHotel,reservaViaje, reservaViaje)));
        localizadores.add(localizador2);

        System.out.println(localizadores.get(1));

        System.out.println("\n====== UNA RESERVA CON DOS LOCALIZADORES PREVIOS ======");
        Localizador localizador3 = new Localizador(2, cliente1,new ArrayList<>(List.of(reservaTransporte)));

        localizador3.aplicarDescuentos(localizadores.stream()
        .filter(l -> l.getCliente().getDni().equals(localizador3.getCliente().getDni())).count() >=2);

        localizadores.add(localizador3);

        System.out.println(localizadores.get(2));

        System.out.println("\n====== CANTIDAD DE LOCALIZADORES VENDIDOS ======");
        System.out.println(localizadores.size());

        System.out.println("\n====== CANTIDAD DE RESERVAS TOTAL ======");
        System.out.println(localizadores.stream().flatMap(l -> l.getReservas().stream()).count());


        System.out.println("\n====== RESERVAS CLASIFICADAS ======");
        Map<String,List<Reserva>> conteoDeTipoDeReservas = localizadores.stream()
        .flatMap(l -> l.getReservas().stream())
        .collect(Collectors.groupingBy(r -> r.getTipo()));

        conteoDeTipoDeReservas.forEach((t,r) -> {
            System.out.println("Tipo: "+ t);
            System.out.println(r);
        });

        System.out.println("\n====== TOTAL VENTAS ======");
        System.out.println(localizadores.stream().mapToDouble(l -> l.getCostoTotal()).sum());

        System.out.println("\n====== PROMEDIO VENTAS ======");
        System.out.println(localizadores.stream().mapToDouble(l -> l.getCostoTotal()).average());

    }
}