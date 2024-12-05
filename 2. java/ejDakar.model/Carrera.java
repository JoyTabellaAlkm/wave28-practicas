package dakar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Carrera {

    private double distancia;
    private double premioUsd;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;
    private List<Vehiculo> vehiculos = new ArrayList<>();

    public Carrera(double distancia, double premioUsd, String nombre, int cantidadVehiculosPermitidos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto, List<Vehiculo> vehiculos) {
        this.distancia = distancia;
        this.premioUsd = premioUsd;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
        this.vehiculos = vehiculos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(vehiculos.size() < cantidadVehiculosPermitidos) {
            Auto auto = new Auto(velocidad, aceleracion,anguloDeGiro,patente);
            this.vehiculos.add(auto);
            System.out.println("Se agregó el auto a la carrera");
        } else {
            System.out.println("No hay espacio en la carrera");
        }
    };

    public void darDeAltaMoto(double velocidad, double aceleracion,double anguloDeGiro,String patente) {
        if(vehiculos.size() < cantidadVehiculosPermitidos) {
            Moto moto = new Moto(velocidad, aceleracion,anguloDeGiro,patente);
            this.vehiculos.add(moto);
            System.out.println("Se agregó la moto a la carrera");
        } else {
            System.out.println("No hay espacio en la carrera");
        }
    };

    public Vehiculo encontrarGanador() {

        Optional<Vehiculo> unVehiculo =  vehiculos.stream().max(Comparator
                .comparing(vehiculo -> -(vehiculo.getVelocidad() * vehiculo.getAceleracion()) / (vehiculo.getAnguloGiro() * (vehiculo.getPeso() - 100 * vehiculo.getCantidadRuedas()))));

        return unVehiculo.orElse(null);
    }

    public void eliminarVehiculo(Vehiculo unVehiculo){
        Optional<Vehiculo> elVehiculo = this.vehiculos.stream()
                .filter(vehiculo -> vehiculo.equals(unVehiculo)).findFirst();

        elVehiculo.ifPresent(vehiculo -> vehiculos.remove(vehiculo));
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        Optional<Vehiculo> elVehiculo = this.vehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(unaPatente)).findFirst();

        elVehiculo.ifPresent(vehiculo -> vehiculos.remove(vehiculo));
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioUsd() {
        return premioUsd;
    }

    public void setPremioUsd(double premioUsd) {
        this.premioUsd = premioUsd;
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

    public SocorristaAuto getSocorristaAuto() {
        return socorristaAuto;
    }

    public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }

    public SocorristaMoto getSocorristaMoto() {
        return socorristaMoto;
    }

    public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void socorrerAuto(String patente) {
        Optional<Vehiculo> vehiculo =  vehiculos.stream()
                .filter(v -> v.getPatente().equals(patente)).findFirst();

        if(vehiculo.isPresent() && vehiculo.get() instanceof Auto) {
            socorristaAuto.socorrer((Auto) vehiculo.get());
        } else {
            System.out.println("No se encontró el auto con la patente indicada");
        }
    }

    public void socorrerMoto(String patente) {
        Optional<Vehiculo> vehiculo =  vehiculos.stream()
                .filter(v -> v.getPatente().equals(patente)).findFirst();

        if(vehiculo.isPresent() && vehiculo.get() instanceof Moto) {
            socorristaMoto.socorrer((Moto) vehiculo.get());
        } else {
            System.out.println("No se encontró la moto con la patente indicada");
        }
    }
}
