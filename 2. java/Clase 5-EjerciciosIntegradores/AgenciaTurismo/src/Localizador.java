import javax.swing.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double total;

    public Localizador(Cliente cliente, List<Reserva> reservas, double total) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.total = total;
    }

    public double calcularDescuento(){
        double precioSinDescuento = calcularPrecioSinDescuento();
        double totalConDescuento = 0;
        if(RepositorioCliente.cantidadLozalizadores(cliente.getDni())>=2){
            totalConDescuento = precioSinDescuento * 0.95;
        }
        if(paqueteCompleto()){
            totalConDescuento = precioSinDescuento * 0.95;
        }
    }

    public boolean paqueteCompleto(){
        Set<String> tipoReserva = new HashSet<>();
        for(Reserva r : reservas){
            tipoReserva.add(r.getTipo());
        }
        if(tipoReserva.size() == 4){
            return true;
        } else {
            return false;
        }
    }

    public double calcularPrecioSinDescuento(){
        double precio = 0;
        for(Reserva r : reservas){
            precio += r.getCostoTotal();
        }
        return precio;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
