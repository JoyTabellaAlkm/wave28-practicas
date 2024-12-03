package ejercicios_integradores.agencia_turismo.domain.reserva;

public class ReservaGenerica implements Reservable {
    private String tipo;
    private Double precio;
    private Integer cantidad;

    public ReservaGenerica(Integer cantidad, Double precio, String tipo) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.tipo = tipo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public Double calcularPrecio() {
        switch(this.tipo) {
            case "hotel", "boleto" -> {
                if(this.cantidad >= 2) {
                    return (this.precio * this.cantidad) * 0.95;
                }
                return this.precio * this.cantidad;
            }
            case "comida", "transporte" -> {
                return this.precio * this.cantidad;
            }
            default -> {
                System.out.println("No se puede calcular el precio para el tipo: " + this.tipo);
                return 0.0;
            }
        }
    }

    @Override
    public String toString() {
        return "ReservaGenerica{" +
                "cantidad=" + cantidad +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio +
                '}';
    }
}
