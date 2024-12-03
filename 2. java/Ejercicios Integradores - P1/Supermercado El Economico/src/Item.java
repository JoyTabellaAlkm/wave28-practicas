public class Item {
    private String codigo;
    private String nombre;
    private Double cantidad;
    private Double CostoPorUnidad;

    public Item(String codigo, String nombre, Double cantidad, Double costoPorUnidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        CostoPorUnidad = costoPorUnidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCostoPorUnidad() {
        return CostoPorUnidad;
    }

    public void setCostoPorUnidad(Double costoPorUnidad) {
        CostoPorUnidad = costoPorUnidad;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", CostoPorUnidad=" + CostoPorUnidad +
                '}';
    }
}
