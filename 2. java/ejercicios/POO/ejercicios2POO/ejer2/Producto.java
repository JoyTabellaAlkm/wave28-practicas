package ejercicios.POO.ejercicios2POO.ejer2;

public class Producto {
    private String nombre;
    private double precio;

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return STR."Producto{nombre='\{nombre}', precio=\{precio}}";
    }

    public double calcular(int cantidadDeProductos){
        return this.precio * cantidadDeProductos;
    }
}
