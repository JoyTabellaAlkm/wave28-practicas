package Clases;

public class Item {

    private int codigo;
    private String nombre;
    private int cantidadComprada;
    private double precioUnitario;

    public Item(double precioUnitario, int cantidadComprada, String nombre, int codigo) {
        this.precioUnitario = precioUnitario;
        this.cantidadComprada = cantidadComprada;
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCantidadComprada() {
        return cantidadComprada;
    }
    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }
    public double getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", cantidadComprada=" + cantidadComprada +
                ", precioUnitario=" + precioUnitario +
                '}';
    }
}
