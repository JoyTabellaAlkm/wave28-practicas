public class Reserva {
    private Integer idReserva;
    private String tipoReserva;
    private double total;

    public Reserva(Integer idReserva, String tipoReserva, double total) {
        this.idReserva = idReserva;
        this.tipoReserva = tipoReserva;
        this.total = total;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public String getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(String tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva=" + idReserva +
                ", tipoReserva='" + tipoReserva + '\'' +
                ", total=" + total +
                '}';
    }
}
