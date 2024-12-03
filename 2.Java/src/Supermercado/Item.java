package Supermercado;

public class Item {

    private int codigo;
    private String nombre;
    private int cantCompra;
    private double precioUnitario;
    private double precioTotal;

    public Item(int codigo, String nombre, int cantCompra, double precioUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantCompra = cantCompra;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioUnitario * cantCompra;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
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

    public int getCantCompra() {
        return cantCompra;
    }

    public void setCantCompra(int cantCompra) {
        this.cantCompra = cantCompra;
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
                ", cantCompra=" + cantCompra +
                ", precioUnitario=" + precioUnitario +
                '}';
    }
}
