package Vehiculos;

public class Vehiculo {
    String modelo;
    String marca;
    int precio;

    public Vehiculo(String marca, String modelo, int precio) {
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public int getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                marca + ' ' +
                modelo + " $" +
                precio +
                '}';
    }
}
