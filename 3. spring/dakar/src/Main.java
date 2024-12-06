import model.Car;
import model.Motorcycle;
import model.Race;

public class Main {
    public static void main(String[] args) {

        Race race = new Race(800.5, 10000.0, "American Grand Prefix", 3);

        race.addCar(350.0, 25.3, 90.5, "ABC123");
        race.addCar(328.5, 30.0, 100.2, "ZXC098");
        race.addMotorcycle(280.0, 50.2, 79.1, "ASD765");
        race.addMotorcycle(297.5, 46.3, 85.0, "QWE387");

        race.removeVehicle("ASD765");

        race.addMotorcycle(297.5, 46.3, 85.0, "QWE387");

        race.helpCar("ABC123");
        race.helpCar("RTY987");
        race.helpMotorcycle("QWE387");
        race.helpMotorcycle("ZXC098");

        System.out.println("\nEl vehiculo ganador de la carrera es: " + (race.getRaceWinner().isPresent() ? race.getRaceWinner().get() : " no se inscribió ningún vehiculo"));

    }
}