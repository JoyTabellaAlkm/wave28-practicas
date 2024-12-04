import java.util.List;
import java.util.stream.Collectors;

public class Descuento {
    public static Double calcularDescuento(Localizador localizador,RepositorioLocalizadores repositorio){
        Double descuento = localizador.getTotal();
        List <Reserva> reservasHotel = localizador.getReservas().stream().filter(r->r.getTipo().equals("hotel")).toList();
         List <Reserva> reservasBoleto = localizador.getReservas().stream().filter(r->r.getTipo().equals("boleto")).toList();
        if(reservasHotel.size()>=2){
           descuento -= reservasHotel.stream().mapToDouble(Reserva::getCosto).reduce(0.0,Double::sum) * 0.05;
        }
        if(reservasBoleto.size()>=2){
           descuento -= reservasBoleto.stream().mapToDouble(Reserva::getCosto).reduce(0.0,Double::sum) * 0.05;
        }
        Integer nroLocalizador = repositorio.buscarPorId(localizador.getCliente().getDni()).indexOf(localizador);
        if(nroLocalizador > 2 ){
            descuento *= 0.95;
        }
        if(localizador.getReservas().stream().map(r->r.getTipo()).collect(Collectors.toSet()).size()==4){
            descuento *= 0.90;
        }
        return descuento;
    }

}