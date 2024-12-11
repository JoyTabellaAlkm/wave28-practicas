package co.mercadolibre.concesionaria.repository;

import co.mercadolibre.concesionaria.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {
    List<Vehicle> vehicleList = new ArrayList<>();

    public Vehicle createVehicle(Vehicle vehicle){
        vehicle.setId(String.valueOf(vehicleList.size()+1));
        vehicleList.add(vehicle);
        return  vehicle;
    }

    public List<Vehicle> getAll() {
        return vehicleList;
    }

    public Vehicle getVehicleById(String id) {
        return vehicleList.stream().filter(v->v.getId().equals(id)).findFirst().orElse(null);
    }
}
