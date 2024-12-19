import java.util.List;

public class Carrera {

    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int CantidadDeVehiculosPermitidos;
    private List<Vehiculos> listaDeVehiculos;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos,
            List<Vehiculos> listaDeVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        CantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = listaDeVehiculos;
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
        return CantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        CantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculos> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(List<Vehiculos> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }

    @Override
    public String toString() {
        return "Carrera [distancia=" + distancia + ", premioEnDolares=" + premioEnDolares + ", nombre=" + nombre
                + ", CantidadDeVehiculosPermitidos=" + CantidadDeVehiculosPermitidos + ", listaDeVehiculos="
                + listaDeVehiculos + "]";
    }

    
    
}