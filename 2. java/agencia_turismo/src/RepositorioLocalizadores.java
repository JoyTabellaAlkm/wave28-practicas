import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepositorioLocalizadores  {
    private HashMap<Integer, List<Localizador>> localizadores;

    public RepositorioLocalizadores(){
        this.localizadores = new HashMap<>();
    }
    public List<Localizador> buscarPorId(Integer id) {
        return localizadores.get(id);
    }

    public void agregarLocalizador(Localizador localizador){
        localizadores.computeIfAbsent(localizador.getCliente().getDni(),k->new ArrayList<>()).add(localizador);
    }
    public Integer cantidadLocalizadores(){
        return localizadores.values().stream().mapToInt(List::size).sum();
    }

    public Integer cantidadReservasPorCliente(List<Localizador> l){
        return l.stream().mapToInt(loc->loc.getReservas().size()).sum();
    }
    public Integer cantidadReservas(){
        return localizadores.values().stream().mapToInt(this::cantidadReservasPorCliente).sum();
    }
    public Map<String,List<Reserva>> reservasPorTipo(){
        return localizadores.values().stream().flatMap(List::stream).flatMap(l->l.getReservas().stream()).collect(Collectors.groupingBy(Reserva::getTipo));
    }

    public Double totalVentas(){
        return localizadores.values().stream().flatMap(List::stream).mapToDouble(l->Descuento.calcularDescuento(l,this)).sum();
    }
     public Double promeioVentas(){
        return localizadores.values().stream().flatMap(List::stream).mapToDouble(l->Descuento.calcularDescuento(l,this)).average().getAsDouble();
    }
}
