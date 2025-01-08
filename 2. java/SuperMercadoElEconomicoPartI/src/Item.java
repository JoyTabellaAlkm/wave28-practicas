public class Item {
    private int codigo;
    private String nombre;
    private int cantidad;
    private double costoUnitario;

    public Item(int codigo, String nombre, int cantidad, double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
    }

    public double totalCosto() {
        return cantidad * costoUnitario;
    }

    @Override
    public String toString(){
        return "Item{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", costoUnitario=" + costoUnitario +
                '}';
    }
}
