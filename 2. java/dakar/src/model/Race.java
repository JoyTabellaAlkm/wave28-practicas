package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Race {
    private Double distance;
    private Double dollarAward;
    private String name;
    private Integer numberOfVehiclesAllowed;
    private List<Vehicle> vehicleList;
    private final CarLifeguard carLifeguard;
    private final MotorcycleLifeguard motorcycleLifeguard;

    public Race(Double distance, Double dollarAward, String name, Integer numberOfVehiclesAllowed) {
        this.distance = distance;
        this.dollarAward = dollarAward;
        this.name = name;
        this.numberOfVehiclesAllowed = numberOfVehiclesAllowed;
        this.vehicleList = new ArrayList<>();
        this.carLifeguard = new CarLifeguard();
        this.motorcycleLifeguard = new MotorcycleLifeguard();
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getDollarAward() {
        return dollarAward;
    }

    public void setDollarAward(Double dollarAward) {
        this.dollarAward = dollarAward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfVehiclesAllowed() {
        return numberOfVehiclesAllowed;
    }

    public void setNumberOfVehiclesAllowed(Integer numberOfVehiclesAllowed) {
        this.numberOfVehiclesAllowed = numberOfVehiclesAllowed;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public boolean validateQuota(){
        return vehicleList.size() < numberOfVehiclesAllowed;
    }

    public void addCar(Double speed, Double acceleration, Double angleOfRotation, String patent){
        if (validateQuota()){
            vehicleList.add(new Car(speed, acceleration, angleOfRotation, patent));
            System.out.println("Se agregó el auto a la carrera");
        } else System.out.println("No se agregó el auto a la carrera, no hay cupos disponibles");
    }

    public void addMotorcycle(Double speed, Double acceleration, Double angleOfRotation, String patent){
        if (validateQuota()){
            vehicleList.add(new Motorcycle(speed, acceleration, angleOfRotation, patent));
            System.out.println("Se agregó la moto a la carrera");
        } else System.out.println("No se agregó la moto a la carrera, no hay cupos disponibles");
    }

    public void removeVehicle(Vehicle vehicle){
        boolean wasRemoved = vehicleList.remove(vehicle);
        if (wasRemoved) {
            System.out.println("Se eliminó el vehículo de la carrera");
        } else System.out.println("El vehículo no estaba registrado en la carrera");
    }

    public void removeVehicle(String patent){
        boolean wasRemoved = vehicleList.removeIf( vehicle -> vehicle.getPatent().equals(patent));
        if (wasRemoved) {
            System.out.println("Se eliminó el vehículo de la carrera");
        } else System.out.println("El vehículo no estaba registrado en la carrera");
    }

    public Optional<Vehicle> getRaceWinner(){
        return vehicleList.stream()
                .max(Comparator.comparingDouble( vehicle -> vehicle.getSpeed() * 0.5 * vehicle.getAcceleration() /
                        (vehicle.getAngleOfRotation() * (vehicle.getWeight() - vehicle.getWheels() * 100))));
    }

    public Optional<Vehicle> findVehicleByPatent(String patent){
        return vehicleList.stream()
                .filter(vehicle -> vehicle.getPatent().equals(patent))
                .findFirst();
    }

    public void helpCar(String patent){
        Optional<Vehicle> carToHelp = findVehicleByPatent(patent);
        if (carToHelp.isPresent()){
            if (carToHelp.get() instanceof Car){
                carLifeguard.help((Car) carToHelp.get());
            } else {
                System.out.println("\nNo se puede socorrer el auto, se solicitó un socorrista de motos");
            }
        } else {
            System.out.printf("\nEl auto con patente %s no está inscrito en la carrera\n", patent);
        }
    }

    public void helpMotorcycle(String patent){
        Optional<Vehicle> motorcycleToHelp = findVehicleByPatent(patent);
        if (motorcycleToHelp.isPresent()){
            if (motorcycleToHelp.get() instanceof Motorcycle){
                motorcycleLifeguard.help((Motorcycle) motorcycleToHelp.get());
            } else {
                System.out.println("\nNo se puede socorrer la moto, se solicitó un socorrista de autos");
            }
        } else {
            System.out.printf("\nLa moto con patente %s no está inscrita en la carrera\n", patent);
        }
    }

    @Override
    public String toString() {
        return "Race {" +
                " distance=" + distance +
                ", dollarAward=" + dollarAward +
                ", name='" + name + '\'' +
                ", numberOfVehiclesAllowed=" + numberOfVehiclesAllowed +
                ", vehicleList=" + vehicleList +
                '}';
    }
}
