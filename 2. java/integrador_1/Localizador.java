package integrador_1;

import java.util.List;
import java.util.ArrayList;

public class Localizador {
 private Cliente cliente;
 List<Reserva> reservas = new ArrayList<Reserva>();

 Localizador(Cliente cliente){
  this.cliente = cliente;
 }

 void agregarReserva(Reserva reserva){
  reservas.add(reserva);
 }

 int getClienteId(){
  return cliente.getId();
 }

 void imprimirLocalizador(){
  for(Reserva reserva : reservas){
    System.out.println(reserva);
  }
 }
}
