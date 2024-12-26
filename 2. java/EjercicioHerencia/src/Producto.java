//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Producto {
    String nombre;
    double precio;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String toString() {
        return "Producto: " + this.nombre + "Precio: " + this.precio;
    }

    public double calcular(int cantidadDeProductos) {
        return (double)cantidadDeProductos * this.precio;
    }
}
