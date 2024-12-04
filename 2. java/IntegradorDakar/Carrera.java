import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carrera {

    private double distancia;
    private double premioUsd;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private List<Vehiculo> vehiculos = new ArrayList<>();
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioUsd, String nombre, int cantidadVehiculosPermitidos, List<Vehiculo> vehiculos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioUsd = premioUsd;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.vehiculos = vehiculos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioUsd=" + premioUsd +
                ", nombre='" + nombre + '\'' +
                ", cantidadVehiculosPermitidos=" + cantidadVehiculosPermitidos +
                ", vehiculos=" + vehiculos +
                '}';
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
    public void altaAuto(Auto auto){
        if(vehiculos.size() < cantidadVehiculosPermitidos) {
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

    public void altaMoto(Moto moto){
        if(vehiculos.size() < cantidadVehiculosPermitidos) {
            this.vehiculos.add(moto);
            System.out.println("Se agregó la moto a la carrera");
        } else {
            System.out.println("No hay espacio en la carrera");
        }
    };

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

    //Velocidad * ½ Aceleracion / (AnguloDeGiro*(Peso-Cantidad de Ruedas * 100)
    public Vehiculo calcularGanador(){
        Vehiculo vg = vehiculos.stream().max((v1,v2) -> {
            double v1g = v1.getVelocidad() * 0.5 * v1.getAceleracion() / (v1.getAnguloGiro() * (v1.getPeso() - v1.getCantidadRuedas() * 100));
            double v2g = v2.getVelocidad() * 0.5 * v2.getAceleracion() / (v2.getAnguloGiro() * (v2.getPeso() - v2.getCantidadRuedas() * 100));
            return Double.compare(v1g,v2g);
        }).get();

        return vg;
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
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
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
}
