package Modelo.Reserva;

public class ReservaComida extends Reserva{
    private Integer noPlatos;

    public ReservaComida(Integer noPlatos) {
        this.noPlatos = noPlatos;
    }

    public ReservaComida(String detalle, Double costo, Integer noPlatos) {
        super(detalle, costo);
        this.noPlatos = noPlatos;
    }

    public Integer getNoPlatos() {
        return noPlatos;
    }

    public void setNoPlatos(Integer noPlatos) {
        this.noPlatos = noPlatos;
    }

    @Override
    public String toString() {
        return super.toString() +
                "ReservaComida{" +
                "noPlatos=" + noPlatos +
                '}';
    }
}
