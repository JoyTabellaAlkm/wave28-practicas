package ejercicios_integradores.supermercado_el_economico;

public class Item {
    private String codigo;
    private String nombre;
    private Integer cantidad;
    private Double costo;

    public Item(Integer cantidad, String codigo, Double costo, String nombre) {
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.costo = costo;
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Item{" +
                "cantidad=" + cantidad +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", costo=" + costo +
                '}';
    }
}
