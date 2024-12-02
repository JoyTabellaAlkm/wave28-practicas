import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here

        List<Producto> productos = new ArrayList<Producto>();

        productos.add(new Perecedero("1", 100, 5));
        productos.add(new Perecedero("2", 100, 5));
        productos.add(new Perecedero("3", 100, 5));
        productos.add(new Perecedero("4", 100, 5));
        productos.add(new Perecedero("5", 100, 5));


        productos.add(new NoPerecedero("1", 100, "1"));
        productos.add(new NoPerecedero("2", 100, "2"));
        productos.add(new NoPerecedero("3", 100, "3"));
        productos.add(new NoPerecedero("4", 100, "4"));
        productos.add(new NoPerecedero("5", 100, "6"));

        double totalVentas = 0;

        for (Producto p: productos) {
            totalVentas += p.calcular(5);
        }

        System.out.println("El total de ventas es: " + totalVentas);

    }
}

class Producto {
    String nombre;
    double precio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    public double calcular(int cantidadDeProductos) {
        return this.precio * cantidadDeProductos;
    }
}

class Perecedero extends Producto {

    int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double valorConDescuento = super.calcular(cantidadDeProductos);
        switch (diasPorCaducar) {
            case 1:
                valorConDescuento /= 4;
                break;

            case 2:
                valorConDescuento /= 3;
                break;

            case 3:
                valorConDescuento /= 2;
                break;

            default: break;


        }
        return valorConDescuento;
    }
}

class NoPerecedero extends Producto {
    String tipo;

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "NoPerecedero{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}