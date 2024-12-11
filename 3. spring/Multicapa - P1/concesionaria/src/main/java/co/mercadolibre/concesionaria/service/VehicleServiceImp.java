package co.mercadolibre.concesionaria.service;

import co.mercadolibre.concesionaria.dto.VehicleDTO;
import co.mercadolibre.concesionaria.model.Vehicle;
import co.mercadolibre.concesionaria.repository.VehicleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VehicleServiceImp implements IVehicleService{

    @Autowired
    VehicleRepository vr;
    @Autowired
    ObjectMapper om;

    @Override
    public String addVehicle(VehicleDTO vehicleDTO) {
        return vr.createVehicle(om.convertValue(vehicleDTO, Vehicle.class)).getId();
    }

    @Override
    public List<VehicleDTO> listVehicles() {
        return vr.getAll().stream().map(v -> om.convertValue(v, VehicleDTO.class)).toList();
    }

    @Override
    public List<VehicleDTO> listVehiclesByDate(LocalDate since, LocalDate to) {
        return vr.getAll().stream().filter(
                v -> v.getManufacturingDate().isAfter(since) && v.getManufacturingDate().isBefore(to))
                .map(v -> om.convertValue(v, VehicleDTO.class))
                .toList();
    }

    @Override
    public List<VehicleDTO> listVehiclesByPrice(double since, double to) {
        return vr.getAll().stream().filter(
                        v -> Double.parseDouble(v.getPrice()) >= since && Double.parseDouble(v.getPrice()) <= to)
                .map(v -> om.convertValue(v, VehicleDTO.class))
                .toList();
    }

    @Override
    public VehicleDTO getVehicle(String id) {
        return om.convertValue(vr.getVehicleById(id), VehicleDTO.class);
    }
}
