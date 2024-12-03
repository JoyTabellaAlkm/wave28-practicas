import java.util.List;
import java.util.random.RandomGenerator;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadVehiculos;
    private List<Vehiculo> listaVehiculos;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadVehiculos, List<Vehiculo> listaVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculos = cantidadVehiculos;
        this.listaVehiculos = listaVehiculos;
    }

    public void darDeAltaAuto(Double velocidad,Double aceleracion, Double anguloDeGiro,String patente){
        if(listaVehiculos.size()< cantidadVehiculos){
            listaVehiculos.add(new Auto(velocidad,aceleracion, anguloDeGiro,patente));
            System.out.println("Se agrego a la carrera el auto con patente: "+ patente);
        }else{
            System.out.println("No se pudo agregar el auto");
        }
    }

    public void darDeAltaMoto(Double velocidad,Double aceleracion, Double anguloDeGiro,String patente){
        if(listaVehiculos.size()< cantidadVehiculos){
            listaVehiculos.add(new Moto(velocidad,aceleracion, anguloDeGiro,patente));
            System.out.println("Se agrego a la carrera la moto con patente: "+ patente);
        }else{
            System.out.println("No se pudo agregar la moto");
        }
    }
    public Vehiculo getGanador(){
        return listaVehiculos.stream().sorted((v1,v2)->Double.compare(v1.getPerformance(),v2.getPerformance())).findFirst().orElse(null);
    }
    public void eliminarVehiculo(Vehiculo v){
        listaVehiculos.remove(v);
    }
    public void eliminarVehiculo(String patente){
        //this.listaVehiculos= listaVehiculos.stream().filter((v)->!v.getPatente().equals(patente)).toList();
       Vehiculo vehiculoEliminado = listaVehiculos.stream().filter(v->v.getPatente().equals(patente)).findFirst().get();
       this.eliminarVehiculo(vehiculoEliminado);
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(Double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadVehiculos() {
        return cantidadVehiculos;
    }

    public void setCantidadVehiculos(Integer cantidadVehiculos) {
        this.cantidadVehiculos = cantidadVehiculos;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

}
