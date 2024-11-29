public class Poducto {
    private String nombre;
    private double precio;

    public Poducto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Poducto: " + "nombre= " + nombre + ", precio= " + precio + ' ';
    }

    public int calcular(int cantidadDeProductos) {
        return ((int) precio) * cantidadDeProductos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
