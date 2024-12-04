package Model;

public class Producto {
    private Long codigo;
    private String nombre;
    private int cantidadComprada;
    private double costoUnitario;

    public Producto(Long codigo, String nombre, int cantidadComprada, double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadComprada = cantidadComprada;
        this.costoUnitario = costoUnitario;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    @Override
    public String toString() {
        return "Model.Producto{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cantidadComprada=" + cantidadComprada +
                ", costoUnitario=" + costoUnitario +
                '}';
    }
}
