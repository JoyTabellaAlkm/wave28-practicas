package Modelo;

import java.util.List;

public class Carrera {
    private Double distancia;
    private Integer premioDolares;
    private String nombre;
    private Integer cantidadVehiculosPermitidos;
    private List<Vehiculo> vehiculos;

    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Integer getPremioDolares() {
        return premioDolares;
    }

    public void setPremioDolares(Integer premioDolares) {
        this.premioDolares = premioDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadVehiculosPermitidos() {
        return cantidadVehiculosPermitidos;
    }

    public void setCantidadVehiculosPermitidos(Integer cantidadVehiculosPermitidos) {
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Carrera(Double distancia, Integer premioDolares, String nombre, Integer cantidadVehiculosPermitidos, List<Vehiculo> vehiculos) {
        this.distancia = distancia;
        this.premioDolares = premioDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.vehiculos = vehiculos;
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public Carrera() {
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

    public void darDealtaAuto(Double velocidad, Double aceleracion, Double anguloGiro, String patente){
        if(this.vehiculos.size()+1 <= this.cantidadVehiculosPermitidos){
            Auto auto = new Auto(velocidad,aceleracion,anguloGiro,patente);
            this.vehiculos.add(auto);
            System.out.println("Se ha agregado un auto");
        }else{
            System.out.println("No hay cupo para agregar el auto");
        }
    }
    public void darDealtaMoto(Double velocidad, Double aceleracion, Double anguloGiro, String patente){
        if(this.vehiculos.size()+1 <= this.cantidadVehiculosPermitidos){
            Moto moto = new Moto(velocidad,aceleracion,anguloGiro,patente);
            this.vehiculos.add(moto);
            System.out.println("Se ha agregado un moto");
        }else{
            System.out.println("No hay cupo para agregar el moto");
        }
    }
    public void eliminarVehiculo(Vehiculo vehiculo){
        this.vehiculos.remove(vehiculo);
        System.out.println("Se elimina el vehiculo");
    }
    public void eliminarVehiculoConPatente(String patente){
        this.vehiculos = this.vehiculos.stream().filter(v -> v.getPatente().equals(patente)).toList();
        System.out.println("Se elimina el vehiculo con patente");
    }
    public void definirGanador(){
        this.vehiculos.forEach(v -> System.out.println(v.calcularLlegada() +" "+ v.getPatente()));
        Vehiculo vehiculo = this.vehiculos.stream()
                .sorted((v1,v2) -> Double.compare(v2.calcularLlegada(),v1.calcularLlegada()))
                .toList().get(0);
        System.out.println("El ganador de la carrera es el vehiculo con patente: "+vehiculo.getPatente());
    }
    public void socurrerAuto(String patente){
        Auto auto = (Auto) this.vehiculos.stream().filter(v -> v.getPatente().equals(patente)).toList().get(0);
        socorristaAuto.socorrer(auto);
    }
    public void socurrerMoto(String patente){
        Moto moto = (Moto) this.vehiculos.stream().filter(v -> v.getPatente().equals(patente)).toList().get(0);
        socorristaMoto.socorrer(moto);
    }
}
