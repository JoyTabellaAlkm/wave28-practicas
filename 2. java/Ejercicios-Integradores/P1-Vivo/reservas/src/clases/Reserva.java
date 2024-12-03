package clases;

public class Reserva {
    private String tipo;
    private double precio;

    public Reserva(String tipo, double precio) {
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "tipo='" + tipo + '\'' +
                ", precio=" + precio +
                '}';
    }
}
