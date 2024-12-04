import java.util.List;

public class Localizador {
   private Integer id;
   private Cliente cliente;
   private List<Reserva> reservas;


   public Localizador(Integer id, Cliente cliente, List<Reserva> reservas) {
      this.id = id;
      this.cliente = cliente;
      this.reservas = reservas;
   }

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
      return reservas.stream().mapToDouble(Reserva::getCosto).sum();
   }

}
