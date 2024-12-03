import java.util.List;

public class Localizador {
   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public Cliente getCliente() {
      return cliente;
   }

   public void setCliente(Cliente cliente) {
      this.cliente = cliente;
   }

   public List<Reserva> getReservas() {
      return reservas;
   }

   public void setReservas(List<Reserva> reservas) {
      this.reservas = reservas;
   }

   public Double getTotal() {
      return total;
   }

   public void setTotal(Double total) {
      this.total = total;
   }

   Integer id;
   Cliente cliente;
   List<Reserva> reservas;
   Double total;
}
