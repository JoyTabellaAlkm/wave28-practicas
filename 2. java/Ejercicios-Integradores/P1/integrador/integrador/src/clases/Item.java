package clases;

public class Item {
    private int codigo;
    private String nombre;
    private int cantComprada;
    private double costoUnitario;

    public Item(int codigo, String nombre, int cantComprada, double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantComprada = cantComprada;
        this.costoUnitario = costoUnitario;
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

    public int getCantComprada() {
        return cantComprada;
    }

    public void setCantComprada(int cantComprada) {
        this.cantComprada = cantComprada;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", cantComprada=" + cantComprada +
                ", costoUnitario=" + costoUnitario +
                '}';
    }
}