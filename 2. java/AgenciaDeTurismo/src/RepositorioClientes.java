import java.util.*;
import java.util.stream.Collectors;

public class RepositorioClientes {
    private Map<String, List<Localizador>> clientes = new HashMap<>();

    public void agregarLocalizador(Localizador localizador) {
        clientes.computeIfAbsent(localizador.getCliente().getId(), k -> new ArrayList<>()).add(localizador);
    }

    public List<Localizador> obtenerLocalizadores(String clienteId) {
        return clientes.getOrDefault(clienteId, new ArrayList<>());
    }

    public long cantidadLocalizadoresVendidos() {
        return clientes.values().stream().flatMap(Collection::stream).count();
    }

    public long cantidadTotalReservas() {
        return clientes.values().stream()
                .flatMap(Collection::stream)
                .flatMap(localizador -> localizador.getReservas().stream())
                .count();
    }

    public Map<String, Long> reservasPorTipo() {
        return clientes.values().stream()
                .flatMap(Collection::stream)
                .flatMap(localizador -> localizador.getReservas().stream())
                .collect(Collectors.groupingBy(Reserva::getTipo, Collectors.counting()));
    }

    public double totalVentas() {
        return clientes.values().stream()
                .flatMap(Collection::stream)
                .mapToDouble(Localizador::getTotal)
                .sum();
    }

    public double promedioVentas() {
        return clientes.values().stream()
                .flatMap(Collection::stream)
                .mapToDouble(Localizador::getTotal)
                .average()
                .orElse(0.0);
    }
}
