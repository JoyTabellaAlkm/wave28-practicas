import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Localizador {
    //cliente, el total y la reserva
    private int id;
    private Cliente cliente;
    private List<Reserva> reservas;
    private double costoTotal;

    public Localizador(int id,Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.costoTotal = calcularCostoInicial(reservas);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String,Long> clasificacionReservas(){
        return reservas.stream().collect(Collectors.groupingBy(r -> r.getTipo(), Collectors.counting()));
    }

    public double calcularCostoInicial(List<Reserva> reservas){
        double costo = reservas.stream().mapToDouble(reserva -> reserva.getCosto()).sum();
        Map<String,Long> conteoDeTipoDeReservas = clasificacionReservas();

        if(conteoDeTipoDeReservas.size()==4){
            costo *= .9;
        }

        if(conteoDeTipoDeReservas.getOrDefault("HOTEL",0L)>=2 || conteoDeTipoDeReservas.getOrDefault("VIAJE",0L)>=2){
            costo *= .95;
       }
        
        return costo;
    }

    public void aplicarDescuentos(boolean dosOMas){
        if(dosOMas){
            costoTotal *= 0.95;
        }
    };


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

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Override
    public String toString() {
        return "Localizador [cliente=" + cliente + ", reservas=" + reservas + ", costoTotal=" + costoTotal + ", id="
                + id + "]";
    }
    
}