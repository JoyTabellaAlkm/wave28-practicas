public class Item {
    private String codigo;
    private String nombre;
    private double costo;
    private int cantidadComprada;

    public Item(String codigo, String nombre, double costo, int cantidadComprada) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.costo = costo;
        this.cantidadComprada = cantidadComprada;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCosto() {
        return costo;
    }

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public double getMontoTotal(){
        return this.cantidadComprada * this.costo;
    }
}
