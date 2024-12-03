package integrador_1;

import java.util.List;
import java.util.ArrayList;

public class Localizador {
 Cliente cliente;
 List<Reserva> reservas = new ArrayList<Reserva>();

 Localizador(Cliente cliente){
  this.cliente = cliente;
 }

 void agregarReserva(Reserva reserva){
  reservas.add(reserva);
 }
}
