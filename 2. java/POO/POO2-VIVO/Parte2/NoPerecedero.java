public class NoPerecedero extends Producto {
    private String tipo;

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Producto NO Perecedero: " + this.getNombre() + " Precio: " + this.getPrecio() + " Tipo: " + this.tipo;
    }
}
