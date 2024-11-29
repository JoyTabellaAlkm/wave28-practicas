public class NoPerecedero extends Producto {
    private String tipo;

    // Constructor
    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    // Getters y Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Sobreescribir el método calcular
    @Override
    public double calcular(int cantidadDeProductos) {
        return super.calcular(cantidadDeProductos);
    }

    // Método toString
    @Override
    public String toString() {
        return super.toString() + ", Tipo=" + tipo;
    }
}
