package Dakar;


import java.util.ArrayList;

public class Carrera {
    private double distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantVehPermitidos;
    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private SocorristaAuto socorristaAuto = new SocorristaAuto();
    private SocorristaMoto socorristaMoto = new SocorristaMoto();

    public Carrera(double distancia, int premioEnDolares, String nombre, int cantVehPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantVehPermitidos = cantVehPermitidos;

    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(vehiculos.size() < cantVehPermitidos){
            Vehiculo auto = new Auto(velocidad,aceleracion,anguloDeGiro,patente);
            vehiculos.add(auto);
        }else{
            System.out.println("No hay cupos disponibles para esta carrera");
        }
    }
    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(vehiculos.size() < cantVehPermitidos){
            Vehiculo moto = new Moto(velocidad,aceleracion,anguloDeGiro,patente);
            vehiculos.add(moto);
        }else
        System.out.println("No hay cupos disponibles para esta carrera");
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente){
        vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
    }
    /*
    public void definirGanador(){
        double valorMaximo = 0;
        Vehiculo vehiculoGanador = null;
        for(Vehiculo vehiculo : vehiculos){
            double valorVehiculo = calcularValor(vehiculo);
            if(valorVehiculo > valorMaximo){
                valorMaximo = valorVehiculo;
                vehiculoGanador = vehiculo;
            }
        }
        System.out.println("El vehiculo Ganador es: "+vehiculoGanador);
    }*/
    public void definirGanador(){
       Vehiculo vehiculo =  vehiculos.stream().max((v1,v2)->Double.compare(calcularValor(v1),calcularValor(v2))).orElse(null);
        System.out.println("El vehiculo Ganador es: "+vehiculo);
    }

    public static double calcularValor(Vehiculo vehiculo){
        return  vehiculo.getVelocidad()*0.5*vehiculo.getAceleracion()/(vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()-vehiculo.getRuedas()*100));
    }

    public void socorrerAuto(String patente){
        vehiculos.stream().filter(v -> v instanceof Auto && v.getPatente().equals(patente))
                .findFirst()
                .ifPresent(v->socorristaAuto.socorrer(patente));
    }

    public void socorrerMoto(String patente) {
        vehiculos.stream().filter(v -> v instanceof Moto && v.getPatente().equals(patente))
                .findFirst()
                .ifPresent(v->socorristaMoto.socorrer(patente));
    }

}
