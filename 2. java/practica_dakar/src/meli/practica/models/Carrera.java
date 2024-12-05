package practica_dakar.src.meli.practica.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private List<Vehiculo> vehiculos = new ArrayList<>();
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(int velocidad, int aceleracion, double anguloDeGiro, String patente) {
        if(hayCupo()) {
            vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
            System.out.println("Se ha agregado el vehiculo con patente: " + patente);
        }else{
            System.out.println("No hay cupo para mas vehiculos");
        }
    }
    public void darDeAltaMoto(int velocidad, int aceleracion, double anguloDeGiro, String patente) {
        if(hayCupo()) {
            vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
            System.out.println("Se ha agregado la moto con patente: " + patente);
        }else{
            System.out.println("No hay cupo para mas vehiculos");
        }
    }

    private boolean hayCupo() {
        return vehiculos.size() < cantidadVehiculosPermitidos;
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }
    public void eliminarVehiculoConPatente(String patente) {
        Optional<Vehiculo> vehiculoAEliminar = vehiculos.stream().filter(v -> v.getPatente().equals(patente)).findFirst();
        if (vehiculoAEliminar.isPresent()) {
            vehiculos.remove(vehiculoAEliminar.get());
            System.out.println("Vehiculo eliminado exitosamente con patente " + patente);
        } else {
            System.out.println("El vehiculo a eliminar no existe");
        }
    }

    public Vehiculo definirGanador() {
        Optional<Vehiculo> vehiculoMayorValor = vehiculos.stream()
                .max(Comparator.comparingDouble(this::calculoGanador));

        return vehiculoMayorValor.orElse(null);

    }

    private double calculoGanador(Vehiculo v) {
        return (v.getVelocidad() * (0.5 * v.getAceleracion())) / (v.getAnguloDeGiro()*(v.getPeso()-v.getRuedas()* 100));
    }

    private void socorrerAuto(String patente) {
        getSocorristaAuto().socorrer(getVehiculoPorPatente(patente));
    }

    private void socorrerMoto(String patente) {
        getSocorristaMoto().socorrer(getVehiculoPorPatente(patente));
    }

    private Vehiculo getVehiculoPorPatente(String patente) {
        return vehiculos.
                stream().
                filter(v -> v.getPatente().equals(patente)).
                findFirst().orElse(null);
    }
    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadVehiculosPermitidos=" + cantidadVehiculosPermitidos +
                ", vehiculos=" + vehiculos +
                '}';
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

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
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

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
