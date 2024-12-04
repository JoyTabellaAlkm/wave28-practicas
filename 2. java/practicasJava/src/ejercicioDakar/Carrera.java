package ejercicioDakar;

import java.util.ArrayList;
import java.util.Comparator;

public class Carrera {
    private double distancia;
    private double premioDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private ArrayList<Vehiculo> vehiculos;

    public Carrera() {
    }

    public Carrera(double distancia, double premioDolares, String nombre, int cantidadVehiculosPermitidos, ArrayList<Vehiculo> vehiculos) {
        this.distancia = distancia;
        this.premioDolares = premioDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.vehiculos = vehiculos;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioDolares() {
        return premioDolares;
    }

    public void setPremioDolares(double premioDolares) {
        this.premioDolares = premioDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadVehiculosPermitidos() {
        return cantidadVehiculosPermitidos;
    }

    public void setCantidadVehiculosPermitidos(int cantidadVehiculosPermitidos) {
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioDolares=" + premioDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadVehiculosPermitidos=" + cantidadVehiculosPermitidos +
                ", vehiculos=" + vehiculos +
                '}';
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloGiro, String patente) {

        if (vehiculos.size() < cantidadVehiculosPermitidos) {
            vehiculos.add(new Auto(velocidad, aceleracion, anguloGiro, patente));
            System.out.println("Se agregó un auto");
        } else {
            System.out.println("No se pueden agregar más autos.");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloGiro, String patente) {

        if (vehiculos.size() < cantidadVehiculosPermitidos) {
            vehiculos.add(new Moto(velocidad, aceleracion, anguloGiro, patente));
            System.out.println("Se agregó un moto");
        } else {
            System.out.println("No se pueden agregar más motos.");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);

    }

    public void eliminarVehiculo(String patente) {
        Vehiculo vehiculo = vehiculos.stream().filter(x -> x.getPatente().equalsIgnoreCase(patente)).findFirst().orElse(null);

        if (vehiculo != null) {
            eliminarVehiculo(vehiculo);
        } else {
            System.out.println("No se encontró la patente");
        }

    }

    public void calcularGanador() {
        Vehiculo vehiculoGanador = vehiculos.stream()
                .max(Comparator.comparingDouble(Vehiculo::calcularValor))
                .orElse(null);
        System.out.println(vehiculoGanador.toString());
    }

}
