package almacenamiento;

import cliente.Cliente;
import reservas.Reserva;

import java.util.*;
import java.util.stream.Collectors;

public class Repositorio {

    Map<Cliente, List<Localizador>> repo;

    public Repositorio() {
        repo = new HashMap<>();
    }

    public void agregarLocalizador(Cliente cliente, Localizador localizador){
        repo.computeIfAbsent(cliente, k -> new ArrayList<>());
        revisarPromos(cliente, localizador);
        repo.get(cliente).add(localizador);
    }

    public void revisarPromos(Cliente cliente, Localizador localizador){
        //Si un cliente anteriormente adquirió al menos 2 localizadores, se le descontará un 5% del total para futuras compras.
        if(repo.get(cliente).size()>1){
            localizador.setTotal(localizador.getTotal()*0.95);
        }

        //Si un cliente adquiere un paquete completo que consiste en reserva de hotel, comida, boletos de viajes, transporte, recibirá un descuento del 10% del total de la factura.
        Set<Object> reservaSet = localizador.getReservas().stream()
                .map(Object::getClass)
                .collect(Collectors.toSet());
        if(reservaSet.size()>3){
            localizador.setTotal(localizador.getTotal()*0.9);
        }
    }

    @Override
    public String toString() {
        for (Map.Entry<Cliente, List<Localizador>> entry : repo.entrySet()) {
            Cliente cliente = entry.getKey();

            System.out.println("Cliente: " + cliente.getNombre());

            for (Localizador localizador : entry.getValue()) {
                System.out.println("  Localizador: (Total: $" + localizador.getTotal()+")\n  Reservas:");

                for (Reserva reserva : localizador.getReservas()){
                    System.out.println("    "+reserva.getClass().getSimpleName() + " ($"+reserva.getPrecio()+")");
                }
            }
        }
        return "";
    }
}
