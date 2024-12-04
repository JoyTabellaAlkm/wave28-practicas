import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(43164044,"Francisco","Caloia");
        Reserva reserva1 = new Reserva("hotel",1000.0);
        Reserva reserva2 = new Reserva("hotel",1000.0);
        Reserva reserva5 = new Reserva("transporte",1000.0);
        Reserva reserva3 = new Reserva("comida",1000.0);
        Reserva reserva4 = new Reserva("boleto",1000.0);

        Localizador localizador1 = new Localizador(1,cliente1, List.of(reserva1,reserva2,reserva3,reserva4,reserva5));
        RepositorioLocalizadores repositorio = new RepositorioLocalizadores();
        repositorio.agregarLocalizador(localizador1);
        System.out.println(Descuento.calcularDescuento(localizador1,repositorio));
        System.out.println(repositorio.reservasPorTipo());
    }
}
