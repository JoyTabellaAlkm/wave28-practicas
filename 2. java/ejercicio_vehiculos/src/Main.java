import java.util.List;

public class Main {
    public static void main(String[] args) {
        Garaje garaje = getGaraje();

        List<Vehiculo> ordenadosPorPrecio = garaje.getVehiculos().stream()
                .sorted((v1,v2) -> Double.compare(v1.getCosto(), v2.getCosto()))
                .toList();

        List<Vehiculo> ordenadosPorMarcaYPrecio = garaje.getVehiculos().stream()
                .sorted((v1,v2) -> v1.getMarca().compareToIgnoreCase(v2.getMarca()))
                .sorted((v1,v2) -> Double.compare(v1.getCosto(), v2.getCosto()))
                .toList();

        List<Vehiculo> precioNoMayor1000 =garaje.getVehiculos().stream()
                .filter(v -> v.getCosto() <= 1000)
                .toList();

        List<Vehiculo> precioMayor1000 =garaje.getVehiculos().stream()
                .filter(v -> v.getCosto() >= 1000)
                .toList();

        double promedioVehiculos =garaje.getVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto).average()
                .getAsDouble();

        System.out.println("El promedio total de precios es: " + promedioVehiculos);

        System.out.println("Precio no mayor a 1000: ");
        precioNoMayor1000.forEach(System.out::println);

        System.out.println("Precio mayor o igual a 1000: ");
        precioMayor1000.forEach(System.out::println);

        System.out.println("Ordenados por precio: ");
        ordenadosPorPrecio.forEach(System.out::println);

        System.out.println("Ordenados por marca y precio: ");
        ordenadosPorMarcaYPrecio.forEach(System.out::println);
    }

    private static Garaje getGaraje() {
        Vehiculo fordFiesta = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo fordFocus = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo fordExplorer = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo fiatUno = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo fiatCronos = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo fiatTorino = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo chevroletAveo = new Vehiculo("Chevrolet", "Aveo", 1250);

        List<Vehiculo> vehiculos = List.of(fordFiesta,fordExplorer,fordFocus,fiatCronos,fiatTorino,fiatUno, chevroletAveo);
        Garaje garaje = new Garaje(1, vehiculos);
        return garaje;
    }
}