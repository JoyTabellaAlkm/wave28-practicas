import java.util.List;

public class SocorristaMoto implements Socorrista {
    @Override
    public void Socorrer(String patente, List<Vehiculo> vehiculos) {
        boolean exists = vehiculos.stream().anyMatch(vehiculo -> vehiculo.getPatente().equals(patente));
        if (exists) {
            System.out.println("Socorriendo moto " + patente);
        } else {
            System.out.println("No se encontró el moto con patente " + patente);
        }
    }
}
