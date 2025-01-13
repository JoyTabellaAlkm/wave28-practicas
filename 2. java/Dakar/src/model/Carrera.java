package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            Auto nuevoAuto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            listaDeVehiculos.add(nuevoAuto);
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            Moto nuevaMoto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            listaDeVehiculos.add(nuevaMoto);
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        listaDeVehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
    }

    public Vehiculo calcularGanador() {
        double maxValor = Double.MIN_VALUE;
        Vehiculo ganador = null;
        for (Vehiculo vehiculo : listaDeVehiculos) {
            double valor = vehiculo.getVelocidad() * 0.5 * vehiculo.getAceleracion() /
                    (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - (vehiculo.getRuedas() * 100)));
            if (valor > maxValor) {
                maxValor = valor;
                ganador = vehiculo;
            }
        }
        return ganador;
    }

    public void socorrerAuto(String patente) {
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo instanceof Auto && vehiculo.getPatente().equals(patente)) {
                socorristaAuto.socorrer((Auto) vehiculo);
                return;
            }
        }
    }

    public void socorrerMoto(String patente) {
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo instanceof Moto && vehiculo.getPatente().equals(patente)) {
                socorristaMoto.socorrer((Moto) vehiculo);
                return;
            }
        }
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

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public Vehiculo determinarGanador() {
        double maxValor = Double.MIN_VALUE;
        Vehiculo ganador = null;

        for (Vehiculo vehiculo : listaDeVehiculos) {
            double valor = vehiculo.getVelocidad() * 0.5 * vehiculo.getAceleracion() /
                    (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - (vehiculo.getRuedas() * 100)));

            if (valor > maxValor) {
                maxValor = valor;
                ganador = vehiculo;
            }
        }
        return ganador;
    }
}
