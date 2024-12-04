package Classes;

import java.util.*;

public class Carrera {
    // Atributes
    private double distancia;
    private double premio;
    private String nombre;
    private int cantVehiculosMax;
    private Set<Vehiculo> listaVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    // Constructors

    public Carrera(double distancia, double premio, String nombre, int cantVehiculosMax) {
        this.distancia = distancia;
        this.premio = (double)premio;
        this.nombre = nombre;
        this.cantVehiculosMax = cantVehiculosMax;
        this.listaVehiculos = new HashSet<>();
        this.socorristaAuto = new SocorristaAuto(200, 20, 35, "FFF000");
        this.socorristaMoto = new SocorristaMoto(220, 20, 35, "AAA111");
    }

    // Getters y Setters
    public double getDistancia() {return distancia;}
    public void setDistancia(double distancia) {this.distancia = distancia;}

    public double getPremio() {return premio;}
    public void setPremio(double premio) {this.premio = premio;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public int getCantVehiculos() {return cantVehiculosMax;}
    public void setCantVehiculos(int cantVehiculos) {this.cantVehiculosMax = cantVehiculos;}

    public Set<Vehiculo> getVehiculos() {return listaVehiculos;}

    // Methods
    public void darDeAltaMoto(double velocidad, double aceleracion, int anguloDeGiro, String patente){
        System.out.println(listaVehiculos.size());
        if(listaVehiculos.size() < cantVehiculosMax){
            listaVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        }else{
            System.out.println("Se llegó al máximo de vehículos en esta carrera");
        }
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, int anguloDeGiro, String patente){
        if((long) listaVehiculos.size() < cantVehiculosMax){
            listaVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        }else{
            System.out.println("Se llegó al máximo de vehículos en esta carrera");
        }
    }

    public boolean eliminarVehiculo(Vehiculo vehiculo){
        return listaVehiculos.remove(vehiculo);
    }

    public boolean eliminarVehiculoConPatente(String patente){
        Vehiculo vehiculoAEliminar = listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .findFirst()
                .orElse(null);
        if(vehiculoAEliminar != null){
            return listaVehiculos.remove(vehiculoAEliminar);
        }
        return false;
    }

    public Vehiculo defineGanador(){
        return listaVehiculos.stream()
                .max((v1, v2) -> Double.compare(v1.calculaValor(), v2.calculaValor()))
                .orElse(null);
    }

    public void socorrerAuto(String patente){
        Auto autoASocorrer = (Auto)listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .findFirst()
                .orElse(null);
        if(autoASocorrer != null){
            socorristaAuto.socorrer(autoASocorrer);
        }
    }

    public void socorrerMoto(String patente){
        Moto motoASocorrer = (Moto)listaVehiculos.stream()
                .filter(moto -> moto.getPatente().equals(patente))
                .findFirst()
                .orElse(null);
        System.out.println(listaVehiculos.stream().filter(moto -> moto.getPatente().equals(patente)).findFirst());
        if(motoASocorrer != null){
            socorristaMoto.socorrer(motoASocorrer);
        }
    }
}
