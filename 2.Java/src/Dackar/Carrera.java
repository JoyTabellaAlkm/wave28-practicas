package Dackar;

import java.util.Comparator;
import java.util.List;

public class Carrera {
    private Double distancia;
    private Double premioDolares;
    private String nombre;
    private Integer cantVehiculosPermitidos;
    private List<Vehiculo> listaVehiculo;

    public Carrera(Double distancia, Double premioDolares, String nombre, Integer cantVehiculosPermitidos, List<Vehiculo> listaVehiculo) {
        this.distancia = distancia;
        this.premioDolares = premioDolares;
        this.nombre = nombre;
        this.cantVehiculosPermitidos = cantVehiculosPermitidos;
        this.listaVehiculo = listaVehiculo;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getPremioDolares() {
        return premioDolares;
    }

    public void setPremioDolares(Double premioDolares) {
        this.premioDolares = premioDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantVehiculosPermitidos() {
        return cantVehiculosPermitidos;
    }

    public void setCantVehiculosPermitidos(Integer cantVehiculosPermitidos) {
        this.cantVehiculosPermitidos = cantVehiculosPermitidos;
    }

    public List<Vehiculo> getListaVehiculo() {
        return listaVehiculo;
    }

    public void setListaVehiculo(List<Vehiculo> listaVehiculo) {
        this.listaVehiculo = listaVehiculo;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioDolares=" + premioDolares +
                ", nombre='" + nombre + '\'' +
                ", cantVehiculosPermitidos=" + cantVehiculosPermitidos +
                ", listaVehiculo=" + listaVehiculo +
                '}';
    }

    public void darDeAltaVehiculo(Vehiculo vehiculo){
        if(listaVehiculo.size() < cantVehiculosPermitidos ){
            listaVehiculo.add(vehiculo);
        }else{
            System.out.println("No hay cupo para agregar un nuevo vehiculo");
        }

    }
    public void eliminarVehiculo(Vehiculo vehiculo){
        listaVehiculo.remove(vehiculo);
    }

    public  void eliminarVehiculoConPatente(String patente){
        listaVehiculo.stream().filter(v->v.getPatente().equals(patente)).findAny().ifPresent(this::eliminarVehiculo);
    }
    public void determinarGanador(){
        listaVehiculo.stream().max(Comparator.comparing(Vehiculo::calcularPosicion)).ifPresent(v-> System.out.println("Vehiculo ganador " + v));
    }




}
