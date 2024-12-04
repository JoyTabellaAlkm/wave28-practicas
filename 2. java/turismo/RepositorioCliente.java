
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioCliente implements IRepositorio<Localizador>{
    Map<String, List<Localizador>> reservasCliente;

    public RepositorioCliente() {
        reservasCliente = new HashMap<>();
    }

    @Override
    public void almacenar(Localizador elem) {
        String dniCliente = elem.getCliente().getDni();

        if (!reservasCliente.containsKey(dniCliente)) {
            reservasCliente.put(dniCliente, new ArrayList<>());
        }

        double descuento = getDescuento(dniCliente, elem);
        if (descuento != 0.0) {
            elem.setTotal(elem.getTotal() - (elem.getTotal() * descuento));
        }

        List<Localizador> reservasActuales = buscarReservas(dniCliente);
        reservasActuales.add(elem);
        reservasCliente.put(dniCliente, reservasActuales);
    }

    /*
    @Override
    public Localizador buscarReserva(String dni) {
        List<Localizador> localizadoresCliente = reservasCliente.get(dni);
        if(localizadoresCliente == null) {
            return null;
        }

        localizadoresCliente.stream().filter(localizador -> )
    }
*/
    @Override
    public List<Localizador> buscarReservas(String dni) {
        return reservasCliente.get(dni);
    }

    private double getDescuento(String dni, Localizador localizador) {
        if(!existeCliente(dni)) {
            return 0.0;
        }

        if(buscarReservas(dni).size() >= 2) {
            return 0.05;
        }

        if(localizador.esPaqueteCompleto()) {
            return 0.10;
        }

        if(localizador.tieneNTipoReservas(2, TiposReserva.HOTEL) || localizador.tieneNTipoReservas(2, TiposReserva.BOLETO_VIAJE)) {
            return 0.05;
        }

        return 0.0;
    }

    public boolean existeCliente(String dni) {
        return reservasCliente.containsKey(dni);
    }

}
