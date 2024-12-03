package ejercicios.integradores.integradorSincronico;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private List<Reserva> reservas;
    private Cliente cliente;
    private Double montoTotal = 0.0;
    private Double totalConDescuento;
    public Localizador(Cliente cliente) {
        this.reservas = new ArrayList<>();
        this.cliente = cliente;
    }
    public List<Reserva> getReservas() {
        return reservas;
    }
    public Double getMontoTotal() {
        return montoTotal;
    }
    public Double getTotalConDescuento() {
        return totalConDescuento;
    }
    public void agregarReserva(Reserva reserva){
        this.reservas.add(reserva);
        montoTotal += reserva.getPrecio();
        totalConDescuento = montoTotal;
    }
    public boolean esPaquete(){
        for (ETipoReserva e : ETipoReserva.values()) {
            if (reservas.stream().noneMatch(x -> x.getTipoReserva() == e))
                return false;
        }
        return true;
    }
    public boolean sonDosReservasDeHotelODosDeViaje(){
        return (reservas.stream().filter(x -> x.getTipoReserva() == ETipoReserva.Hotel).count() >= 2 &&
                reservas.stream().filter(x -> x.getTipoReserva() == ETipoReserva.BoletosViajes).count() >= 2);
    }
    public void aplicarDescuento(){
        if (esPaquete() || sonDosReservasDeHotelODosDeViaje()) {
            this.totalConDescuento = montoTotal * 0.95;
        }
        if (cliente.tieneMasDeDosLocalizadores()) {
            this.totalConDescuento = montoTotal * 0.90;
        }
        if (this.totalConDescuento == null)
            this.totalConDescuento = montoTotal;
    }
    @Override
    public String toString() {
        return STR."Localizador{reservas=\{reservas}, cliente=\{cliente}, montoTotal=\{montoTotal}, totalConDescuento=\{totalConDescuento}}";
    }
}
