import java.util.*;

public class Carrera {

    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private Set<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    /**
     * Constructor de la carrera
     *
     * @param distancia
     * @param premioEnDolares
     * @param nombre
     * @param cantidadDeVehiculosPermitidos
     */
    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new HashSet<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    /**
     * 0) Validar que haya cupo en la carrera
     * 1) Crear un Auto (new Auto)
     * 2) Validar que no haya sido agregado previamente
     * 3) Agregarlo a la lista de vehiculos la carrera
     *
     * @param velocidad
     * @param aceleracion
     * @param anguloDeGiro
     * @param patente
     */
    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        //0) Validar que haya cupo en la carrera
        if (!hayCupoDisponible()) {
            System.out.println("No hay cupo disponible para dar de alta un auto ");
            return;
        }

        //1) Crear un Auto (new Auto)
        Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
        //2) Validar que no haya sido agregado previamente

        //opcion 1
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo.getPatente().equals(auto.getPatente())) {
                System.out.println("El Auto ya estaba inscripto");
            }
        }

        //opcion2
        boolean contains = listaDeVehiculos.contains(auto);
        if (contains) {
            System.out.println("El Auto ya estaba inscripto");
        }

        //opcion3

        boolean agregadoCorrectamente = listaDeVehiculos.add(auto);
        if (!agregadoCorrectamente) {
            System.out.println("El Auto ya estaba inscripto");
        }

        System.out.println("Auto Agregado Automagicamente");

    }

    private Boolean hayCupoDisponible() {
        return cantidadDeVehiculosPermitidos > listaDeVehiculos.size();
    }

    // Lo hacemos igual que como resolvimos el método darDeAltaAuto()
    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        if (!hayCupoDisponible()) {
            System.out.println("No hay cupo disponible para dar de alta una moto");
            return;
        }

        Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);

        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo.getPatente().equals(moto.getPatente())) {
                System.out.println("La moto ya estaba inscripta");
            }
        }

        listaDeVehiculos.add(moto);
        System.out.println("Moto Agregada Automagicamente");
    }

    public void eliminarVehiculo(String patente) {

        Vehiculo vehiculoAEliminar = null;
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo.getPatente().equals(patente)) {
                vehiculoAEliminar = vehiculo;
            }
        }

        if (vehiculoAEliminar != null) {
            eliminarVehiculo(vehiculoAEliminar);
        } else {
            System.out.println("El vehículo solicitado para eliminar no se encuentra inscripto.");
        }
    }

    public void eliminarVehiculo(Vehiculo unVehiculo) {
        if (listaDeVehiculos.remove(unVehiculo)) {
            System.out.println("Se eliminó correctamente al vehículo: " + unVehiculo);
        } else {
            System.out.println("El vehículo: " + unVehiculo + " no se encuentra inscripto.");
        }
    }

    public void socorrerAuto(String patente) {
        Auto autoASocorrer = null;
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo.getPatente().equals(patente) && vehiculo instanceof Auto) {
                autoASocorrer = (Auto) vehiculo;
            }
        }

        if (autoASocorrer != null) {
            socorristaAuto.socorrer(autoASocorrer);
        } else {
            System.out.println("No existe auto con la patente especificada para ser socorrido.");
        }
    }

    public void socorrerMoto(String patente) {
        Moto motoASocorrer = null;
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo.getPatente().equals(patente) && vehiculo instanceof Moto) {
                motoASocorrer = (Moto) vehiculo;
            }
        }

        if (motoASocorrer != null) {
            socorristaMoto.socorrer(motoASocorrer);
        } else {
            System.out.println("No existe moto con la patente especificada para ser socorrido.");
        }
    }

}
