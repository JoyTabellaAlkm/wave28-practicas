import Modelo.*;
import Modelo.Reserva.Reserva;
import Modelo.Reserva.ReservaHotel;
import Modelo.Reserva.ReservaViaje;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizador {
    private List<Localizador> localizadores = new ArrayList<>();
    /*public Localizador findLocalizadorPorDNI(String dni){
        try{
            List<Localizador> localizador = localizadores.stream().filter(c -> c.getDni().equals(dni)).toList();
            if(!localizador.isEmpty()){
                return localizador.get(0);
            }
            return null;
        }catch (Exception e){
            return null;
        }
    }*/
    public Localizador addLocalizador (List<Reserva> reservas, Cliente cliente, boolean esPaqueteCompleto){
        Localizador localizador = new Localizador();
        localizador.setCliente(cliente);
        localizador.setReservas(reservas);
        localizador.setEsPaqueteCompleto(esPaqueteCompleto);

        localizador.calcularTotal(calcularDescuento(localizador));
        localizadores.add(localizador);
        System.out.println(localizador.detalle());
        return localizador;
    }
    public Long contarLocalizadoresPorDNI(String dni){
        return localizadores.stream().filter(l -> l.getCliente().getDni().equals(dni)).count();
    }
    public Double calcularDescuento(Localizador localizador){
        Double descuento = 0.0;
        Long localizadoresAnteriores = contarLocalizadoresPorDNI(localizador.getCliente().getDni());

        if(localizadoresAnteriores >= 2){
            descuento = 0.05;
        }

        Long reservasHotel = localizador.getReservas().stream().filter(r -> (r instanceof ReservaHotel)).count();
        Long reservasViaje = localizador.getReservas().stream().filter(r -> (r instanceof ReservaViaje)).count();

        if(reservasHotel >= 2 || reservasViaje >= 2){
            descuento = 0.05;
        }

        if(localizador.isEsPaqueteCompleto()){
            descuento = 0.1;
        }

        return descuento;
    }

    public Integer cantidadLocalizadoresVendido(){
        return localizadores.size();
    }
    public Integer cantidadTotalReservas(){
        return localizadores.stream().mapToInt(l -> l.getReservas().size()).sum();
    }
    public Double totalVentas(){
        return localizadores.stream().mapToDouble(l -> l.getTotal()).sum();
    }
    public Double promedioVentas(){
        return localizadores.stream().mapToDouble(l -> l.getTotal()).average().orElse(0.0);
    }
}