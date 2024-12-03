import java.util.List;

public class Localizador {

    private Integer idLocalizador;
    private Cliente cli;
    private double total;
    private List<Reserva> reservas;

    public Localizador(Integer idLocalizador, Cliente cli, double total, List<Reserva> reservas) {
        this.idLocalizador = idLocalizador;
        this.cli = cli;
        this.total = total;
        this.reservas = reservas;
    }

    public Integer getIdLocalizador() {
        return idLocalizador;
    }

    public void setIdLocalizador(Integer idLocalizador) {
        this.idLocalizador = idLocalizador;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public  void imprimirLocalizador(){
        for (Reserva reserva: this.reservas){
            System.out.println(reserva.toString());
        }
    }

    public  double aplicarDescuento(double porcentaje){
        //System.out.println("El descuento para este localizador es: " + this.total * porcentaje);
        return this.total * porcentaje;
    }
}