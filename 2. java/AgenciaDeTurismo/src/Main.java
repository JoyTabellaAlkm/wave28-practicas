import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        RepositorioClientes repositorio = new RepositorioClientes();
        Cliente cliente = new Cliente("1", "Juan Pérez");
        
        List<Reserva> reservas1 = Arrays.asList(
                new Reserva("hotel", 100.0),
                new Reserva("comida", 50.0),
                new Reserva("boleto", 150.0),
                new Reserva("transporte", 50.0)
        );
        double descuento1 = AgenciaTurismo.calcularDescuento(reservas1, 0);
        double total1 = reservas1.stream().mapToDouble(Reserva::getPrecio).sum() - descuento1;
        Localizador localizador1 = new Localizador("L1", cliente, reservas1, total1, descuento1);
        repositorio.agregarLocalizador(localizador1);
        System.out.println(localizador1);

        List<Reserva> reservas2 = Arrays.asList(
                new Reserva("hotel", 100.0),
                new Reserva("hotel", 100.0),
                new Reserva("boleto", 150.0),
                new Reserva("boleto", 150.0)
        );
        double descuento2 = AgenciaTurismo.calcularDescuento(reservas2, 1);
        double total2 = reservas2.stream().mapToDouble(Reserva::getPrecio).sum() - descuento2;
        Localizador localizador2 = new Localizador("L2", cliente, reservas2, total2, descuento2);
        repositorio.agregarLocalizador(localizador2);
        System.out.println(localizador2);

        List<Reserva> reservas3 = Collections.singletonList(new Reserva("hotel", 100.0));
        double descuento3 = AgenciaTurismo.calcularDescuento(reservas3, 2);
        double total3 = reservas3.stream().mapToDouble(Reserva::getPrecio).sum() - descuento3;
        Localizador localizador3 = new Localizador("L3", cliente, reservas3, total3, descuento3);
        repositorio.agregarLocalizador(localizador3);
        System.out.println(localizador3);

        System.out.println("Cantidad de localizadores vendidos: " + repositorio.cantidadLocalizadoresVendidos());
        System.out.println("Cantidad total de reservas: " + repositorio.cantidadTotalReservas());
        System.out.println("Reservas por tipo: " + repositorio.reservasPorTipo());
        System.out.println("Total de ventas: " + repositorio.totalVentas());
        System.out.println("Promedio de ventas: " + repositorio.promedioVentas());
    }
}