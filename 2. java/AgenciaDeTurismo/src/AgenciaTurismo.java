import java.util.List;

public class AgenciaTurismo {
    public static double calcularDescuento(List<Reserva> reservas, long localizadoresPrevios) {
        double total = reservas.stream().mapToDouble(Reserva::getPrecio).sum();
        boolean paqueteCompleto = reservas.stream().map(Reserva::getTipo).distinct().count() == 4;
        long hoteles = reservas.stream().filter(r -> r.getTipo().equals("hotel")).count();
        long boletos = reservas.stream().filter(r -> r.getTipo().equals("boleto")).count();

        double descuento = 0.0;
        if (localizadoresPrevios >= 2) descuento += 0.05;
        if (paqueteCompleto) descuento += 0.10;
        if (hoteles >= 2 || boletos >= 2) descuento += 0.05;

        return total * descuento;
    }
}
