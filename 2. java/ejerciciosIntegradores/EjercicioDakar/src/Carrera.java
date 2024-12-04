import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Carrera{

    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listVehiculo = new ArrayList<>();
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> listVehiculo) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listVehiculo = listVehiculo;
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
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
        cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListVehiculo() {
        return listVehiculo;
    }

    public void setListVehiculo(List<Vehiculo> listVehiculo) {
        this.listVehiculo = listVehiculo;
    }

    public void darDeAltaAuto(Vehiculo vehiculo){
        if (listVehiculo.size() >= cantidadDeVehiculosPermitidos){
            System.out.println("No hay cupo");
        }
        listVehiculo.add(vehiculo);
    }

    public void darDeAltaMoto(Vehiculo vehiculo){
        if (listVehiculo.size() >= cantidadDeVehiculosPermitidos){
            System.out.println("No hay cupo");
        }
        listVehiculo.add(vehiculo);
    }

    public void socorrerAuto(Auto auto) {
        listVehiculo.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(auto.getPatente()))
                .findFirst()
                .ifPresent(vehiculo -> {
                    socorristaAuto.socorrer((Auto) vehiculo);
                });
    }

    public void socorrerMoto(Moto moto) {
        listVehiculo.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(moto.getPatente()))
                .findFirst()
                .ifPresent(vehiculo -> {
                    socorristaMoto.socorrer((Moto) vehiculo);
                });
    }

    public void eliminarVehiculo(Vehiculo vehículo){
        listVehiculo.removeIf(veh -> veh.equals(vehículo));
    }

    public void eliminarVehiculoConPatente(String patente){
        listVehiculo.removeIf(veh -> veh.getPatente() == patente);
    }

    public Vehiculo obtenerGanador(){
        return listVehiculo.stream()
                .max(Comparator.comparingDouble(
                        veh -> (veh.getVelocidad() * 0.5 * veh.getAceleracion()) /
                                (veh.getAnguloDeGiro() * (veh.getPeso() - veh.getRuedas() * 100))
                ))
                .orElse(null);
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos +
                ", listVehiculo=" + listVehiculo +
                '}';
    }

}
