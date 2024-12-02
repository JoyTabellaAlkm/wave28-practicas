
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

        // Agregar vehículos a la lista
        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950));

        Garage garage = new Garage(1);
        garage.setVehiculos(vehiculos);

        List<Vehiculo> vehiculosOrdenadosPorPrecio =  garage.getVehiculos()
                .stream()
                .sorted( (v1, v2) -> v1.getCosto() - v2.getCosto())
                .toList();

        System.out.println("--- Vehiculos ordenados por precio ---");
        vehiculosOrdenadosPorPrecio.forEach(vehiculo -> System.out.println(vehiculo.toString()));

        List<Vehiculo> vehiculosOrdenadosPorMarcaYPrecio =  garage.getVehiculos().stream()
                .sorted( (v1, v2) -> {


                    int i = v1.getMarca().compareTo(v2.getMarca());
                    if(i != 0) {
                        return i;
                    } else {
                        return  v1.getCosto() - v2.getCosto();
                    }

                }).collect(Collectors.toList());

        System.out.println("--- Vehiculos ordenados por marca y precio ---");
        vehiculosOrdenadosPorMarcaYPrecio.forEach(vehiculo -> System.out.println(vehiculo.toString()));


        System.out.println("--- Vehiculos con costo menor a $1000 ---");
        List<Vehiculo> vehiculosCostoMenorAMil =  garage.getVehiculos().stream()
                .filter( vehiculo -> vehiculo.getCosto() < 1000).toList();
        vehiculosCostoMenorAMil.forEach(vehiculo -> System.out.println(vehiculo.toString()));

        System.out.println("--- Vehiculos con costo mayor a $1000---");
        List<Vehiculo> vehiculosCostoMayorAMil =  garage.getVehiculos().stream()
                .filter( vehiculo -> vehiculo.getCosto() > 1000).toList();
        vehiculosCostoMayorAMil.forEach(vehiculo -> System.out.println(vehiculo.toString()));

        System.out.println("--- Promedio costo vehiculos ---");
        double promedioCostosVehiculos =  garage.getVehiculos().stream().mapToInt(Vehiculo::getCosto).average().getAsDouble();
        System.out.println("El promedio es: $" + promedioCostosVehiculos);

    }
}

class Vehiculo {
    String marca;
    String modelo;
    int costo;

    public Vehiculo(String marca, String modelo, int costo) {
        this.marca = marca;
        this.modelo = modelo;
        this.costo = costo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", costo=" + costo +
                '}';
    }
}

class Garage {
    int id;
    List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

    public Garage(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}