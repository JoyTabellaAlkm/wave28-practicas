public class Reserva {
    private double precio;
    private ETipoReserva tipoReserva;
    private Cliente cliente;

    public Reserva(double precio,
                   ETipoReserva tipoReserva,
                   Cliente cliente) {
        this.precio = precio;
        this.tipoReserva = tipoReserva;
        this.cliente = cliente;
    }

    public double getPrecio() {
        return precio;
    }

    public ETipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
