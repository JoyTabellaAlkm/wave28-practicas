package Dakar;


import java.util.ArrayList;

public class Carrera {
    private double distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantVehPermitidos;
    private ArrayList<Vehiculo> vehiculos;

    public Carrera(double distancia, int premioEnDolares, String nombre, int cantVehPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantVehPermitidos = cantVehPermitidos;
        this.vehiculos = new ArrayList<>();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(vehiculos.size() < cantVehPermitidos){
            Vehiculo auto = new Auto(velocidad,aceleracion,anguloDeGiro,patente);
            this.vehiculos.add(auto);
        }
    }
    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(vehiculos.size() < cantVehPermitidos){
            Vehiculo moto = new Moto(velocidad,aceleracion,anguloDeGiro,patente);
            this.vehiculos.add(moto);
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente){
        vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
    }

    public void ganador(){
        double resultado = 0;
        for(Vehiculo vehiculo : vehiculos){
            double resultadoFormula = vehiculo.getAceleracion()*0.5*vehiculo.getAceleracion()/(vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()-vehiculo.getRuedas()*100));
            if(resultadoFormula > resultadoFormula){
                resultado = resultadoFormula;

            }
        }
    }

}
