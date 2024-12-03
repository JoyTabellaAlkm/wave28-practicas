import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LocalizadorService {
    private List<Localizador> localizadores;

    public LocalizadorService(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public int cantidadLocalizadores(){
        return this.localizadores.size();
    }

    public int cantidadReservas(){
        return localizadores.stream()
                .flatMapToInt(x -> IntStream.of(x.getReservas().size()))
                .sum();

    }

    public Map<ETipoReserva,List<Reserva>> obtenerMapaReservasPorTipo(){
        Map<ETipoReserva,List<Reserva>> mapaReservasPorTipo = Map.of(
                ETipoReserva.Hotel,new ArrayList<>(),
                ETipoReserva.Transporte, new ArrayList<>(),
                ETipoReserva.BoletosViajes, new ArrayList<>(),
                ETipoReserva.Comida, new ArrayList<>()
        );

        localizadores.stream()
                .flatMap(localizador -> localizador.getReservas().stream())  // "Aplanamos" la lista de reservas
                .forEach(reserva -> mapaReservasPorTipo.get(reserva.getTipoReserva()).add(reserva));

        return mapaReservasPorTipo;
    }
}
