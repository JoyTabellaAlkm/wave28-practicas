package ejercicios.integradores.Supermercado.modelo;

public class Item{
    private int codigo;
    private String nombre;
    private int cantidad;
    private double costo;

    public Item(int codigo, String nombre, int cantidad, double costo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getCosto() {
        return costo;
    }
}
