package Entidades.Productos;

public abstract class Producto {
    private double costo;
    private String nombre;
    // GETS & SETS
    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
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
        return "[Producto] " +
                "Costo: " + costo +
                ", Nombre: " + nombre;
    }
}
