package AgenciaTurismo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepositorioClientes {
    private HashMap<Integer, Cliente> clientes;

    public RepositorioClientes() {
        this.clientes = new HashMap<>();
    }

    public HashMap<Integer, Cliente> getClientes() {
        return clientes;
    }

    public Localizador buscarLocalizador() {
        return null;
    }

    public double aplicarDescuento(Cliente cli) {

        double total = 0;
        boolean aplicaDescuentoExtra = cli.getLocalizadores().size() >= 2;

        for (Localizador local : cli.getLocalizadores()) {
            if (local.getReservas().stream().map(r -> r.getTipoReserva()).collect(Collectors.toSet()).size() == 4) {
                //if(local.getReservas().stream().map(r -> r.getTipoReserva()).collect(Collectors.toSet()).containsAll(List.of()))
                total += local.getTotal() * 0.9;
            } else if (local.getReservas().stream().map(r -> r.getTipoReserva()).filter(t -> t.equals("hotel")).count() >= 2 ||
                    local.getReservas().stream().map(r -> r.getTipoReserva()).filter(t -> t.equals("boletos")).count() >= 2) {
                total += local.getTotal() * 0.95;
            } else {
                total += local.getTotal();
            }
        }

        if (aplicaDescuentoExtra)
            return total * 0.95;
        else return total;
    }

    public int totalLocalizadores() {

        int totalLocalizadores = 0;

        for (Cliente cli : this.clientes.values()) {
            totalLocalizadores += cli.getLocalizadores().size();
        }

        return totalLocalizadores;
    }

    public int totalReservas() {

        int totalReservas = 0;

        for (Cliente cli : this.clientes.values()) {
            for (Localizador local : cli.getLocalizadores()) {
                totalReservas += local.getReservas().size();
            }

        }

        return totalReservas;
    }

    public Map<String, List<Reserva>> diccionarioReservas() {

        Map<String, List<Reserva>> mapaReservas = Map.of("hotel", new ArrayList(), "boletos", new ArrayList(),
                "comida", new ArrayList<>(), "transporte", new ArrayList<>());

        for (Cliente cli : this.clientes.values()) {
            for (Localizador local : cli.getLocalizadores()) {
                for (Reserva res : local.getReservas()) {
                    mapaReservas.get(res.getTipoReserva()).add(res);
                }
            }
        }

        return mapaReservas;
    }

    public double totalVentas() {
        double total = 0;
        for (Cliente cli : this.clientes.values()) {
            total = cli.getLocalizadores().stream().mapToDouble(Localizador::getTotal).sum();
        }

        return total;
    }

    public double promedioVentas() {
        return this.totalVentas() / this.totalLocalizadores();
    }

    public void guardarCliente(Cliente cli) {
        this.clientes.put(cli.getDNI(), cli);
    }
}
